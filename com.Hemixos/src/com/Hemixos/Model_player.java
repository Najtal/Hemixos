package com.Hemixos;

import gmusic.api.model.Song;
import gmusic.api.skyjam.model.Track;
import gui_generic_components.InfoLectureUpdater;

import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.vlcj.testx.PlayerManager;

import dto.PlayingQueue;

public class Model_player {

	
	// Main model
	private Model model;
	
	private final ArrayList<ChangeListener> listeVues;


	
	// VLC Player Manager
	private PlayerManager pm;
	
	
	// Volume
	private int volume = 70;
	
	private Song playingSong;
	private PlayingQueue queue;
	
	private boolean addToPL;
	
	private boolean updateThreadLaunched = false;
	
	private boolean enLecture;
	private boolean random;
	private boolean repeat;
	
	
	
	/**
	 * Constructor
	 * @param model
	 */
	public Model_player(Model model) {
		this.model = model;
		this.listeVues = new ArrayList<ChangeListener>();
		this.queue = new PlayingQueue(model);

		this.addToPL = false;
		
	}
	
	
	/**
	 * @return the queue
	 */
	public PlayingQueue getQueue() {
		return queue;
	}


	/**
	 * @param queue the queue to set
	 */
	public void setQueue(PlayingQueue queue) {
		this.queue = queue;
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
		model.getMw().getFrame().revalidate();
	}
	
	
	
	/*
	 * Actions on PM
	 */
	public void play(Song s) {
				
		if (s == null) {
			System.out.println("No SONG");
			return;
		}
		
		String SongURL = "";		
		
		try {
			SongURL = model.getMd().getGm().getTrackURL(s).toString();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		

		playingSong = s;
		setEnLecture(true);
		traiterEvent(null);
		
		pm.play(SongURL);
		
		if (!updateThreadLaunched) {
			new InfoLectureUpdater(model);
			updateThreadLaunched = true;
		}
	}
	
	
	

	/*
	 * ACTIONS
	 */

	/**
	 * @return the updateThreadLaunched
	 */
	public boolean isUpdateThreadLaunched() {
		return updateThreadLaunched;
	}


	/**
	 * @param updateThreadLaunched the updateThreadLaunched to set
	 */
	public void setUpdateThreadLaunched(boolean updateThreadLaunched) {
		this.updateThreadLaunched = updateThreadLaunched;
	}


	public void actionPlay() {
		
		if (playingSong != null && !isEnLecture()) {
			pm.play();
			setEnLecture(true);
			traiterEvent(null);
		
		} else if (playingSong != null && isEnLecture()) {
			pm.pause();
			setEnLecture(false);
			traiterEvent(null);
		
		} else if (playingSong == null) {
			setEnLecture(true);
		}
		
	}


	public void actionNext() {
		// TODO Auto-generated method stub
		System.out.println("next");
	}


	public void actionPrevious() {
		// TODO Auto-generated method stub
		System.out.println("previous");
	}
	

	
	
	
	/*
	 * GETTERS & SETTERS
	 */
	
	public void setPm(PlayerManager pm) {
		this.pm = pm;
	}

	public PlayerManager getPm() {
		return pm;
	}

	/**
	 * @return the volume
	 */
	public int getVolume() {
		return volume;
	}

	/**
	 * @param volume the volume to set
	 */
	public void setVolume(int volume) {
		if (volume > 100)
			volume = 100;
		
		if (volume < 0)
			volume = 0;
		
		// register volume level
		this.volume = volume;
		
		// setlevel at media player
		pm.setVolumeLevel(volume);
		
		// update frame
		model.getMc().jpVolume.repaint();
	}



	public int getTrackLength() {
		return pm.getTrackLength();
	}



	public int getTrackLengthPlayed() {
		return pm.getTrackLengthPlayed();
	}



	/**
	 * @return the playingTrack
	 */
	public Song getPlayingSong() {
		return playingSong;
	}

	/**
	 * @param playingTrack the playingTrack to set
	 */
	public void setPlayingTrack(Song playingSong) {
		this.playingSong = playingSong;
	}



	/**
	 * @return the addToPL
	 */
	public boolean isAddToPL() {
		return addToPL;
	}



	/**
	 * @param addToPL the addToPL to set
	 */
	public void setAddToPL(boolean addToPL) {
		this.addToPL = addToPL;
	}



	/**
	 * @return the enLecture
	 */
	public boolean isEnLecture() {
		return enLecture;
	}



	/**
	 * @param enLecture the enLecture to set
	 */
	public void setEnLecture(boolean enLecture) {
		this.enLecture = enLecture;
	}



	/**
	 * @return the random
	 */
	public boolean isRandom() {
		return random;
	}



	/**
	 * @param random the random to set
	 */
	public void setRandom(boolean random) {
		this.random = random;
	}



	/**
	 * @return the repeat
	 */
	public boolean isRepeat() {
		return repeat;
	}



	/**
	 * @param repeat the repeat to set
	 */
	public void setRepeat(boolean repeat) {
		this.repeat = repeat;
	}

	
}
