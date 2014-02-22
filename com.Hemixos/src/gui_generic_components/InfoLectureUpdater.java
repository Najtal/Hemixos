package gui_generic_components;

import gui_music_manager.Gmm_PlayerInfoVolet;

import com.Hemixos.Model;

public class InfoLectureUpdater implements Runnable {

	private Thread runner;
	private Model model;
	private Gmm_PlayerInfoVolet infoPanel;
	

	public InfoLectureUpdater(Model model) {
		this.model = model;
		
		this.infoPanel = this.model.getMc().playerVolet;
		
		runner = new Thread(this);
		runner.start(); 
	}

	
	public void run() {
		
		while (true) {
			
			try {
				Thread.sleep(200);
				model.getMw().actionResize();
			} catch (InterruptedException e) {
				model.getMp().setUpdateThreadLaunched(false);
				break;
			}
			
		}
		
	}
	
}
