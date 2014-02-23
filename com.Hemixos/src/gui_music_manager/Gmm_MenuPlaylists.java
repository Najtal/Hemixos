package gui_music_manager;

import java.awt.Color;

import javax.swing.JPanel;

import properties.AbstractColors;

import com.Hemixos.Model;

public class Gmm_MenuPlaylists extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Model model;

	public Gmm_MenuPlaylists(Model model) {

		this.model = model;
		this.setBackground(AbstractColors.GUI_MN_BACKGROUND);
		
	}

}
