package com.Hemixos;

import gui_music_manager.Gmm_Container;
import gui_music_manager.Gmm_OptionList;
import gui_music_manager.Gmm_PlayerInfoLecture;
import gui_music_manager.Gmm_PlayerInfoVolet;
import gui_music_manager.Gmm_PlayerInfoVolume;
import gui_music_manager.Gmm_Window;

import javax.swing.JList;
import javax.swing.JPanel;

public class Model_comp {

	private Model model;
	
	
	protected Gmm_PlayerInfoVolume jpVolume;
	protected Gmm_PlayerInfoLecture jpInfo;
	public Gmm_OptionList jpVolet;
	public Gmm_PlayerInfoVolet playerVolet;
	public JPanel jpContentCenter;
	public Gmm_Window gmm_Window;
	public Gmm_Container gmm_Container;
	public JList<String> listeArtiste;
	
	
	
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

	public void regJpVolet(Gmm_OptionList gmm_OptionList) {
		this.jpVolet = gmm_OptionList;
	}

	public void regJpPlayerVolet(Gmm_PlayerInfoVolet gmm_PlayerInfoVolet) {
		this.playerVolet = gmm_PlayerInfoVolet;
	}

	public void regJfFrame(Gmm_Window gmm_Window) {
		this.gmm_Window = gmm_Window;		
	}

	public void regVueCenter(Gmm_Container gmm_Container) {
		this.gmm_Container = gmm_Container;

	}

	public void regListArtist(JList<String> liste) {
		this.listeArtiste = liste;
	}

}
