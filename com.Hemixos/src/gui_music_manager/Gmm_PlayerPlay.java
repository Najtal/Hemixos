package gui_music_manager;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import properties.AbstractColors;
import properties.AbstractImages;
import properties.AbstractValues;

import com.Hemixos.Model;


/**
 * Gère l'apparence des boutons de lecture du lecteur
 * @author Jean-Vital
 *
 */
public class Gmm_PlayerPlay extends JPanel implements ActionListener, ChangeListener {

	private static final long serialVersionUID = 1L;
	
	// Model
	private Model model;

	// Elements du panel
	private Icon iPrevious;
	private Icon iNext;
	private Icon iPlay;
	private Icon iPause;

	private JButton jbPrevious;
	private JButton jbNext;
	private JButton jbPlay;

	private JPanel jpPlayerButtons;
	
	
	/**
	 * Constructor
	 * @param model
	 */
	public Gmm_PlayerPlay(Model model) {

		this.model = model;		
		model.getMp().addChangeListener(this);
				
		this.setPreferredSize(new Dimension(AbstractValues.GUI_PL_PL_WIDTH, AbstractValues.GUI_PL_HEIGHT-10));
		this.setBackground(AbstractColors.GUI_PL_BACKGROUND);

		
		initComponents();
		
		initbuttons();
		
		this.add(jpPlayerButtons);
				
	}
	
	
	
	private void initComponents() {
		
		iPrevious = AbstractImages.instance.GUI_PLAYER_PREVIOUS;
		iNext = AbstractImages.instance.GUI_PLAYER_NEXT;
		iPlay= AbstractImages.instance.GUI_PLAYER_PLAY;
		iPause= AbstractImages.instance.GUI_PLAYER_PAUSE;
		
		jbPrevious = new JButton(iPrevious);
		jbNext = new JButton(iNext);
		jbPlay = new JButton(iPlay);		
		
		jbPrevious.setBackground(AbstractColors.GUI_PL_BACKGROUND);
		jbPrevious.setBorderPainted(false);
		jbPrevious.setBorder(null);
		
		jbNext.setBackground(AbstractColors.GUI_PL_BACKGROUND);
		jbNext.setBorderPainted(false);
		jbNext.setBorder(null);
		
		jbPlay.setBackground(AbstractColors.GUI_PL_BACKGROUND);
		jbPlay.setBorderPainted(false);
		jbPlay.setBorder(null);
	}



	private void initbuttons() {
		
		jpPlayerButtons = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
		jpPlayerButtons.setBorder(BorderFactory.createEmptyBorder(12, 0, 0, 0));
		jpPlayerButtons.setBackground(AbstractColors.GUI_PL_BACKGROUND);

		jbPrevious.addActionListener(this);
		jbPlay.addActionListener(this);
		jbNext.addActionListener(this);
		
		jpPlayerButtons.add(jbPrevious);
		jpPlayerButtons.add(jbPlay);
		jpPlayerButtons.add(jbNext);
		
	}



	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawString(model.getMw().getAppName(), 6, 15);
		
	}



	@Override
	public void stateChanged(ChangeEvent e) {
		
		if (model.getMp().isEnLecture()) {
			jbPlay.setIcon(iPause);
		} else {
			jbPlay.setIcon(iPlay);
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == jbPrevious)
			model.getMp().actionPrevious();
		
		if (ae.getSource() == jbPlay)
			model.getMp().actionPlay();
		
		if (ae.getSource() == jbNext)
			model.getMp().actionNext();
		
	}



	
	
	
}
