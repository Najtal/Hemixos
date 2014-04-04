package ucc;

import exceptions.UnselectedLibraryException;

import java.util.Vector;

import javax.swing.JTable;

import library.Library;
import library.PlayQueue;
import library.Song;
import threads.LaunchPlay;

import com.Hemixos.Model;

public class ActionElementToPlay {

	
	
	
	/**
	 * Cette classe est appel�e lors d'une s�lection sur des pistes a lire/ajouter a la queue
	 * @param model
	 */
	public static void AddOrPlayElement(Model model, JTable table) {
		
		Song s = null;
		
		//System.out.println("selected row : " + table.getSelectedRow());
		s = getTrackFromRow(table.getSelectedRow(), model);
		//System.out.println("song: " + s.getTitle());
		
		PlayQueue queue = model.getMp().getQueue();
		
		
		// On ajoute a la playlist
		if (model.getMp().isAddToPL()) {
			queue.addSong(s);
					
			// On supprime la playlist et on ajoute tout a dans une nouvelle Playlist
		} else {		
			queue.removeAll();
			
			queue.addSong(s);
			
			/*int nbrRow = table.getRowCount();
			
			for (int i = table.getSelectedRow(); i < nbrRow; i++) {
				queue.addSong(getTrackFromRow(i, model));
			}
			
			for (int i = 0; i < table.getSelectedRow(); i++) {
				queue.addSong(getTrackFromRow(i, model));
			}*/
			
		}
							
	}
	
	
	
	private static Song getTrackFromRow(int tableRow, Model model) {
		// On r�cup�re la librairie
		Library ltmp = null;
		try {
			ltmp = model.getMd().getLib();
		} catch (UnselectedLibraryException e) {
			return null;
		}
		
		// On r�cup�re la piste
		Song s = model.getMd().getListSong().get(tableRow);
		//Vector<String> vv = (Vector<String>) model.getMd().getListePisteData().get(tableRow);
		//String idt = vv.get(3);
			
		return s;
		//return ltmp.getMapSongs().get(idt);
	}
	
}
