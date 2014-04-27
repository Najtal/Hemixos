package gui_launcher;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.util.Collection;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
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
	private static final int JF_WIDTH = 175;
	private static final int JF_HEIGHT = 175;
	
	private static final int PROGRESS_BAR_HEIGHT = 7;
	private int progress_bar_evo = 0;
	
	private static final String APP_NAME = "HEMIXOS";

	private int nbrElemACharger = 6;
	private JProgressBar progressBar;
	private JLabel jlInfo;
	private JLabel titre;
	private Color background;
	
	
	/*
	 * Elements de data
	 */	
	private Model model;
	private JFrame musicManager;
	private PropertiesLoader pl;

	private JDialog newLib;
		
	/**
	 * Constructor, generate loading window and load components
	 * @throws Exception 
	 */
	public Main_guiLauncher() throws Exception {

		this.background = new Color(52, 56, 59);
		
		// On génère la fenêtre de chargement
		this.setSize(new Dimension(JF_WIDTH, JF_HEIGHT));
		this.setResizable(false);
		this.getContentPane().setBackground(this.background);
		this.setUndecorated(true);

		// Imge de la splash screen
		Image icg = new ImageIcon(ImageIO.read(this.getClass().getResourceAsStream("/images/ico_coinGauche.png"))).getImage();
		this.setIconImage(icg);
		
		// ajoute tout le contenu de la fenetre de chargement
		addContentToFrame();
		
		// Finalisation des vues de la page
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
	 * Génère le contenu de la fenêtre de chargement
	 */
	private void addContentToFrame() {
		
		// Structure JPANELS
		JPanel jpNorth = new JPanel(new BorderLayout());
		JPanel jpCenter = new JPanel(new BorderLayout());
		JPanel jpSouth = new JPanel(new BorderLayout());
		
		jpNorth.setBackground(this.background);
		jpCenter.setBackground(this.background);
		jpSouth.setBackground(this.background);
		
		this.add(jpNorth, BorderLayout.NORTH);
		this.add(jpCenter);
		this.add(jpSouth, BorderLayout.SOUTH);
		
		
		// TITRE
		titre = new JLabel(APP_NAME);
		titre.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		titre.setForeground(new Color(73, 73, 73));
		//titre.setHorizontalAlignment(SwingConstants.RIGHT );
		titre.setBorder(BorderFactory.createEmptyBorder(10, 20, 0, 0));

		jpNorth.add(titre, BorderLayout.WEST);

		
		// ICON
		ImageIcon ii = null;
		try {
			ii = new ImageIcon(ImageIO.read(this.getClass().getResourceAsStream("/images/ico_splash_icon.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel jlIcon = new JLabel(ii);
		jlIcon.setPreferredSize(new Dimension(100, 100));
		
		jpCenter.add(jlIcon);
		
		
		// Chargement

		jlInfo = new JLabel();
		jlInfo.setFont(new Font("Segoe UI", Font.BOLD, 10));
		jlInfo.setForeground(new Color(73, 73, 73));
		
		// Ajout barre de chargement et texte		
		progressBar = new JProgressBar(0, nbrElemACharger);
		progressBar.setBackground(this.background);
		progressBar.setValue(0);
		progressBar.setBorderPainted(false);
		progressBar.setStringPainted(false);
		progressBar.setForeground(new Color(255, 0, 100));
		progressBar.setPreferredSize(new Dimension(JF_WIDTH, PROGRESS_BAR_HEIGHT));
		
		jpSouth.add(jlInfo);
		jpSouth.add(progressBar, BorderLayout.SOUTH);
		
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
				System.out.println(model.getMw().getMainProperty("load media manager from : C:\\Program Files\\VideoLAN\\VLC"));
				model.getMp().setPm(new PlayerManager("C:\\Program Files\\VideoLAN\\VLC", model));	
			} else {
				// pour du vrai	
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
		
		if (l != null) {
			
			ApiManager a = new ApiManager(l.getUserName(), l.getPassword());
			model.getMd().setGm(a);
			
			newLibraryConnected(l.getLibraryName(), l.getUserName(), l.getPassword());
			
			/*
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
			}*/			

			progressBar.setValue(progress_bar_evo++);
			//endProcess();
			
		} else {
			// Librairie n'existe pas
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
	 * Affiche la Jdialog pour enregistrer une nouvelle librairie
	 */
	private void newLibrary() {
				
		/*
		 * JPanel d'input
		 */
		//newLib = new NewLib(model, this);
		//newLib.setVisible(true);
			
		InitProgram.showSimpleDialog(this, model, this);
		
		///this.add(newLib, BorderLayout.CENTER);
		//this.revalidate();
	}


	/*public void createNewLib(String nom, String user, String mdp) {

		// On se connecte
		try {
			ApiManager a = new ApiManager(user, mdp);
			model.getMd().setGm(a);
			//model.getMd().getGm().login();
		} catch (Exception e) {
			System.out.println("ERROR : impossible de se connecter");
			//newLib.logMessage.setText(model.getMw().getLangProperty(AbstractPropKey.NEW_LIBRARY_UNABLE_TO_CONNECT));
			e.printStackTrace();
			return;
		}
		
		newLibraryConnected(nom, user, mdp);
				
	}*/
	
	
	void newLibraryConnected(String nom, String user, String mdp) {
		
		
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

			// TODO Récupérer les playlists
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
		
		// TODO ajouter les playlists
		//lib.addPlaylists(playlist);
				
		jlInfo.setText(model.getMw().getLangProperty(AbstractPropKey.NEW_LIBRARY_SAVE_LIB));
		
		/*
		 * SAVE FILE
		 */
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
		

		/*
		try {
			JOptionPane.showMessageDialog(null, model.getMd().getLib().getNbrTitres() + " " + model.getMw().getLangProperty(AbstractPropKey.NEW_LIBRARY_HAS_BEEN_ADDED));
		} catch (HeadlessException | UnselectedLibraryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
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
