package gui_actionUpdater;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import properties.AbstractImages;

import com.Hemixos.Model;


/**
 * 
 * Cette classe met a jour les boutons du Header
 * 
 * @author Jean-Vital
 *
 */
public class PlayButtonsUpdater implements ChangeListener, ActionListener {

	
	private Model model;
	
	private JButton jbPlay;
	private JButton jbNext;
	private JButton jbPrevious;
	
	private JButton jbRandom;
	private JButton jbRepeat;

	private Icon iPlay;
	private Icon iPause;
	
	private Icon iRandom;
	private Icon iRepeat;
	private Icon iRandomSelected;
	private Icon iRepeatSelected;


	/**
	 * Constructor
	 * @param model
	 */
	public PlayButtonsUpdater(Model model) {
		this.model = model;
		this.model.getMw().addChangeListener(this);
		this.model.getMp().addChangeListener(this);
		
		// Gestion des boutons
		jbPlay = model.getMc().jbPlay;
		jbNext = model.getMc().jbNext;
		jbPrevious = model.getMc().jbPrevious;
		
		jbPlay.addActionListener(this);
		jbPrevious.addActionListener(this);
		jbNext.addActionListener(this);
		
		jbRandom = model.getMc().jbRandom;
		jbRepeat = model.getMc().jbRepeat;
		
		jbRandom.addActionListener(this);
		jbRepeat.addActionListener(this);
		
		// Chargement des images
		iPlay= AbstractImages.instance.GUI_PLAYER_PLAY;
		iPause= AbstractImages.instance.GUI_PLAYER_PAUSE;
		iRandom = AbstractImages.instance.GUI_PLAYER_RANDOM;
		iRepeat = AbstractImages.instance.GUI_PLAYER_REPEAT;	
		iRandomSelected = AbstractImages.instance.GUI_PLAYER_RANDOM_SELECTED;
		iRepeatSelected = AbstractImages.instance.GUI_PLAYER_REPEAT_SELECTED;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		
		// Bouton play
		if (model.getMp().isEnLecture())
			jbPlay.setIcon(iPause);
		else
			jbPlay.setIcon(iPlay);
		
		
		// Bouton Random
		if (model.getMp().isRandom())
			jbRandom.setIcon(iRandomSelected);
		else
			jbRandom.setIcon(iRandom);
		
		
		// Bouton Repeat
		if (model.getMp().isRepeat())
			jbRepeat.setIcon(iRepeatSelected);
		else
			jbRepeat.setIcon(iRepeat);
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == jbPrevious)
			model.getMp().actionPrevious();
		
		if (ae.getSource() == jbPlay)
			model.getMp().actionPlay();
		
		if (ae.getSource() == jbNext)
			model.getMp().actionNext();
		
		if (ae.getSource() == jbRandom)
			model.getMp().setRandom(!model.getMp().isRandom());
		
		if (ae.getSource() == jbRepeat)
			model.getMp().setRepeat(!model.getMp().isRepeat());
	}

	
	
}
