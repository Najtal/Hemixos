package gui_music_manager;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import properties.AbstractColors;
import properties.AbstractValues;

import com.Hemixos.Model;



public class Gmm_PlayerInfo extends JPanel {


	private static final long serialVersionUID = 1L;
	
	private Model model;
	private Gmm_PlayerInfoVolume volume;
	private Gmm_PlayerInfoLecture lecture;
	private Gmm_PlayerInfoVolet volet;


	/**
	 * Constructor
	 * @param model
	 */
	public Gmm_PlayerInfo(Model model) {

		this.model = model;
		
		this.setLayout(new BorderLayout());;
		this.setBackground(AbstractColors.GUI_PL_BACKGROUND);

		volume = new Gmm_PlayerInfoVolume(model);
		lecture = new Gmm_PlayerInfoLecture(model);
		volet = new Gmm_PlayerInfoVolet(model);
		
		this.add(volume, BorderLayout.WEST);
		this.add(lecture, BorderLayout.CENTER);
		this.add(volet, BorderLayout.EAST);

	}
	
}
