package threads;

import java.awt.Dimension;

import javax.swing.JPanel;

import properties.AbstractValues;

import com.Hemixos.Model;

public class OptionManager implements Runnable {
	
	
	private Model model;
	private JPanel jpOptions;

	Thread runner;
	
	/**
	 * Constructeur
	 * @param model
	 */
	public OptionManager(Model model) {
		this.model = model;
		this.jpOptions = model.getMc().jpOptions;
		
		if (model.getMw().isOptionEnAction())
			return;
		
		model.getMw().setOptionEnAction(true);
		
		runner = new Thread(this);
		runner.start();		
	}
	
	
	
	public void run() {


		if (model.getMw().isOptionOuvert()) {		
			// On ferme le volet

			model.getMw().setOptionOuvert(false);
							
			for (int i = jpOptions.getWidth(); i > 0; i--) {
				jpOptions.setPreferredSize(new Dimension(i, jpOptions.getHeight()));
				jpOptions.revalidate();
				
				try {
					runner.sleep(1);
				} catch (InterruptedException e) {}
			}
			

		} else {
			// On ouvre le volet
			model.getMw().setOptionOuvert(true);
			
			for (int i = 0; i < AbstractValues.GUI_MN_WIDTH; i++) {
				jpOptions.setPreferredSize(new Dimension(i, jpOptions.getHeight()));
				jpOptions.revalidate();
				
				try {
					runner.sleep(1);
				} catch (InterruptedException e) {}
			}
		}
		
		model.getMw().setOptionEnAction(false);

	}
	
}
