package gui_music_manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import properties.AbstractColors;
import properties.AbstractImages;

import com.Hemixos.Model;

public class Gmm_PlayerInfoVolume extends JPanel implements ChangeListener, ActionListener {

	private static final long serialVersionUID = 1L;

	private Model model;

	private Border westBorder;
	
	private Component volume;
	private JButton jbRandom;
	private JButton jbRepeat;

	private Icon iRandom;
	private Icon iRepeat;
	private Icon iRandomSelected;
	private Icon iRepeatSelected;
	
	/**
	 * Constructor
	 * @param model
	 */
	public Gmm_PlayerInfoVolume(Model model) {

		this.model = model;
		this.model.getMc().regJpVolume(this);
		model.getMw().addChangeListener(this);
		
		this.setBackground(AbstractColors.GUI_PL_BACKGROUND);
		this.setLayout(new FlowLayout(FlowLayout.TRAILING));
		
		initBorder();
		
		initComponents();
		
		this.add(volume);
		this.add(jbRandom);
		this.add(jbRepeat);
		
	}

	private void initComponents() {

		volume = new GmmC_Volume(model);
		
		// Chargement des images
		iRandom = AbstractImages.instance.GUI_PLAYER_RANDOM;
		iRepeat = AbstractImages.instance.GUI_PLAYER_REPEAT;	
		iRandomSelected = AbstractImages.instance.GUI_PLAYER_RANDOM_SELECTED;
		iRepeatSelected = AbstractImages.instance.GUI_PLAYER_REPEAT_SELECTED;

		// init des boutons
		jbRandom = new JButton(iRandom);
		jbRepeat = new JButton(iRepeat);
		
		// Listeners
		jbRandom.addActionListener(this);
		jbRepeat.addActionListener(this);
		
		// Style des boutons
		jbRandom.setBackground(AbstractColors.GUI_PL_BACKGROUND);
		jbRandom.setBorderPainted(false);
		jbRandom.setBorder(null);

		jbRepeat.setBackground(AbstractColors.GUI_PL_BACKGROUND);
		jbRepeat.setBorderPainted(false);
		jbRepeat.setBorder(null);

		
	}

	private void initBorder() {
		this.westBorder = BorderFactory.createEmptyBorder(0, model.getMw().getBorderTampon(), 0, 5);
		this.setBorder(westBorder);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		
		if (model.getMp().isRandom()) {
			jbRandom.setIcon(iRandomSelected);
		} else {
			jbRandom.setIcon(iRandom);
		}
		
		if (model.getMp().isRepeat()) {
			jbRepeat.setIcon(iRepeatSelected);
		} else {
			jbRepeat.setIcon(iRepeat);
		}
		
		initBorder();
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if (ae.getSource() == jbRandom) {
			model.getMw().actionRandom();
			
		} else if (ae.getSource() == jbRepeat) {
			model.getMw().actionRepeat();

		}
		
	}

}
