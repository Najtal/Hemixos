package gui_launcher;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.net.ConnectException;
import java.util.Collection;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import layer_manager.ApiManager;
import library.Library;
import library.Song;
import properties.AbstractColors;
import properties.AbstractImages;
import properties.AbstractPropKey;
import properties.AbstractValues;
import properties.PropertiesLoader;
import vlcEngine.PlayerManager;

import com.Hemixos.Hemixos_Launcher;
import com.Hemixos.Model;

import exceptions.FatalException;
import exceptions.UndefineGoogleManagerAPI;
import exceptions.UnselectedLibraryException;
import files.LibraryManager;
import gmusic.api.model.Playlists;
import gmusic.api.skyjam.model.Track;
import gui_music_manager.Gmm_Window;


/**
 * Cette classe affiche la fenetre de chargement et charge tous les elements nécessaires a l'application
 * 
 * Cette classe est indépendante de tout fichier de configuration.
 * 
 * @author Jean-Vital
 *
 */
public class Main_guiLauncher extends JFrame {

	
	private static final long serialVersionUID = 1L;
	
	
	/*
	 * Elements de la fenetre
	 */
	private static final int JF_WIDTH = 410;
	private static final int JF_HEIGHT = 140;
	
	private static final int PROGRESS_BAR_HEIGHT = 7;
	private int progress_bar_evo = 0;
	
	private static final String APP_NAME = "HEMIXOS";

	private JProgressBar progressBar;
	private JLabel jlInfo;
	private JLabel titre;
	
	
	/*
	 * Elements de data
	 */
	private int nbrElemACharger = 6;
	
	private Model model;
	private JFrame musicManager;
	private PropertiesLoader pl;


	private NewLib newLib;
	
	
	
	/**
	 * Constructor, generate loading window and load components
	 * @throws Exception 
	 */
	public Main_guiLauncher() throws Exception {

		// On génère la fenêtre de chargement
		this.setSize(new Dimension(JF_WIDTH, JF_HEIGHT));
		this.setResizable(false);
		this.getContentPane().setBackground(AbstractColors.BACKGROUND_LAUNCHER);
		this.setUndecorated(true);

		// TODO
		Image icg = new ImageIcon(ImageIO.read(this.getClass().getResourceAsStream("/images/ico_coinGauche.png"))).getImage();
		this.setIconImage(icg);
		
		
		// ajoute tout le contenu de la fenetre de chargement
		addContentToFrame();
		
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
				
		/*
		 * On charge et on configure
		 */

		loadModel();
		
		loadProperties();
		
		loadImages();
		
		loadMediaManager();	
		
		loadLibrary();
			
		//endProcess();
	}

	
	/**
	 * Instantiate the models
	 */
	private void loadModel() {
		jlInfo.setText("Loading applciation model");
		model = new Model();
		progressBar.setValue(progress_bar_evo++);		
	}

	/**
	 * Load the datas from the XML files
	 */
	private void loadProperties() {
		jlInfo.setText("Loading properties");
		pl = new PropertiesLoader();
		model.getMw().setConfigData(pl);
		progressBar.setValue(progress_bar_evo++);		
	}
	
	/**
	 * Instantiate the images
	 */
	private void loadImages() {
		jlInfo.setText("Initialize graphic components");
		AbstractImages.initialize();
		progressBar.setValue(progress_bar_evo++);		
	}
	
	/**
	 * Instantiate the media manager (vlc)
	 */
	private void loadMediaManager() {
		jlInfo.setText("Loading media manager");
		try {
					
			if (Hemixos_Launcher.DEBUG) {
				// en prod
				// TODO	
				System.out.println(model.getMw().getMainProperty("load media manager from : C:\\Program Files\\VideoLAN\\VLC"));
				model.getMp().setPm(new PlayerManager("C:\\Program Files\\VideoLAN\\VLC", model));	
				//System.out.println(model.getMp().getPm().toString());
			} else {
				// pour du vrai
				// TODO	
				System.out.println(model.getMw().getMainProperty("load media manager from : " + AbstractPropKey.pmSourceFolder));
				model.getMp().setPm(new PlayerManager(model.getMw().getMainProperty(AbstractPropKey.pmSourceFolder), model));			
			}
			
		} catch (Exception e) {
			throw new FatalException(AbstractValues.FATAL_ERROR_LOADING_PLAYER_MANAGER);
		}			
		progressBar.setValue(progress_bar_evo++);			
	}

	/**
	 * Load library if already exist, otherwise, open welcome manager
	 */
	private void loadLibrary() {


		// On charge la librairie dans le model
		jlInfo.setText("Loading library");
		
		Library l = LibraryManager.loadLibrary(model);

		System.out.println("library = " + l);
		
		if (l != null) {
			progressBar.setValue(progress_bar_evo++);
			// Librairie existe
			model.getMd().addLib(l);
					
			// On se connecte
			jlInfo.setText("Connecting to library...");
			
			try {
				model.getMd().connectToGM();
			} catch (ConnectException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			

			progressBar.setValue(progress_bar_evo++);
			
			endProcess();
			
		} else {
			// Librairie n'existe pas
			System.out.println("New Library");
			jlInfo.setText("New library");
			
			// on va créer une nouvelle librairie
			newLibrary();
			
			progressBar.setValue(progress_bar_evo++);

		}
	}



	protected void endProcess() {
				
		jlInfo.setText("Generating application");
		progressBar.setValue(progress_bar_evo++);

		/*
		 * Tout est chargé, on charge la fenetre principale
		 */
		//musicManager = new MusicManager_Frame(model);
		musicManager = new Gmm_Window(model);
		
		
		/*
		 * Une fois chargée, on quit et on inverse la visibilité
		 */
		musicManager.setVisible(true);
		this.dispose();
	}
	

	/**
	 * Affiche les éléments pour enregistrer une nouvelle librairie
	 */
	private void newLibrary() {
		
		// On agrandi joliment la frame
		for (int i = 0; i < AbstractValues.NEW_LIB_FRAME_HEIGHT; i++) {
			this.setSize(this.getWidth(), this.getHeight()+1);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				this.setSize(this.getWidth(), JF_HEIGHT+AbstractValues.NEW_LIB_FRAME_HEIGHT);
				break;
			}
		}
		
		titre.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
		
		
		/*
		 * JPanel d'input
		 */
		newLib = new NewLib(model, this);
				
		this.add(newLib, BorderLayout.CENTER);
		this.revalidate();
	}



	
	/*
	 * Connect to Google music account
	 
	private void connectToGM() {
		try {
			model.getMd().connectToGM();
		} catch (ConnectException e) {
			JOptionPane.showMessageDialog(null, model.getMw().getLangProperty(AbstractPropKey.NEW_LIBRARY_UNABLE_TO_CONNECT));
		}		
	}*/

	/*
	 * Login to the Google music account
	 
	private void loginToGM() {
		try {
			model.getMd().getGm().login();
		} catch (UndefineGoogleManagerAPI e) {
			JOptionPane.showMessageDialog(null, model.getMw().getLangProperty(AbstractPropKey.NEW_LIBRARY_UNABLE_TO_CONNECT));
		}
	}*/

	/**
	 * Génère le contenu de la fenêtre de chargement
	 */
	private void addContentToFrame() {
		
		// Ajout texte
		titre = new JLabel(APP_NAME);
		titre.setFont(new Font("Segoe UI", Font.BOLD, 50));
		titre.setForeground(AbstractColors.MAIN_TITLE);
		titre.setHorizontalAlignment(SwingConstants.CENTER );
		titre.setBorder(BorderFactory.createEmptyBorder(30, 0, 50, 0));

		
		this.add(titre, BorderLayout.NORTH);
		
		JPanel jpEvo = new JPanel(new BorderLayout());

		jlInfo = new JLabel();
		jlInfo.setFont(new Font("Segoe UI", Font.BOLD, 10));
		jlInfo.setForeground(AbstractColors.LAUNCHER_INFO_EVO);
		
		// Ajout barre de chargement et texte		
		progressBar = new JProgressBar(0, nbrElemACharger);
		progressBar.setValue(0);
		progressBar.setBorderPainted(false);
		progressBar.setStringPainted(false);
		progressBar.setForeground(AbstractColors.MAIN_TITLE);
		progressBar.setPreferredSize(new Dimension(JF_WIDTH, PROGRESS_BAR_HEIGHT));
		
		jpEvo.add(jlInfo);
		jpEvo.add(progressBar, BorderLayout.SOUTH);
		
		this.add(jpEvo, BorderLayout.SOUTH);
	}



	public void createNewLib(String nom, String user, String mdp) {

		// TODO
		System.out.println("Cree une nouvelle lib");
		
		// On masque les éléments
		newLib.logMessage.setText(model.getMw().getLangProperty(AbstractPropKey.NEW_LIBRARY_CONNECTING));
				
		// On se connecte
		try {
			ApiManager a = new ApiManager(user, mdp);
			model.getMd().setGm(a);
			//model.getMd().getGm().login();
		} catch (Exception e) {
			System.out.println("ERROR : impossible de se connecter");
			newLib.logMessage.setText(model.getMw().getLangProperty(AbstractPropKey.NEW_LIBRARY_UNABLE_TO_CONNECT));
			e.printStackTrace();

			return;
		}
		
		newLibraryConnected(nom, user, mdp);
				
	}
	
	
	private void newLibraryConnected(String nom, String user, String mdp) {
		
		// TODO
		System.out.println("newLib");
		
		/* On referme joliment la frame
		this.getContentPane().removeAll();
		this.repaint();
		
		
		for (int i = 0; i < AbstractValues.NEW_LIB_FRAME_HEIGHT; i++) {
			this.setSize(this.getWidth(), this.getHeight()-1);
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				this.setSize(this.getWidth(), JF_HEIGHT);
				break;
			}
			
		}*/

		
		jlInfo.setText(model.getMw().getLangProperty(AbstractPropKey.NEW_LIBRARY_GET_LIB));
		
		Library lib = new Library(nom, user, mdp);
		model.getMd().addLib(lib);
		model.getMd().setCurrentLibrary(lib);

		// On récupère les données
		Collection<gmusic.api.model.Song> songs = null;
		Playlists playlist = null;
		try {
			
			System.out.println("Get all songs");
						
			songs = model.getMd().getGm().getAllSongs();
			System.out.println("tracks \tok");

			//playlist = model.getMd().getGm().getAllplaylist();
			//System.out.println("playlists \tok");
		
		} catch (Exception e) {
			jlInfo.setText(model.getMw().getLangProperty(AbstractPropKey.NEW_LIBRARY_UNABLE_TO_GET_LIBRARY));
			System.out.println("error : Can't GET track or playlist");
			e.printStackTrace();
		}
		
		jlInfo.setText(model.getMw().getLangProperty(AbstractPropKey.NEW_LIBRARY_LIB_TRAITEMENT));
		
		// On ajoute les Tracks
		try {
			int nxb = lib.addSongCollection(songs);
			System.out.println(nxb + " songs added to library");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// On ajoute les playlists
		// TODO
		//lib.addPlaylists(playlist);
				
		
		jlInfo.setText(model.getMw().getLangProperty(AbstractPropKey.NEW_LIBRARY_SAVE_LIB));
		
		try {
			LibraryManager.saveLibrary(model, model.getMd().getLib());
			System.out.println("library saved");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnselectedLibraryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO
		System.out.println("File saved");
		
		try {
			JOptionPane.showMessageDialog(null, model.getMd().getLib().getNbrTitres() + " " + model.getMw().getLangProperty(AbstractPropKey.NEW_LIBRARY_HAS_BEEN_ADDED));
		} catch (HeadlessException | UnselectedLibraryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("end process");
		
		
		// END PROCESS !
		endProcess();
	}
	
	
	
	/*
	 * GETTERS and SETTERS
	 */
	public Model getModel() {
		return model;
	}



	

}
