package gui_music_manager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;

import properties.AbstractColors;
import properties.AbstractImages;
import properties.AbstractValues;

import com.Hemixos.Model;

public class Gmm_PlayerOptionFrame extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	private Model model;
	
	private Icon iWMin;
	private Icon iWMax;
	private Icon iWEscape;
	private Icon iTouch;
	private Icon iOption;
	
	private JButton jbMin;
	public JButton jbMax;
	private JButton jbEscape;
	private JButton jbTouch;
	private JButton jbOption;

	private JPanel jpFrameButtons;
	private JPanel jpOptionButtons;

	
	/**
	 * Constructor
	 * @param model
	 */
	public Gmm_PlayerOptionFrame(Model model) {

		this.model = model;
			
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(AbstractValues.GUI_PL_OP_WIDTH, AbstractValues.GUI_PL_HEIGHT-10));
		this.setBackground(AbstractColors.GUI_PL_BACKGROUND);

		initComponents();
		
		initButtons();
		
		//this.add(jpFrameButtons, BorderLayout.NORTH);
		this.add(jpOptionButtons, BorderLayout.CENTER);
	}
	
	
	private void initButtons() {
		
		jpFrameButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
		jpFrameButtons.setBorder(BorderFactory.createEmptyBorder(9, 0, 0, 2));
		jpFrameButtons.setBackground(AbstractColors.GUI_PL_BACKGROUND);

		
		jpFrameButtons.add(jbMin);
		jpFrameButtons.add(jbMax);
		jpFrameButtons.add(jbEscape);

		
		jpOptionButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
		jpOptionButtons.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		jpOptionButtons.setBackground(AbstractColors.GUI_PL_BACKGROUND);

		jpOptionButtons.add(jbTouch);
		jpOptionButtons.add(jbOption);
		
	}


	private void initComponents() {
		
		iWMin = AbstractImages.instance.GUI_PLAYER_W_MIN;
		iWMax = AbstractImages.instance.GUI_PLAYER_W_MAX;
		iWEscape = AbstractImages.instance.GUI_PLAYER_W_ESCAPE;
		iTouch = AbstractImages.instance.GUI_PLAYER_TOUCH;
		iOption = AbstractImages.instance.GUI_PLAYER_OPTION;		

		jbMin = new JButton(iWMin);
		jbMax = new JButton(iWMax);
		jbEscape = new JButton(iWEscape);
		jbTouch = new JButton(iTouch);
		jbOption = new JButton(iOption);
		
		jbMin.setBackground(AbstractColors.GUI_PL_BACKGROUND);
		jbMin.setBorderPainted(false);
		jbMin.setBorder(null);
		
		jbMax.setBackground(AbstractColors.GUI_PL_BACKGROUND);
		jbMax.setBorderPainted(false);
		jbMax.setBorder(null);
		
		jbEscape.setBackground(AbstractColors.GUI_PL_BACKGROUND);
		jbEscape.setBorderPainted(false);
		jbEscape.setBorder(null);
		
		jbTouch.setBackground(AbstractColors.GUI_PL_BACKGROUND);
		jbTouch.setBorderPainted(false);
		jbTouch.setBorder(null);
		
		jbOption.setBackground(AbstractColors.GUI_PL_BACKGROUND);
		jbOption.setBorderPainted(false);
		jbOption.setBorder(null);
		
		
		jbMin.addActionListener(this);
		jbMax.addActionListener(this);
		jbEscape.addActionListener(this);
		jbTouch.addActionListener(this);
		jbOption.addActionListener(this);
		
	
	}


	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == jbMin)
			model.getMw().actionMinimize();
		
		if (ae.getSource() == jbMax)
			model.getMw().actionMaximize();
		
		if (ae.getSource() == jbEscape)
			model.getMw().actionEscape();
		
		if (ae.getSource() == jbTouch)
			model.getMw().actionTouch();
		
		if (ae.getSource() == jbOption)
			model.getMw().actionOption();
		
	}

	
}
