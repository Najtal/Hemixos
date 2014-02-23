package threads;

import com.Hemixos.Model;


/**
 * 
 * Cette classe tourne tout le temps nécessaire et s'occupe de rafraichir le header du programme
 * 
 * @author Jean-Vital
 *
 */
public class HeaderUpdater implements Runnable {

	public static HeaderUpdater instance;
	
	private Model model;
	Thread runner;
	
	/**
	 * Constructeur innaccessible
	 */
	private HeaderUpdater() {
	}
	
	/**
	 * Constructeur
	 * @param model
	 */
	private HeaderUpdater(Model model) {
		this.model = model;
		
		runner = new Thread(this);
		runner.start();
	}
	
	
	public static void instanciate(Model model) {
		if (instance == null) {
			instance = new HeaderUpdater(model);
		}
	}
	
	
	
	public void run() {
		while (true) {
			model.getMc().jpInfo.repaint();
		}
	}
	
}
