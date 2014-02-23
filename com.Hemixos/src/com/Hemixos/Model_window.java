package com.Hemixos;

import java.awt.Dimension;
import java.awt.Point;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import properties.AbstractPropKey;
import properties.AbstractValues;
import properties.PropertiesLoader;
import ucc.ActionVolet;
import exceptions.FatalException;


public class Model_window {

	
	
	/*
	 * LOADED DATA
	 */
	
	// Main model
	private Model model;
	private JFrame frame;
	
	private final ArrayList<ChangeListener> listeVues;

	
	
	// property files
	private Properties main;
	private Properties language;
	
	// config properties
	private String appName;
	private String appVersion;
	
	// Jframe properties
	private int frameWidth;
	private int frameHeight;
	private boolean isMaximized;
	
	// prog state
	private boolean voletOuvert;
	private boolean voletEnAction;
	
	// Vues
	public static final int SIMPLE_LIST = 1;
	public static final int ONE_COL_LIST = 2;
	public static final int TWO_COL_LIST = 3;
	public static final int TRIPLE_LIST = 4;

	private int vueSelected;
	private int borderTampon;
	
	
	
	/**
	 * Constructor
	 * @param model 
	 */
	public Model_window(Model model) {
		this.model = model;
		this.listeVues = new ArrayList<ChangeListener>();
		this.voletOuvert = true;
	}
	
	

	/**
	 * Enregistre un listener
	 * 
	 * @param chl Le listener à enregistrer
	 */
	public final synchronized void addChangeListener(final ChangeListener chl) {
		if (!listeVues.contains(chl)) {
			listeVues.add(chl);
		}
	}
	
	/**
	 * Notifie les listeners
	 * 
	 * @param e L'événement à notifier aux listeners
	 */
	public final synchronized void traiterEvent(final ChangeEvent e) {
			
		for (final ChangeListener listener : listeVues) {
			listener.stateChanged(e);
		}
		frame.revalidate();
	}
	
	
	
	
	/*
	 * Loading DATA
	 */
	/**
	 * Load the default data from the properties files
	 * @param pl PropertiesLoader
	 * @throws Exception uncatch exception
	 */
	public void setConfigData(PropertiesLoader pl) throws FatalException {
		
		// Properties files
		try {

			
			/*
			 *  Load MAIN properties
			 */

		    //to load application's properties, we use this class
		    main = new Properties();

		    FileInputStream configFile;
		    //the base folder is ./, the root of the main.properties file 
		    String mainPath = AbstractPropKey.FILE_PATH_CONFIG;

		    //load the file handle for main.properties
		    configFile = new FileInputStream(mainPath);
		    //load all the properties from this file
		    main.load(configFile);
		    //we have loaded the properties, so close the file handle
		    configFile.close();
			
			
			

			
			
			
			//main = pl.loadProperties(PropertiesLoader.MAIN_PROPERTIES);

			appName = (String) main.get(AbstractPropKey.appNamePF);

			appVersion = (String) main.get(AbstractPropKey.appVersionPF);
			//installRep = (String) main.get("installrep");
			frameWidth = Integer.parseInt((String) main.get(AbstractPropKey.frameWidthPF));
			frameHeight = Integer.parseInt((String) main.get(AbstractPropKey.frameHeightPF));
			
			String codeLangue = (String) main.get("language");



			
			
		    /*
		     * Load LANGUAGE file
		     */
			
		    //to load application's properties, we use this class
		    language = new Properties();

		    FileInputStream file;
		    //the base folder is ./, the root of the main.properties file 
		    String languagePath = "./" + main.get(AbstractPropKey.FOLDER_LANGUAGE) + "/" + codeLangue + "_language.properties";
		    
		    System.out.println("lang config file: " + languagePath);
		    
		    
		    //load the file handle for main.properties
		    file = new FileInputStream(languagePath);
		    //load all the properties from this file
		    language.load(file);
		    //we have loaded the properties, so close the file handle
		    file.close();
			

			//language = pl.loadProperties(PropertiesLoader.LANGUAGE_REP + codeLangue + PropertiesLoader.LANG_PROPERTIES);

		} catch (Exception e) {
			e.printStackTrace();
			throw new FatalException(AbstractValues.FATAL_ERROR_LOADING_CONFIG_FILES);
		}
	
	}

	

	/*
	 * Application life cycle methods
	 */
	
	/**
	 * When quitting
	 */
	public void actionExit() {

		// TODO save all prop files
		
		// TODO save data files 
		
		// TODO close every file
		
		System.exit(1);
		
	}
	
	/**
	 * Lorsque la fenêtre est maximisée
	 */
	public void actionMaximize() {
		if (!isMaximized) {
			getFrame().setExtendedState(getFrame().getExtendedState() | JFrame.MAXIMIZED_BOTH);
			isMaximized = true;
		} else {
			System.out.println("lol");
			getFrame().setExtendedState(JFrame.NORMAL);
			isMaximized = false;
		}
	}
	
	public void actionMinimize() {
		getFrame().setExtendedState(getFrame().getExtendedState() | JFrame.ICONIFIED);
	}

	public void actionEscape() {
		actionExit();
	}

	public void actionTouch() {
		// TODO Auto-generated method stub
		System.out.println("touch");
	}

	public void actionOption() {
		// TODO Auto-generated method stub
		System.out.println("options");
	}
	

	public void actionResize() {
		setFrameWidth(frame.getWidth());
		repaintHeadSpacers();
		model.getMc().jpInfo.repaint();
		
		frame.revalidate();
		traiterEvent(new ChangeEvent(this));
	}

	
	/**
	 * Ajuste la preferredSize des jpHeadSpacers pour centrer le HeadInfo.
	 */
	private void repaintHeadSpacers() {
		JPanel jpHDL = model.getMc().jpHeadSpacerLeft;
		JPanel jpHDR = model.getMc().jpHeadSpacerRight;

		int dhWidth;
		
		dhWidth = ((frameWidth - 420) / 6);
		
		borderTampon = dhWidth;
		
		jpHDL.setPreferredSize(new Dimension(dhWidth, 0));
		jpHDR.setPreferredSize(new Dimension(dhWidth, 0));
	}
	
	
	/**
	 * informe la fenetre d'info de la taille qu'elle peut prendre
	 * @return
	 */
	public int getInfoWidth() {
			return borderTampon*4;
	}



	/**
	 * @return the borderTampon
	 */
	public int getBorderTampon() {
		return borderTampon;
	}



	public void actionVolet() {
		new ActionVolet(model);
	}


	public void actionAddPlaylist() {
		// TODO
		
		//model.getMp().setAddToPL(!model.getMp().isAddToPL());
		//model.getMc().playerVolet.stateChanged(null);
	}
	

	
	public void actionRandom() {
		model.getMp().setRandom(!model.getMp().isRandom());
		model.getMc().jpVolume.stateChanged(null);
	}



	public void actionRepeat() {
		model.getMp().setRepeat(!model.getMp().isRepeat());
		model.getMc().jpVolume.stateChanged(null);
	}



	/*
	 * ACTION VUES
	 */
	public void actionViewSimpleList() {
		this.vueSelected = SIMPLE_LIST;
		//if (model.getMd().getSelectedArtist() != -1)
		//	model.getMd().setSelectedArtist(-1);
		//model.getMc().gmm_Container.setViewContent(new Gmm_VueSimple(model));
		traiterEvent(new ChangeEvent(this));
	}
	
	public void actionViewOneList() {
		this.vueSelected = ONE_COL_LIST;
		//model.getMc().gmm_Container.setViewContent(new Gmm_VueOne(model));	
		traiterEvent(new ChangeEvent(this));
	}

	public void actionViewTwoList() {
		this.vueSelected = TWO_COL_LIST;

		// TODO Auto-generated method stub
		
	}

	public void actionViewThreeList() {
		this.vueSelected = TRIPLE_LIST;

		// TODO Auto-generated method stub
		
	}
	
	
	
	/*
	 * GET properties
	 */
	public String getMainProperty(String key) {
		return main.getProperty(key);
	}
	public String getLangProperty(String key) {
		return language.getProperty(key);
	}
	
	/*
	 * SET property
	 */
	public void setMainProperty(String key, String value) {
		main.setProperty(key, value);
	}

	
	
	
	

	/*
	 * GETTERS and SETTERS
	 * 
	 * ! setters need to save changes in properties objects !
	 */
	
	public int getFrameWidth() {
		return frameWidth;
	}

	public void setFrameWidth(int frameWidth) {
		if (frameWidth > AbstractValues.FRAME_MIN_WIDTH) {
			this.frameWidth = frameWidth;
			main.setProperty(AbstractPropKey.frameWidthPF, frameWidth+"");
		}
	}

	public int getFrameHeight() {
		return frameHeight;
	}

	public void setFrameHeight(int frameHeight) {
		if (frameWidth > AbstractValues.FRAME_MIN_HEIGHT) {
			this.frameHeight = frameHeight;
			main.setProperty(AbstractPropKey.frameHeightPF, frameHeight+"");
		}
	}

	public String getAppName() {
		return appName;
	}


	public String getAppVersion() {
		return appVersion;
	}





	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @param frame the frame to set
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public void setFramePosition(Point location) {
		getFrame().setLocation(location);
	}



	/**
	 * @return the voletEnAction
	 */
	public boolean isVoletEnAction() {
		return voletEnAction;
	}



	/**
	 * @param voletEnAction the voletEnAction to set
	 */
	public void setVoletEnAction(boolean voletEnAction) {
		this.voletEnAction = voletEnAction;
	}



	/**
	 * @return the voletOuvert
	 */
	public boolean isVoletOuvert() {
		return voletOuvert;
	}



	/**
	 * @param voletOuvert the voletOuvert to set
	 */
	public void setVoletOuvert(boolean voletOuvert) {
		this.voletOuvert = voletOuvert;
	}



	public int getVueSelected() {
		return vueSelected;
	}



	public void setSelectedArtist(int selectedIndex) {
		
		model.getMd().setSelectedArtist(selectedIndex);
		
		traiterEvent(null);
	}



		
}
