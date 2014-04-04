package gui_music_manager;

import exceptions.UnselectedLibraryException;
import gui_actionUpdater.InfoPisteLectureUpdater;
import gui_actionUpdater.ListUpdater;
import gui_actionUpdater.OptionHandler;
import gui_actionUpdater.PanelSlideHandler;
import gui_actionUpdater.PlAddHandler;
import gui_actionUpdater.PlayButtonsUpdater;
import gui_actionUpdater.ViewUpdater;
import gui_actionUpdater.VoletHandler;
import gui_generic_components.GuiScrollBarUpdater;
import gui_generic_components.ListenerFrameResize;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JWindow;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import properties.AbstractImages;
import properties.AbstractValues;
import threads.HeaderUpdater;
import JFormDesigner.ContentContainerMain;

import com.Hemixos.Model;
import com.Hemixos.Model_window;


/**
 * Cette classe génère la fenêtre principale de l'interface
 * 
 * @author Jean-Vital
 *
 */
public class Gmm_Window extends JFrame implements ChangeListener {

	private static final long serialVersionUID = 1L;


	// Model
	private Model model;
	
	// Window Model
	private Model_window mw;
	

	
	/*
	 * Components
	 */
	private JPanel playerTop;
	private JPanel mainMenuLeft;
	private JPanel optionRight;
	private JPanel mainContentCenter;


	private Gmm_PlayerInfoLecture jpLecteurInfo;
	private Gmm_Playlist jpPlaylist;
	
	
	
	/**
	 * Constructeur
	 * @param model
	 */
	public Gmm_Window(Model model) {
	
		this.model = model;
		this.mw = model.getMw();
		this.model.getMw().addChangeListener(this);
		this.model.getMc().regJfFrame(this);

		mw.setFrame(this);

		// Frame config
		configFrame();

		// Init content element
		initElements();
		
		// Listeners
		ListenerFrameResize frameListener = new ListenerFrameResize(model);
		this.addComponentListener(frameListener);
		
		this.addWindowListener(frameListener);
		this.addWindowFocusListener(frameListener);
		this.addWindowStateListener(frameListener);
		
		this.setVisible(true);
		
	}




	private void configFrame() {
		
		this.setSize(new Dimension(model.getMw().getFrameWidth(), model.getMw().getFrameHeight()));
		//this.setUndecorated(true);
		//this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		this.setLocationRelativeTo(null);
		this.setMinimumSize(new Dimension(AbstractValues.FRAME_MIN_WIDTH, AbstractValues.FRAME_MIN_HEIGHT));
		this.setResizable(true);
		
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent e) {
				super.windowClosing(e);
				model.getMw().actionExit();
			}
		});

		// set frame icon
		final Image icon = AbstractImages.instance.ICON_COIN_GAUCHE.getImage();
		this.setIconImage(icon);
		this.setName(model.getMw().getAppName());
		this.setTitle(model.getMw().getAppName());	
		
	}



	/**
	 * Initialise les components crées avec JFormDesigner
	 */
	private void initElements() {
	
		ContentContainerMain jpJFD = new ContentContainerMain();
				
		this.add(jpJFD);
		
		// RegisterElements
		model.getMc().regJpHeadSpacerLeft(jpJFD.getJpHeaderSpacerLeft());
		model.getMc().regJpHeadSpacerRight(jpJFD.getJpHeaderSpacerRight());

		model.getMc().regJlArtist(jpJFD.getJlArtistes());
		model.getMc().regJlAlbum(jpJFD.getJlAlbums());
		model.getMc().regJtTableTrack(jpJFD.getJtTracks());
		
		model.getMc().regJbPlay(jpJFD.getJbPausPlay());
		model.getMc().regJbNext(jpJFD.getJbNext());
		model.getMc().regJbPrevious(jpJFD.getJbPrevious());
		
		model.getMc().regJbRandom(jpJFD.getJbRandom());
		model.getMc().regJbRepeat(jpJFD.getJbRepeat());
		
		model.getMc().regViewSimple(jpJFD.getJbViewSimple());
		model.getMc().regViewOne(jpJFD.getJbViewOneC());
		model.getMc().regViewTwo(jpJFD.getJbViewTwoC());
		model.getMc().regViewThree(jpJFD.getJbviewThreeC());

		model.getMc().regJpArtistList(jpJFD.getJpArtistlist());
		model.getMc().regJpAlbumList(jpJFD.getJpAlbumslist());
		
		model.getMc().regJbArtistAll(jpJFD.getJbArtistsAll());
		model.getMc().regJbAlbumAll(jpJFD.getJbalbumAll());
		
		model.getMc().regJSPArtist(jpJFD.getSpArtist());
		model.getMc().regJSPAlbum(jpJFD.getSpAlbum());
		model.getMc().regJSPlaylistView(jpJFD.getSpPlaylistView());
		model.getMc().regJSPTrack(jpJFD.getJspTracks());
		
		model.getMc().regImageInfoPiste(jpJFD.getJbPisteImage());
		model.getMc().regTitreInfoPiste(jpJFD.getJlTitleValue());
		model.getMc().regArtistInfoPiste(jpJFD.getJlArtistValue());
		model.getMc().regAlbumInfoPiste(jpJFD.getJlAlbumValue());
		model.getMc().regDureeInfoPiste(jpJFD.getJlDureeValue());

		model.getMc().regJbOptions(jpJFD.getJbOptions());
		model.getMc().regJbVolet(jpJFD.getJbVolet());
		model.getMc().regJpEnLecture(jpJFD.getJpPlayingInfo());
		model.getMc().regJpOption(jpJFD.getJpOptions());
		model.getMc().regJbPlAdd(jpJFD.getJbPlAdd());
		
		model.getMc().regJpPlaylist(jpJFD.getJpPlaylistListContainer());
		
		model.getMc().regjpLibrairy1(jpJFD.getJpPVBorder());
		model.getMc().regjpLibrairy2(jpJFD.getJpPVBorder2());
		model.getMc().regjpLibrairy3(jpJFD.getJpPVBorder3());
		model.getMc().regJpPlaylistView(jpJFD.getJpPlaylistViews());
		model.getMc().regjpArtistResize(jpJFD.getJpArtistResize());
		model.getMc().regjpAlbumResize(jpJFD.getJpAlbumResize());
		model.getMc().regjpPlaylistResize1(jpJFD.getJpInfoPSBorder());
		model.getMc().regjpPlaylistResize2(jpJFD.getJpPlaylistBorder());
		//model.getMc().regjpTrackContainer(jpJFD.getJpTrackContainer());

		/*
		 *  Add external elements 
		 */
		
		// Head info player
		JPanel CenterHost = jpJFD.getJpHBMain();
		
		jpLecteurInfo = new Gmm_PlayerInfoLecture(model);
		model.getMc().regJpInfo(jpLecteurInfo);
		CenterHost.add(jpLecteurInfo);	

		jpPlaylist = new Gmm_Playlist(model, model.getMc().jpPlaylist);
		model.getMp().regJpPlaylist(jpPlaylist);


		/*
		 * refresh appearance data
		 */
		try {
			ListUpdater.refreshArtistList(model);
			ListUpdater.refreshAlbumList(model);
			ListUpdater.refreshTrackTable(model);
		} catch (UnselectedLibraryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * Finitions
		 */		
		new ListUpdater(model);
		new ViewUpdater(model);
		new PlayButtonsUpdater(model);
		new InfoPisteLectureUpdater(model);
		new VoletHandler(model);
		new OptionHandler(model);
		new PlAddHandler(model);
		new PanelSlideHandler(model);
		//model.getMp().getPm().getMediaPlayer().
		
		/*
		 * on raffraichi l'image de fond
		 */
		/*model.getMc().jspTracks.getViewport().addChangeListener(
				new ChangeListener() {
					@Override
					public void stateChanged(ChangeEvent arg0) {
						model.getMc().jpTrackContainer.repaint();
						model.getMc().jtTableTrack.revalidate();
						model.getMc().jspTracks.revalidate();
					}
				} );*/
		
		
		GuiScrollBarUpdater.updateArtistSB(model);
		GuiScrollBarUpdater.updateAlbumSB(model);
		GuiScrollBarUpdater.updatePlaylistSB(model);
		GuiScrollBarUpdater.updateTrackSB(model);
		
		HeaderUpdater.instanciate(model);
		model.getMw().actionResize();
	}
	

	@Override
	public void stateChanged(ChangeEvent e) {
		revalidate();
	}


	/**
	 * @return the jpPlaylist
	 */
	public Gmm_Playlist getJpPlaylist() {
		return jpPlaylist;
	}
	
	
}
