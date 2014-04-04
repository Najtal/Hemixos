package threads;

import library.Song;
import gui_actionUpdater.InfoPisteLectureUpdater;

import com.Hemixos.Model;

public class LaunchPlay implements Runnable {

	private Model model;
	private Song s;

	Thread runner;
	
	/**
	 * Constructeur
	 * @param model
	 */
	public LaunchPlay(Model model, Song s) {
		this.model = model;
		this.s = s;
		
		runner = new Thread(this);
		runner.start();		
	}
	
	
	public void run() {
		model.getMp().play(s);
	}
	
}
