package gui_music_manager;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class Gmm_PlayerInfoVolet extends JPanel implements ActionListener, ChangeListener {

	private static final long serialVersionUID = 1L;
	
	
	private Model model;
	
	
	public JButton jbVolet;
	public JButton jbAdd;

	private Icon iVolet;
	private Icon iPlus;
	private Icon iVoletSelected;
	private Icon iPlusSelected;
	
	private Border eastBorder;
	

	public Gmm_PlayerInfoVolet(Model model) {
		
		this.model = model;
		this.model.getMc().regJpPlayerVolet(this);
		this.model.getMw().addChangeListener(this);
		
		this.setBackground(AbstractColors.GUI_PL_BACKGROUND);
		this.setLayout(new FlowLayout());
		
		initBorder();
		
		initComponents();
		
		this.add(jbVolet);
		this.add(jbAdd);
		
	}

	private void initComponents() {
		
		iVolet = AbstractImages.instance.GUI_PLAYER_VOLET;
		iPlus = AbstractImages.instance.GUI_PLAYER_ADDPLAYLIST;		
		iVoletSelected = AbstractImages.instance.GUI_PLAYER_VOLET_SELECTED;
		iPlusSelected = AbstractImages.instance.GUI_PLAYER_ADDPLAYLIST_SELECTED;	
		
		if (model.getMw().isVoletOuvert()) {
			jbVolet = new JButton(iVoletSelected);
		} else {
			jbVolet = new JButton(iVolet);
		}
		
		if (model.getMp().isAddToPL()) {
			jbAdd = new JButton(iPlusSelected);
		} else {
			jbAdd = new JButton(iPlus);
		}
		
		jbVolet.setBackground(AbstractColors.GUI_PL_BACKGROUND);
		jbVolet.setBorder(null);
		jbVolet.setBorderPainted(false);
		
		jbAdd.setBackground(AbstractColors.GUI_PL_BACKGROUND);
		jbAdd.setBorder(null);
		jbAdd.setBorderPainted(false);
		
		jbAdd.addActionListener(this);
		jbVolet.addActionListener(this);
		
	}

	private void initBorder() {
		this.eastBorder = BorderFactory.createEmptyBorder(17, 0, 0, model.getMw().getBorderTampon()+15);
		this.setBorder(eastBorder);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if (ae.getSource() == jbVolet) {
			model.getMw().actionVolet();
		} else if (ae.getSource() == jbAdd) {
			model.getMw().actionAddPlaylist();
		}
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		
		initBorder();
		
		if (model.getMw().isVoletOuvert()) {
			jbVolet.setIcon(iVoletSelected);
		} else {
			jbVolet.setIcon(iVolet);
		}
		
		if (model.getMp().isAddToPL()) {
			jbAdd.setIcon(iPlusSelected);
		} else {
			jbAdd.setIcon(iPlus);
		}
		
		repaint();
		revalidate();
	}
	
}