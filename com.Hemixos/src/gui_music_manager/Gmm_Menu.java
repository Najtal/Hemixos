package gui_music_manager;

import gui_generic_components.AbstractBorder_menu;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import properties.AbstractColors;
import properties.AbstractValues;

import com.Hemixos.Model;

public class Gmm_Menu extends JPanel {

	private static final long serialVersionUID = 1L;
	
	
	private Model model;


	private JPanel jpListeBibs;
	private JPanel jpListeVues;
	private JPanel jpPlaylists;

	
	/**
	 * Constructor
	 * @param model
	 */
	public Gmm_Menu(Model model) {
		
		this.model = model;
		
		this.setPreferredSize(new Dimension(AbstractValues.GUI_MN_WIDTH, HEIGHT));
		this.setBackground(AbstractColors.GUI_MN_BACKGROUND);
		
		this.setBorder(new AbstractBorder_menu());	
		
		initElements();

	}


	private void initElements() {

		JPanel tmp = new JPanel(new BorderLayout());
		tmp.setBackground(AbstractColors.GUI_MN_BACKGROUND);
		
		jpListeBibs = new Gmm_MenuBibs(model);
		jpListeVues = new Gmm_MenuVues(model);
		
		tmp.add(jpListeBibs, BorderLayout.NORTH);
		tmp.add(jpListeVues, BorderLayout.SOUTH);
		
		jpPlaylists = new Gmm_MenuPlaylists(model);
		
		this.add(tmp, BorderLayout.NORTH);
		this.add(jpPlaylists, BorderLayout.CENTER);
		
	}

}
