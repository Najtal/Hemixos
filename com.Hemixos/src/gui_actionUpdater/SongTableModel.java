package gui_actionUpdater;

import java.util.Collections;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import library.Song;

import com.Hemixos.Model;

public class SongTableModel extends AbstractTableModel {
	    
	private final Vector<Song> songList;
    private Model model;
	
    private final String[] columnNames = new String[] {
            "Title", "Artist", "Album", "Genre"
    };
    
    private final Class[] columnClass = new Class[] {
    		String.class, String.class, String.class, String.class
    };
    
 
    /**
     * Constructor
     * @param studentList
     */
    public SongTableModel(Model model) {
    	
		Vector data = model.getMd().getListePisteData();
	    Collections.sort(data, new SongTableSorter(0));
        this.songList = data;
        this.model = model;  
        
    }
     
    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }
 
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnClass[columnIndex];
    }
 
    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }
 
    @Override
    public int getRowCount()
    {
        return songList.size();
    }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Song row = songList.get(rowIndex);
        
        switch (columnIndex) {
        
        case 0 : return row.getTitle();
        case 1 : return (row.getArtist() != null) ? row.getArtist().getArtistName() : "-";
        case 2 : return (row.getAlbum() != null) ? row.getAlbum().getName() : "-";
        case 3 : return (row.getGenre() != null) ? row.getGenre() : "-";
        
        }
        
        return null;
    }

	public Song getRowAt(int row) {
		return songList.get(row);
	}   
        
}
	

