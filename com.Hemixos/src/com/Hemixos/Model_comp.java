package com.Hemixos;

import gui_music_manager.Gmm_PlayerInfoLecture;
import gui_music_manager.Gmm_PlayerInfoVolume;
import gui_music_manager.Gmm_Window;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;


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

	public JList jlArtistes;
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

	public void regJlArtist(JList jlArtistes) {
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
	
}
