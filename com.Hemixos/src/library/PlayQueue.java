package library;

import java.util.ArrayList;

import threads.LaunchPlay;

import com.Hemixos.Model;

public class PlayQueue {

	
	private Model model;
	private ArrayList<Song> queue;
	private int playingSongIndex;
	
	/**
	 * Constructor
	 * @param model
	 */
	public PlayQueue(Model model) {
		this.model = model;
		this.queue = new ArrayList<Song>();
	}
	
	
	/**
	 * Launch the next song waiting in the queue
	 */
	public void PlayNextSong() {
		if (playingSongIndex >= queue.size()-1) {
			model.getMp().getPm().stop();
			model.getMp().setEnLecture(false);
		} else {
			playingSongIndex++;
			model.getMp().setEnLecture(true);
			model.getMp().setPlayingTrack(queue.get(playingSongIndex));
			new LaunchPlay(model, queue.get(playingSongIndex));
		}
		model.getMp().getGmm_Playlist().update();
		
	}
	
	public void playPreviousSong() {
		if (playingSongIndex == 0) {
			model.getMp().getPm().stop();
			model.getMp().setEnLecture(false);
		} else {
			playingSongIndex--;
			model.getMp().setEnLecture(true);
			model.getMp().setPlayingTrack(queue.get(playingSongIndex));
			new LaunchPlay(model, queue.get(playingSongIndex));
		}
		model.getMp().getGmm_Playlist().update();
	}
	
	
	public Song getCurrentSong() {
		if (playingSongIndex >= queue.size()) return null;
		return queue.get(playingSongIndex);
	}
	
	
	/**
	 * Add a song at the end of the list
	 * @param s
	 */
	public void addSong(Song s) {
		queue.add(s);
		model.getMp().getGmm_Playlist().update();
		if (!model.getMp().isEnLecture() && playingSongIndex == queue.size()-1) {
			model.getMp().setEnLecture(true);
			model.getMp().setPlayingTrack(queue.get(playingSongIndex));
			new LaunchPlay(model, queue.get(playingSongIndex));
		} else {
			model.getMp().setEnLecture(false);
		}
	}
	
	
	/**
	 * Remove an element of the List
	 * @param index
	 */
	public void removeSong(int index) {
		ArrayList<Song> nAlS = new ArrayList<Song>(queue.size()-1);
		for (int i = 0; i < queue.size(); i++) {
			if (i != index) {
				nAlS.set(i, queue.get(i));
			} else {
				if (playingSongIndex > i)
					playingSongIndex--;
			}
		}
		queue = nAlS;
		model.getMp().getGmm_Playlist().update();
	}
	
	/**
	 * Remove all the elements of the list
	 */
	public void removeAll() {
		queue = new ArrayList<Song>();
		playingSongIndex = 0;
		model.getMp().getGmm_Playlist().update();
	}
	
	
	public int sizeQueue() {
		return queue.size() - playingSongIndex;
	}
	
	public ArrayList<Song> getQueue() {
		return queue;
	}
	
	/**
	 * Return the total time of the tracks in the queue
	 * @return the total time of the tracks in the queue
	 */
	public long getTotalTime() {
		long t = 0;
		for (int i = playingSongIndex; i < queue.size(); i++) {
			t += queue.get(i).getDurationMillis();
		}
		return t;
	}

	
	
	
	
}
