package gui_music_manager;

import gui_generic_components.ListenerFrameMove;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import properties.AbstractColors;
import properties.AbstractImages;
import properties.AbstractPropKey;
import properties.AbstractValues;

import com.Hemixos.Model;

public class Gmm_Player extends JPanel {

	private static final long serialVersionUID = 1L;

	
	private Model model;

	private Gmm_PlayerPlay playButtons;
	private Gmm_PlayerOption optionButtons;
	private Gmm_PlayerInfo infoButtons;

	
	/**
	 * Constructor
	 * @param model the model of the app
	 */
	public Gmm_Player(Model model) {
		
		this.model = model;
		
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(WIDTH, AbstractValues.GUI_PL_HEIGHT));
		this.setBackground(AbstractColors.GUI_PL_BACKGROUND);
		
		// init player buttons (play pause next previous)
		playButtons = new Gmm_PlayerPlay(model);
		this.add(playButtons, BorderLayout.WEST);
		
		// init frame/option buttons
		optionButtons = new Gmm_PlayerOption(model);
		this.add(optionButtons, BorderLayout.EAST);
		
		
		// init main info buttons
		infoButtons = new Gmm_PlayerInfo(model);
		this.add(infoButtons, BorderLayout.CENTER);
		
		
		this.setBorder(BorderFactory.createMatteBorder(0, 0, AbstractValues.GUI_PL_BORDER_BOTTOM_WIDTH, 0, AbstractColors.GUI_PL_BORDER_BOTTOM));

		this.addMouseMotionListener(new ListenerFrameMove(model));
		
	}


}



