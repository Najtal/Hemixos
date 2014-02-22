package com.Hemixos;
import gui_launcher.Main_guiLauncher;

import java.io.IOException;
import java.lang.Thread.UncaughtExceptionHandler;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 * Classe principale. Elle charge le DefaultUncaughtExceptionHandler et se charge de lancer
 * les classes de chargement des paramètres et autres images et proprietés
 * 
 * @author Jean-Vital
 *
 */
public class Hemixos_Launcher {

	/*
	 * Ne ferme pas l'application si TRUE
	 */
	public static final boolean DEBUG = true;
	
	// FatalError message
	private final static String ERREUR_CRITIQUE = "The program has encountered a critical error. We apologize for the inconvenience.";

	private static Main_guiLauncher mgl;
		
	
	
	
	
	/**
	 * Main methode: lance l'application
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		setExceptionHandler();
		mgl = new Main_guiLauncher();
		
	}
	
	
	/**
	 * On charge le Fatal exceptions handler
	 */
	private static void setExceptionHandler() {
		Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(final Thread arg0, final Throwable arg1) {
				
				// Affiche l'erreur dans la console
				System.err.println("message: " + arg1.getMessage() + "\n print stack trace : \n");
				arg1.printStackTrace();
	
				// Affiche un pop avertissant l'utilisateur de la cloture du programme
	
				// On charge l'image de bug
				ImageIcon iconError = null;
				try {
					iconError = new ImageIcon(ImageIO.read(this.getClass().getResourceAsStream("images/ico_error.png")));
				} catch (IOException e) {
					System.exit(1);
				}
				
				JOptionPane.showMessageDialog(null, ERREUR_CRITIQUE + " \n\n\t" + arg1.getMessage(), "Fatal Erreur",
						JOptionPane.ERROR_MESSAGE, iconError);
				
				if (!DEBUG) {
					// Ferme le programme
					System.exit(1);
				}
			}
		});
	}
	
}
