package files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import library.Library;
import properties.AbstractPropKey;
import properties.AbstractValues;

import com.Hemixos.Model;
import com.Hemixos.Model_window;

public class LibraryManager {

	
	
	private static final String LIB_FILE_URL = System.getProperty("user.home") + "\\AppData\\Local\\Hemixos\\";
	
	
	/**
	 * Load the library file
	 * @param model mdoel de l'applciation
	 * @return une librairie
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static Library loadLibrary(Model model) {
		
		Library lm = null;
		
		try {
	        FileInputStream fis = new FileInputStream(LIB_FILE_URL+model.getMw().getMainProperty(AbstractPropKey.libFileNamePF));
	        ObjectInputStream ois;
			
			ois = new ObjectInputStream (fis);
	   
	        lm = (Library) ois.readObject();

	        ois.close();
	       
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			return null;
		}

		return lm;
	}


	/**
	 * Save the library file
	 * @param model le modele de l'application
	 * @param lm la librairie a sauver
	 * @throws FileNotFoundException si il n'est pas cap d'enregistrer l'app
	 */
	public static void saveLibrary(Model model, Library lm) throws FileNotFoundException {
	
		// On crée le répertoire de sauvegarde
		boolean success = true;
		new File(LIB_FILE_URL).mkdirs();
				
		// On enregistre le fichier de sauvegardé
		try {
			ObjectOutputStream flotEcriture = new ObjectOutputStream(
	        		 new FileOutputStream(LIB_FILE_URL+model.getMw().getMainProperty(AbstractPropKey.libFileNamePF)));
	        flotEcriture.writeObject(lm);
	        flotEcriture.close();
	        	        
		} catch (Exception e) {
			System.out.println(e.getMessage());
			success = false;
			e.printStackTrace();
		}
		
		// TODO
		System.out.println("success: " + success);
		
		if (!success)
	    	throw new FileNotFoundException(AbstractValues.FATAL_ERROR_SAVING_LIBRARY);
	
		
	}
	
}
