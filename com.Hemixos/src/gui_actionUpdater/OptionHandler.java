package gui_actionUpdater;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import threads.OptionManager;

import com.Hemixos.Model;


/**
 * 
 * Cette classe gère le bouton du volet ainsi que son action
 * 
 * @author Jean-Vital
 *
 */
public class OptionHandler implements ActionListener {

	private Model model;
	
	private JButton jbOptions;
	

	/**
	 * Constructor
	 * @param model
	 */
	public OptionHandler(Model model) {

		this.model = model;
		
		jbOptions = model.getMc().jbOptions;
		jbOptions.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if (model.getMw().isVoletEnAction())
			return;
		
		if (model.getMw().isVoletOuvert()) {
			new OptionManager(model);
			
		} else {
			new OptionManager(model);
		}
		
	}

}
