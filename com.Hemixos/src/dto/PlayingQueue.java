package dto;

import gmusic.api.model.Song;
import gmusic.api.skyjam.model.Track;

import java.util.ArrayList;

import com.Hemixos.Model;

public class PlayingQueue {

	// Model
	private Model model;
	
	// elements de la queue
	private Noeud noeudLu;
	private Noeud noeudALire;
	private Noeud dernierNoeud;
	
	private int nbrNoeudLu; // nbr de noeuds entre NoeudALire et NoeudLu (compris)
	private int nbrNoeudEnAttente; // nbr de noeuds apres noeudEnLecture
	private int nbrNoeudDansQueue;
	

	/**
	 * Constructeur d'une queue de playlist
	 * @param model
	 */
	public PlayingQueue(Model model) {
		
		this.model = model;
		
	}
	
	
	/**
	 * Ajoute une piste a la fin de la liste de lecture
	 */
	public void ajouterUnePiste(Song s) {
		
		Noeud nn = new Noeud(s);
		
		if (noeudALire == null) {
			noeudALire = nn;
			dernierNoeud = nn;
		} else {
			dernierNoeud.setNext(nn);
			dernierNoeud = nn;
		}
		
	}
	
	public Song trackALire() {
		
		Song s = null;
		
		if (noeudALire == null) {
			return null;
		}
		
		if (noeudALire == dernierNoeud) {
			s = noeudALire.getTrack();
			noeudALire = null;
			return s;
		}
		
		s = noeudALire.getTrack();
		noeudALire = noeudALire.getNext();
		return s;
		
	}
	
	
	
	/**
	 * Classe interne destinée a construire la Playing Queue
	 * 
	 * @author Jean-Vital
	 *
	 */
	private class Noeud {
		
		private Song song;
		private Noeud next;

		/**
		 * Constructeur d'un noeud membre de la playlist en cours
		 * @param track
		 */
		public Noeud(Song song) {
			this.song = song;
		}
		
	

		/**
		 * @param next the next to set
		 */
		public void setNext(Noeud next) {
			this.next = next;
		}


		/**
		 * @return the track
		 */
		public Song getTrack() {
			return song;
		}

		/**
		 * @return the next
		 */
		public Noeud getNext() {
			return next;
		}
		
		
	}
	
	
}
