package gui_music_manager;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import properties.AbstractColors;
import properties.AbstractValues;

import com.Hemixos.Model;


public class Gmm_PlayerOption extends JPanel {

	private Model model;
	
	private Gmm_PlayerOptionRecherche recherche;
	private Gmm_PlayerOptionFrame frame;

	
	/**
	 * Constructor
	 * @param model
	 */
	public Gmm_PlayerOption(Model model) {

		this.model = model;
			
		this.setLayout(new BorderLayout());;
		this.setPreferredSize(new Dimension(AbstractValues.GUI_PL_OP_WIDTH + AbstractValues.GUI_PL_RE_WIDTH, AbstractValues.GUI_PL_HEIGHT-10));
		this.setBackground(AbstractColors.GUI_PL_BACKGROUND);

		recherche = new Gmm_PlayerOptionRecherche(model);
		frame = new Gmm_PlayerOptionFrame(model);
		
		this.add(recherche, BorderLayout.CENTER);
		this.add(frame, BorderLayout.EAST);
		
	}
	

	
	
}
