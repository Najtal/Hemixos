package gui_music_manager;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import properties.AbstractColors;
import properties.AbstractValues;

import com.Hemixos.Model;

public class Gmm_PlayerOptionRecherche extends JPanel {

	private static final long serialVersionUID = 1L;
	private Model model;

	/**
	 * Constructor
	 * @param model
	 */
	public Gmm_PlayerOptionRecherche(Model model) {
		
		this.model = model;
	
		this.setBackground(AbstractColors.GUI_PL_BACKGROUND);
		this.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		
		JTextField jtfRecherche = new JTextField();
		jtfRecherche.setPreferredSize(new Dimension(AbstractValues.GUI_PL_RE_WIDTH, 25));
		Border rechercheBorder = BorderFactory.createLineBorder(AbstractColors.GUI_RE_BORDER, 1, false);
		jtfRecherche.setBorder(rechercheBorder);
		
		
		this.add(jtfRecherche);
		
	}
	
}
