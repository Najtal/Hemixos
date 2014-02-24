package gui_generic_components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import properties.AbstractColors;

import com.Hemixos.Model;

public class GuiScrollBarUpdater {

	
	
	public static void updateArtistSB(Model model) {

	    JScrollBar sb =  model.getMc().spArtist.getVerticalScrollBar();
	    sb.setPreferredSize(new Dimension(10, Integer.MAX_VALUE));
	    sb.setBackground(Color.WHITE);
	    
	    sb.setUI(new CustomJScrollBar(AbstractColors.GUI_LISTE_ARTIST_BG));
	    
	    JScrollBar sbh =  model.getMc().spArtist.getHorizontalScrollBar();
	    sbh.setPreferredSize(new Dimension(Integer.MAX_VALUE, 10));
	    sbh.setBackground(Color.WHITE);
	    
	    sbh.setUI(new CustomJScrollBar(AbstractColors.GUI_LISTE_ARTIST_BG));
		
	}
	
	public static void updateAlbumSB(Model model) {

	    JScrollBar sb =  model.getMc().spAlbum.getVerticalScrollBar();
	    sb.setPreferredSize(new Dimension(10, Integer.MAX_VALUE));
	    sb.setBackground(Color.WHITE);
	    sb.setVisible(true);
	    sb.setOpaque(false);   
	    
	    sb.setUI(new CustomJScrollBar(AbstractColors.GUI_LISTE_ARTIST_BG));
	    
	    
	    JScrollBar sbh =  model.getMc().spAlbum.getHorizontalScrollBar();
	    sbh.setPreferredSize(new Dimension(Integer.MAX_VALUE, 10));
	    sbh.setBackground(Color.WHITE);
	    
	    sbh.setUI(new CustomJScrollBar(AbstractColors.GUI_LISTE_ARTIST_BG));
		
	}
	
	public static void updatePlaylistSB(Model model) {

	    JScrollBar sb =  model.getMc().spPlaylistView.getVerticalScrollBar();
	    sb.setPreferredSize(new Dimension(10, Integer.MAX_VALUE));
	    sb.setBackground(Color.WHITE);
	    
	    sb.setUI(new CustomJScrollBar(AbstractColors.GUI_LISTE_ARTIST_BG));
	
	    
	}
	
	public static void updateTrackSB(Model model) {

	    JScrollBar sb =  model.getMc().jspTracks.getVerticalScrollBar();
	    sb.setPreferredSize(new Dimension(10, Integer.MAX_VALUE));
	    sb.setBackground(Color.WHITE);
	    
	    sb.setUI(new CustomJScrollBar(Color.WHITE));
		
	    
	    JScrollBar sbh =  model.getMc().jspTracks.getHorizontalScrollBar();
	    sbh.setPreferredSize(new Dimension(Integer.MAX_VALUE, 10));
	    sbh.setBackground(Color.WHITE);
	    
	    sbh.setUI(new CustomJScrollBar(Color.WHITE));
	    
	    
	}
	
	
}
