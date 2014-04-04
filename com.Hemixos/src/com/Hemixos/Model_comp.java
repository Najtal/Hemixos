package com.Hemixos;

import gui_music_manager.BirdTempo;
import gui_music_manager.Gmm_PlayerInfoLecture;
import gui_music_manager.Gmm_PlayerInfoVolume;
import gui_music_manager.Gmm_Window;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.jdesktop.swingx.JXList;


/**
 * 
 * Ce model connait la référence de certains éléments nécessaires a différent moment de l'exécution par des instances très variées
 * 
 * @author Jean-Vital
 *
 */
public class Model_comp {



	private Model model;
	
	
	protected Gmm_PlayerInfoVolume jpVolume;
	public Gmm_PlayerInfoLecture jpInfo;
	public Gmm_Window gmm_Window;

	public JPanel jpHeadSpacerLeft;
	public JPanel jpHeadSpacerRight;

	public JXList jlArtistes;
	public JList jlAlbums;
	public JTable jtTableTrack;

	public JButton jbPlay;
	public JButton jbNext;
	public JButton jbPrevious;

	public JButton jbRandom;
	public JButton jbRepeat;

	public JButton jbViewSimple;
	public JButton jbViewOneC;
	public JButton jbViewTwoC;
	public JButton jbviewThreeC;

	public JPanel jpArtistlist;
	public JPanel jpAlbumslist;

	public JButton jbArtistsAll;
	public JButton jbalbumAll;

	public JScrollPane spArtist;
	public JScrollPane spPlaylistView;
	public JScrollPane spAlbum;
	public JScrollPane jspTracks;

	public JButton jbPisteImage;
	public JLabel jlTitleValue;
	public JLabel jlArtistValue;
	public JLabel jlAlbumValue;
	public JLabel jlDureeValue;

	public JPanel jpPlayingInfo;
	public JPanel jpOptions;

	public JButton jbOptions;
	public JButton jbVolet;
	public JButton jbPlAdd;

	public JPanel jpPlaylist;
	
	public JPanel jpPVBorder1;
	public JPanel jpPVBorder2;
	public JPanel jpPVBorder3;
	public JPanel jpArtistResize;
	public JPanel jpAlbumResize;
	public JPanel jpPlaylistResize1;
	public JPanel jpPlaylistResize2;
	public JPanel jpPlaylistViews;

	public BirdTempo jpTrackContainer;


	
	/**
	 * Constructor
	 * @param model
	 */
	public Model_comp(Model model) {
		
		this.model = model;
		
	}

	//public void regJpVolume(GmmC_Volume gmmC_Volume) {
	//	this.jpVolume = gmmC_Volume;
	//}
	
	public void regJpInfo(Gmm_PlayerInfoLecture gmm_PlayerInfoLecture) {
		this.jpInfo = gmm_PlayerInfoLecture;
	}

	public void regJpVolume(Gmm_PlayerInfoVolume gmm_PlayerInfoVolume) {
		this.jpVolume = gmm_PlayerInfoVolume;
	}

	public void regJfFrame(Gmm_Window gmm_Window) {
		this.gmm_Window = gmm_Window;		
	}
	
	public void regJpHeadSpacerLeft(JPanel j) {
		this.jpHeadSpacerLeft = j;
	}
	
	public void regJpHeadSpacerRight(JPanel j) {
		this.jpHeadSpacerRight = j;
	}

	public void regJlArtist(JXList jlArtistes) {
		this.jlArtistes = jlArtistes;
	}
	
	public void regJtTableTrack(JTable jtTableTrack) {
		this.jtTableTrack = jtTableTrack;
	}
	
	public void regJbPlay(JButton play) {
		this.jbPlay = play;
	}

	public void regJbNext(JButton jbNext) {
		this.jbNext = jbNext;
	}

	public void regJbPrevious(JButton jbPrevious) {
		this.jbPrevious = jbPrevious;
	}
	
	public void regJbRepeat(JButton jbRepeat) {
		this.jbRepeat = jbRepeat;
	}

	public void regJbRandom(JButton jbRandom) {
		this.jbRandom = jbRandom;
	}

	public void regJlAlbum(JList jlAlbums) {
		this.jlAlbums = jlAlbums;
	}

	public void regViewSimple(JButton jbViewSimple) {
		this.jbViewSimple = jbViewSimple;
	}

	public void regViewOne(JButton jbViewOneC) {
		this.jbViewOneC = jbViewOneC;
	}

	public void regViewTwo(JButton jbViewTwoC) {
		this.jbViewTwoC = jbViewTwoC;
	}

	public void regViewThree(JButton jbviewThreeC) {
		this.jbviewThreeC = jbviewThreeC;
	}

	public void regJpArtistList(JPanel jpArtistlist) {
		this.jpArtistlist = jpArtistlist;
	}

	public void regJpAlbumList(JPanel jpAlbumslist) {
		this.jpAlbumslist = jpAlbumslist;
	}

	public void regJbArtistAll(JButton jbArtistsAll) {
		this.jbArtistsAll = jbArtistsAll;
	}

	public void regJbAlbumAll(JButton jbalbumAll) {
		this.jbalbumAll = jbalbumAll;
	}

	public void regJSPArtist(JScrollPane spArtist) {
		this.spArtist = spArtist;
	}

	public void regJSPAlbum(JScrollPane spAlbum) {
		this.spAlbum = spAlbum;
	}

	public void regJSPlaylistView(JScrollPane spPlaylistView) {
		this.spPlaylistView = spPlaylistView;
	}

	public void regJSPTrack(JScrollPane jspTracks) {
		this.jspTracks = jspTracks;		
	}

	public void regImageInfoPiste(JButton jbPisteImage) {
		this.jbPisteImage = jbPisteImage;		
	}

	public void regTitreInfoPiste(JLabel jlTitleValue) {
		this.jlTitleValue = jlTitleValue;
	}

	public void regArtistInfoPiste(JLabel jlArtistValue) {
		this.jlArtistValue = jlArtistValue;
	}

	public void regAlbumInfoPiste(JLabel jlAlbumValue) {
		this.jlAlbumValue = jlAlbumValue;
	}

	public void regDureeInfoPiste(JLabel jlDureeValue) {
		this.jlDureeValue = jlDureeValue;
	}

	public void regJpEnLecture(JPanel jpPlayingInfo) {
		this.jpPlayingInfo = jpPlayingInfo;
	}

	public void regJpOption(JPanel jpOptions) {
		this.jpOptions = jpOptions;
	}

	public void regJbOptions(JButton jbOptions) {
		this.jbOptions = jbOptions;
	}

	public void regJbVolet(JButton jbVolet) {
		this.jbVolet = jbVolet;
	}
	
	public void regJpPlaylist(JPanel jpPlaylist) {
		this.jpPlaylist = jpPlaylist;
	}

	public void regJbPlAdd(JButton jbPlAdd) {
		this.jbPlAdd = jbPlAdd;
	}
	
	
	
	public void regjpArtistResize(JPanel jpArtistResize) {
		this.jpArtistResize = jpArtistResize;
	}
	
	public void regjpAlbumResize(JPanel jpAlbumResize) {
		this.jpAlbumResize = jpAlbumResize;
	}
	
	public void regjpPlaylistResize1(JPanel jpPlaylistResize1) {
		this.jpPlaylistResize1 = jpPlaylistResize1;
	}
	
	public void regjpPlaylistResize2(JPanel jpPlaylistResize2) {
		this.jpPlaylistResize2 = jpPlaylistResize2;
	}

	public void regjpLibrairy1(JPanel jpPVBorder1) {
		this.jpPVBorder1 = jpPVBorder1;
	}

	public void regjpLibrairy2(JPanel jpPVBorder2) {
		this.jpPVBorder2 = jpPVBorder2;
	}

	public void regjpLibrairy3(JPanel jpPVBorder3) {
		this.jpPVBorder3 = jpPVBorder3;		
	}

	public void regJpPlaylistView(JPanel jpPlaylistViews) {
		this.jpPlaylistViews = jpPlaylistViews;
	}

	public void regjpTrackContainer(BirdTempo jpTrackContainer) {
		this.jpTrackContainer = jpTrackContainer;
	}
}
