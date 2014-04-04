package gui_actionUpdater;

import gui_generic_components.ListenerJpSlider;

import javax.swing.JPanel;

import com.Hemixos.Model;


/**
 * Cette class gère les slide de panels en clicker-déposer
 * @author Jean-Vital
 *
 */
public class PanelSlideHandler {

	
	
	private Model model;
	
	private JPanel jpPVBorder1;
	private JPanel jpPVBorder2;
	private JPanel jpPVBorder3;
	private JPanel jpArtistResize;
	private JPanel jpAlbumResize;
	private JPanel jpPlaylistResize1;
	private JPanel jpPlaylistResize2;




	public PanelSlideHandler(Model model) {
		
		this.model = model;

		
		jpPVBorder1 = model.getMc().jpPVBorder1;
		jpPVBorder2 = model.getMc().jpPVBorder2;
		jpPVBorder3 = model.getMc().jpPVBorder3;
		jpArtistResize = model.getMc().jpArtistResize;
		jpAlbumResize = model.getMc().jpAlbumResize;
		jpPlaylistResize1 = model.getMc().jpPlaylistResize1;
		jpPlaylistResize2 = model.getMc().jpPlaylistResize2;
		
		
		// Libs
		jpPVBorder1.addMouseListener(new ListenerJpSlider(model));
		jpPVBorder1.addMouseMotionListener(new ListenerJpSlider(model));
		jpPVBorder2.addMouseListener(new ListenerJpSlider(model));
		jpPVBorder2.addMouseMotionListener(new ListenerJpSlider(model));
		jpPVBorder3.addMouseListener(new ListenerJpSlider(model));
		jpPVBorder3.addMouseMotionListener(new ListenerJpSlider(model));
		
		
		// Artistes
		jpArtistResize.addMouseListener(new ListenerJpSlider(model));
		jpArtistResize.addMouseMotionListener(new ListenerJpSlider(model));

		// Albums
		jpAlbumResize.addMouseListener(new ListenerJpSlider(model));
		jpAlbumResize.addMouseMotionListener(new ListenerJpSlider(model));

		// Playlist
		jpPlaylistResize1.addMouseListener(new ListenerJpSlider(model));
		jpPlaylistResize1.addMouseMotionListener(new ListenerJpSlider(model));
		jpPlaylistResize2.addMouseListener(new ListenerJpSlider(model));
		jpPlaylistResize2.addMouseMotionListener(new ListenerJpSlider(model));
	}
	
}
