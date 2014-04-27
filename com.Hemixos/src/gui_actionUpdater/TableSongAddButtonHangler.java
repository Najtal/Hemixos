package gui_actionUpdater;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTable;

import library.Album;
import library.Artist;
import library.Library;
import library.Song;

import com.Hemixos.Model;

import exceptions.UnselectedLibraryException;

public class TableSongAddButtonHangler implements ActionListener {

	
	
	private Model model;
	private JButton jbAddArtist;
	private JButton jbAddAlbum;
	

	public TableSongAddButtonHangler(Model model) {
		this.model = model;
		
		this.jbAddArtist = model.getMc().jbAddSelectedArtist;
		this.jbAddAlbum = model.getMc().jbAddSelectedAlbum;

		this.jbAddAlbum.addActionListener(this);
		this.jbAddArtist.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == jbAddArtist) {
			
			Artist selectedArtist;
			
			if (model.getMd().getSelectedAlbum() != null) {
				selectedArtist = model.getMd().getSelectedAlbum().getArtist();
			} else {
				selectedArtist = model.getMd().getSelectedArtist();
			}
			Library ll = null;
			
			try {
				ll = model.getMd().getLib();
			} catch (UnselectedLibraryException e) {
				e.printStackTrace();
			}
			
			for (Song s : ll.getMapArtist().get(selectedArtist.getArtistName()).getMapAllSong().values()) {
				model.getMp().getQueue().addSong(s);
			}
		
		} else if (ae.getSource() == jbAddAlbum) {
			
			Album selectedAlbum = model.getMd().getSelectedAlbum();
			
			Library ll = null;
			
			try {
				ll = model.getMd().getLib();
			} catch (UnselectedLibraryException e) {
				e.printStackTrace();
			}
			
			for (Song s : ll.getMapAlbums().get(selectedAlbum.getName()).getMapSongs().values()){
				model.getMp().getQueue().addSong(s);
			}			
		}
		
	}
	
}
