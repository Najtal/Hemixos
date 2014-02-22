package dto;

import gmusic.api.model.Song;
import gmusic.api.skyjam.model.Track;

import java.util.ArrayList;

import com.Hemixos.Model;

public class PlayingQueue {

	// Model
	private Model model;
	
	// elements de la queue
	private QueueElement noeudLu;
	private QueueElement noeudALire;
	private QueueElement dernierNoeud;
	
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
		
		QueueElement nn = new QueueElement(s);
		
		if (noeudALire == null) {
			noeudALire = nn;
			dernierNoeud = nn;
		} else {
			dernierNoeud.setNext(nn);
			dernierNoeud = nn;
		}
		
	}
	
	
	
	public String trackALire() {
		
		String s = null;
		
		if (noeudALire == null) {
			return null;
		}
		
		if (noeudALire == dernierNoeud) {
			s = noeudALire.getUrl();
			noeudALire = null;
			return s;
		}
		
		s = noeudALire.getUrl();
		noeudALire = noeudALire.getNext();
		return s;
		
	}
	
	
	

	
	
}
