package gui_generic_components;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.Hemixos.Model;

public class ListenerJpSlider implements MouseMotionListener, MouseListener {

	
	private Model model;
	
	private static boolean clicked;
	private static int startPosition;
	private static int initWidth;
	
	// libs
	private JPanel jpPVBorder1;
	private JPanel jpPVBorder2;
	private JPanel jpPVBorder3;
	private JScrollPane jpLibs;
	private JPanel jpPlaylistViews;

	// artist
	private JPanel jpArtistResize;
	private JPanel jpArtistlist;

	// albums
	private JPanel jpAlbumResize;
	private JPanel jpAlbumslist;

	// playlist
	private JPanel jpPlaylistResize1;
	private JPanel jpPlaylistResize2;
	private JPanel jpPlayingInfo;




	
	/**
	 * Constructor
	 * @param model
	 */
	public ListenerJpSlider(Model model) {
		this.model = model;
		
		jpPVBorder1 = model.getMc().jpPVBorder1;
		jpPVBorder2 = model.getMc().jpPVBorder2;
		jpPVBorder3 = model.getMc().jpPVBorder3;
		jpLibs = model.getMc().spPlaylistView;
		jpPlaylistViews = model.getMc().jpPlaylistViews;
		
		jpArtistResize = model.getMc().jpArtistResize;
		jpArtistlist = model.getMc().jpArtistlist;
		
		jpAlbumResize = model.getMc().jpAlbumResize;
		jpAlbumslist = model.getMc().jpAlbumslist;
		
		jpPlaylistResize1 = model.getMc().jpPlaylistResize1;
		jpPlaylistResize2 = model.getMc().jpPlaylistResize2;
		jpPlayingInfo = model.getMc().jpPlayingInfo;
		
		
	}
	
	
	/*
	 * MouseMotionListener
	 */
	
	@Override
	public void mouseDragged(MouseEvent me) {
		// Quand elle est clickée et qu'elle bouge
		if (clicked) {
			if (me.getSource() == jpArtistResize) {
				jpArtistlist.setPreferredSize(new Dimension(initWidth + (me.getX()-startPosition), 300));
				jpArtistlist.revalidate();
			} else if (me.getSource() == jpAlbumResize) {
				jpAlbumslist.setPreferredSize(new Dimension(initWidth + (me.getX()-startPosition), 300));
				jpAlbumslist.revalidate();
			} else if (me.getSource() == jpPVBorder1 
					|| me.getSource() == jpPVBorder2 
					|| me.getSource() == jpPVBorder2) {	
				Dimension n = new Dimension(initWidth + (me.getX()-startPosition), 300);
				jpLibs.setPreferredSize(n);		
				jpPlaylistViews.setPreferredSize(n);
				
				//jpPlaylistViews.repaint();
				//jpPlaylistViews.revalidate();
				//jpLibs.revalidate();
				
				// TODO peut faire mieux...
				jpArtistlist.revalidate();
								
			} else {
				jpPlayingInfo.setPreferredSize(new Dimension(initWidth - (me.getX()-startPosition), 300));
				jpPlayingInfo.revalidate();
			}
		}

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
	}

	
	
	/*
	 * MouseListener
	 */
	
	@Override
	public void mousePressed(MouseEvent e) {
		// lorsque je click
		clicked = true;
		startPosition = e.getX();
		initWidth = model.getMc().jpArtistlist.getWidth();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// lorsque je relache
		clicked = false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
	
}
