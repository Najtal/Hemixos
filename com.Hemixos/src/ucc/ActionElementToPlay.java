package ucc;

import dto.Library;
import dto.PlayingQueue;
import exceptions.UnselectedLibraryException;
import gmusic.api.model.Song;
import gmusic.api.skyjam.model.Track;

import java.util.Vector;

import javax.swing.JTable;

import threads.LaunchPlay;

import com.Hemixos.Model;

public class ActionElementToPlay {

	
	
	
	/**
	 * Cette classe est appelée lors d'une sélection sur des pistes a lire/ajouter a la queue
	 * @param model
	 */
	public static void AddOrPlayElement(Model model, JTable table) {
		

		Song s = null;
		
		//System.out.println("selected row : " + table.getSelectedRow());
		s = getTrackFromRow(table.getSelectedRow(), model);
		//System.out.println("song: " + s.getTitle());
		
		/*PlayingQueue queue = model.getMp().getQueue();
		
		
		// On ajoute a la playlist
		if (model.getMp().isAddToPL()) {
			
			s = getTrackFromRow(table.getSelectedRow(), model);
			queue.ajouterUnePiste(s);
		
		// On supprime la playlist et on ajoute tout a dans une nouvelle Playlist
		} else {
			
			int nbrRow = table.getRowCount();
			
			for (int i = table.getSelectedRow(); i < nbrRow; i++) {
				queue.ajouterUnePiste(getTrackFromRow(i, model));
			}
			
			for (int i = 0; i < table.getSelectedRow(); i++) {
				queue.ajouterUnePiste(getTrackFromRow(i, model));
			}
			
		}*/
		
		new LaunchPlay(model, s);
		//model.getMp().play(s);
		
	}
	
	
	
	private static Song getTrackFromRow(int tableRow, Model model) {
		// On récupère la librairie
		Library ltmp = null;
		try {
			ltmp = model.getMd().getLib();
		} catch (UnselectedLibraryException e) {
			return null;
		}
		
		// On récupère la piste
		Vector<String> vv = (Vector<String>) model.getMd().getListePisteData().get(tableRow);
		String idt = vv.get(3);
				
		return ltmp.getMapSongs().get(idt);
	}
	
}
