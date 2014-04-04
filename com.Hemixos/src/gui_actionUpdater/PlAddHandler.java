package gui_actionUpdater;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;

import properties.AbstractImages;
import threads.VoletManager;

import com.Hemixos.Model;

public class PlAddHandler implements ActionListener {

	private Model model;
	
	private JButton jbPlus;
	private Icon iPlus;
	private Icon iMoins;
	

	/**
	 * Constructor
	 * @param model
	 */
	public PlAddHandler(Model model) {

		this.model = model;
		
		this.iPlus = AbstractImages.instance.GUI_PLAYER_ADDPLAYLIST_SELECTED;
		this.iMoins = AbstractImages.instance.GUI_PLAYER_ADDPLAYLIST;
		
		jbPlus = model.getMc().jbPlAdd;
		jbPlus.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if (model.getMp().isAddToPL()) {
			jbPlus.setIcon(iMoins);
			model.getMp().setAddToPL(false);
			
		} else {
			jbPlus.setIcon(iPlus);
			model.getMp().setAddToPL(true);
		}
		
	}

}
