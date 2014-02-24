package gui_actionUpdater;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import properties.AbstractImages;

import com.Hemixos.Model;


/**
 * 
 * Cette classe gère les boutons de changement de vues
 * 
 * @author Jean-Vital
 *
 */
public class ViewUpdater implements ActionListener {

	
	
	private Model model;
	
	private JButton jbVSimple;
	private JButton jbVOne;
	private JButton jbVTwo;
	private JButton jbVThree;

	/**
	 * Constructor
	 * @param model
	 */
	public ViewUpdater(Model model) {
		this.model = model;
		
		this.jbVSimple = model.getMc().jbViewSimple;
		this.jbVOne = model.getMc().jbViewOneC;
		this.jbVTwo = model.getMc().jbViewTwoC;
		this.jbVThree = model.getMc().jbviewThreeC;
		
		jbVSimple.addActionListener(this);
		jbVOne.addActionListener(this);
		jbVTwo.addActionListener(this);
		jbVThree.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		reinitIcons();
		
		if (ae.getSource() == jbVSimple) {
			jbVSimple.setIcon(AbstractImages.instance.GUI_VIEW_SIMPLE_LIST_SELECTED);
			model.getMw().actionViewSimpleList();
		} else if (ae.getSource() == jbVOne) {
			jbVOne.setIcon(AbstractImages.instance.GUI_VIEW_ONE_LIST_SELECTED);
			model.getMw().actionViewOneList();
		} else if (ae.getSource() == jbVTwo) {
			jbVTwo.setIcon(AbstractImages.instance.GUI_VIEW_TWO_LIST_SELECTED);
			model.getMw().actionViewTwoList();
		} else if (ae.getSource() == jbVOne) {
			jbVThree.setIcon(AbstractImages.instance.GUI_VIEW_THREE_LIST_SELECTED);
			model.getMw().actionViewThreeList();
		}
		
		
	}

	private void reinitIcons() {
		jbVSimple.setIcon(AbstractImages.instance.GUI_VIEW_SIMPLE_LIST);
		jbVOne.setIcon(AbstractImages.instance.GUI_VIEW_ONE_LIST);
		jbVTwo.setIcon(AbstractImages.instance.GUI_VIEW_TWO_LIST);
		jbVThree.setIcon(AbstractImages.instance.GUI_VIEW_THREE_LIST);
	}
	
}
