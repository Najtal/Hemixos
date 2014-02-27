package threads;

import java.awt.Dimension;

import javax.swing.JPanel;

import properties.AbstractValues;
import gmusic.api.model.Song;

import com.Hemixos.Model;

public class VoletManager implements Runnable {
	
	
	private Model model;
	private JPanel jpVolet;

	Thread runner;
	
	/**
	 * Constructeur
	 * @param model
	 */
	public VoletManager(Model model) {
		this.model = model;
		this.jpVolet = model.getMc().jpPlayingInfo;
		
		if (model.getMw().isVoletEnAction())
			return;
		
		model.getMw().setVoletEnAction(true);
		
		runner = new Thread(this);
		runner.start();		
	}
	
	
	
	public void run() {


		if (model.getMw().isVoletOuvert()) {		
			// On ferme le volet

			model.getMw().setVoletOuvert(false);
			//model.getMc().playerVolet.stateChanged(null);
							
			for (int i = jpVolet.getWidth(); i > 0; i--) {
				jpVolet.setPreferredSize(new Dimension(i, jpVolet.getHeight()));
				jpVolet.revalidate();
				
				try {
					runner.sleep(1);
				} catch (InterruptedException e) {}
			}
			

		} else {
			// On ouvre le volet
			model.getMw().setVoletOuvert(true);
			//model.getMc().playerVolet.stateChanged(null);
			
			
			for (int i = 0; i < AbstractValues.GUI_MN_WIDTH; i++) {
				jpVolet.setPreferredSize(new Dimension(i, jpVolet.getHeight()));
				jpVolet.revalidate();
				
				try {
					runner.sleep(1);
				} catch (InterruptedException e) {}
			}
		}
		
		model.getMw().setVoletEnAction(false);

	}
	
}
