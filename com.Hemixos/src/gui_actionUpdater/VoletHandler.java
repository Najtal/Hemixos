package gui_actionUpdater;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;

import properties.AbstractImages;
import threads.VoletManager;

import com.Hemixos.Model;


/**
 * 
 * Cette classe gère le bouton du volet ainsi que son action
 * 
 * @author Jean-Vital
 *
 */
public class VoletHandler implements ActionListener {

	private Model model;
	
	private JButton jbVolet;
	private Icon iOuvert;
	private Icon iFerme;
	

	/**
	 * Constructor
	 * @param model
	 */
	public VoletHandler(Model model) {

		this.model = model;
		
		this.iOuvert = AbstractImages.instance.GUI_PLAYER_VOLET_SELECTED;
		this.iFerme = AbstractImages.instance.GUI_PLAYER_VOLET;
		
		jbVolet = model.getMc().jbVolet;
		jbVolet.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if (model.getMw().isVoletEnAction())
			return;
		
		if (model.getMw().isVoletOuvert()) {
			jbVolet.setIcon(iFerme);
			new VoletManager(model);
			
		} else {
			jbVolet.setIcon(iOuvert);
			new VoletManager(model);
		}
		
	}

}
