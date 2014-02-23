package ucc;

import com.Hemixos.Model;

public class ActionVolet implements Runnable {

	private Thread runner;
	private Model model;

	public ActionVolet(Model model) {
		this.model = model;
		
		runner = new Thread(this);
		runner.start(); 
	}

	
	public void run() {
		
		/*
		if (!model.getMw().isVoletEnAction()) {
			
			model.getMw().setVoletEnAction(true);
			
			
			if (model.getMw().isVoletOuvert()) {		
				// On ferme le volet

				model.getMw().setVoletOuvert(false);
				model.getMc().playerVolet.stateChanged(null);
								
				for (int i = model.getMc().jpVolet.getWidth(); i > 0; i--) {
					model.getMc().jpVolet.setPreferredSize(new Dimension(i, model.getMc().jpVolet.getHeight()));
					model.getMc().jpVolet.revalidate();
					
					try {
						runner.sleep(1);
					} catch (InterruptedException e) {}
				}
				

			} else {
				// On ouvre le volet
				model.getMw().setVoletOuvert(true);
				model.getMc().playerVolet.stateChanged(null);
				
				
				for (int i = 0; i < AbstractValues.GUI_MN_WIDTH; i++) {
					model.getMc().jpVolet.setPreferredSize(new Dimension(i, model.getMc().jpVolet.getHeight()));
					model.getMc().jpVolet.revalidate();
					
					try {
						runner.sleep(1);
					} catch (InterruptedException e) {}
				}
			}
			
			model.getMw().setVoletEnAction(false);
			
		}
	*/
	}
	
	
}
