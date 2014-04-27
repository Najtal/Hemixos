package com.Hemixos;

import gui_actionUpdater.InfoPisteLectureUpdater;
import gui_music_manager.Gmm_Playlist;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import vlcEngine.PlayerManager;
import library.PlayQueue;
import library.Song;

public class Model_player {

	
	// Main model
	private Model model;
	
	private final ArrayList<ChangeListener> listeVues;

	// VLC Player Manager
	private PlayerManager pm;
		
	// Volume
	private int volume = 70;
	
	private Song playingSong;
	private Image iPlayingTrackCover;

	private PlayQueue queue;
	
	private boolean addToPL;
	private boolean buffering;
	private float buffered;

	private boolean updateThreadLaunched = false;
	
	private boolean enLecture;
	private boolean random;
	private boolean repeat;

	private Gmm_Playlist gmm_Playlist;



	


	/**
	 * Constructor
	 * @param model
	 */
	public Model_player(Model model) {
		this.model = model;
		this.listeVues = new ArrayList<ChangeListener>();
		this.queue = new PlayQueue(model);

		this.addToPL = false;		
	}
	

	/**
	 * Enregistre un listener
	 * 
	 * @param chl Le listener � enregistrer
	 */
	public final synchronized void addChangeListener(final ChangeListener chl) {
		if (!listeVues.contains(chl)) {
			listeVues.add(chl);
		}
	}
	
	
	/**
	 * Notifie les listeners
	 * 
	 * @param e L'�v�nement � notifier aux listeners
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
				
		if (s == null) return;
		
		if (enLecture)
			model.getMp().getPm().stop();
				
		String SongURL = "";		
		try {
			SongURL = model.getMd().getGm().getSongURL(s.getSourceSong()).toString();
		} catch (Exception e) {
			// TODO catcher et g�rer le cas ou l'url n'a pas pu �tre g�n�r�
			System.out.println("CATCH DE NON GENERATION D'URL");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		setPlayingTrack(s);
		//setEnLecture(true);
		traiterEvent(null);
		
		pm.play(SongURL);
		
		if (!updateThreadLaunched) {
			// TODO
			//new InfoLectureUpdater(model);
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
			//setEnLecture(true);
			traiterEvent(null);
		
		} else if (playingSong != null && isEnLecture()) {
			pm.pause();
			//setEnLecture(false);
			traiterEvent(null);
		
		} else if (playingSong == null) {
			//setEnLecture(true);
		}
		
	}


	public void actionNext() {
		queue.PlayNextSong();
	}


	public void actionPrevious() {
		queue.playPreviousSong();
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
		InfoPisteLectureUpdater.getInstance().updateInfoPiste();
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
		traiterEvent(null);
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
		traiterEvent(null);
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
		traiterEvent(null);
	}


	public void setPlayingTrackCover(Image image) {
		this.iPlayingTrackCover = image;
	}
	
	

	
	/**
	 * @return the queue
	 */
	public PlayQueue getQueue() {
		return queue;
	}


	/**
	 * @return the iPlayingTrackCover
	 */
	public Image getiPlayingTrackCover() {
		return iPlayingTrackCover;
	}


	public void regJpPlaylist(Gmm_Playlist gmm_Playlist) {
		this.gmm_Playlist = gmm_Playlist;
	}

	/**
	 * @return the gmm_Playlist
	 */
	public Gmm_Playlist getGmm_Playlist() {
		return gmm_Playlist;
	}

	public float buffered() {
		return buffered;
	}
	
	public boolean isBuffering() {
		return buffering;
	}

	public void setBuffering(boolean buf) {
		buffering = buf;
	}
	
	public void setBuffered(float per) {
		buffered = per;
		
		if (per == 100)
			setBuffering(false);
	}

}
