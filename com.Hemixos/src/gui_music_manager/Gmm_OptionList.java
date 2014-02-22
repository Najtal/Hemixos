package gui_music_manager;

import gui_generic_components.AbstractBorder_playlist;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import properties.AbstractColors;
import properties.AbstractValues;

import com.Hemixos.Model;

public class Gmm_OptionList extends JPanel {

	private static final long serialVersionUID = 1L;

	
	private Model model;

	
	/**
	 * Constructor
	 * @param model the model of the app
	 */
	public Gmm_OptionList(Model model) {

		this.model = model;
		
		this.model.getMc().regJpVolet(this);
		
		this.setPreferredSize(new Dimension(AbstractValues.GUI_MN_WIDTH, HEIGHT));
		this.setBackground(AbstractColors.GUI_OP_BACKGROUND);
		this.setBorder(new AbstractBorder_playlist());

	}


}
