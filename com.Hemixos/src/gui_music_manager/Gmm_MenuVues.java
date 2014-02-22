package gui_music_manager;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;

import properties.AbstractColors;
import properties.AbstractImages;

import com.Hemixos.Model;

public class Gmm_MenuVues extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private Model model;

	private Icon iSimpleList;
	private Icon iOneLists;
	private Icon iTwoList;
	private Icon iThreeList;
	
	private Icon iSimpleListSelected;
	private Icon iOneListsSelected;
	private Icon iTwoListSelected;
	private Icon iThreeListSelected;
	
	private JButton jbSimpleList;
	private JButton jbOneList;
	private JButton jbTwoList;
	private JButton jbThreeList;	

	public Gmm_MenuVues(Model model) {
		
		this.model = model;
		
		this.setLayout(new GridLayout(0, 4));
		
		//this.setBorder(new AbstractBorder_vues());
		this.setBackground(AbstractColors.GUI_MN_BACKGROUND);
		
		initComponents();
		
		//model.getMw().actionViewSimpleList();
		
	}

	
	private void initComponents() {
		
		// Load images
		iSimpleList = AbstractImages.instance.GUI_VIEW_SIMPLE_LIST;
		iOneLists = AbstractImages.instance.GUI_VIEW_ONE_LIST;
		iTwoList = AbstractImages.instance.GUI_VIEW_TWO_LIST;
		iThreeList = AbstractImages.instance.GUI_VIEW_THREE_LIST;
		
		iSimpleListSelected = AbstractImages.instance.GUI_VIEW_SIMPLE_LIST_SELECTED;
		iOneListsSelected = AbstractImages.instance.GUI_VIEW_ONE_LIST_SELECTED;
		iTwoListSelected = AbstractImages.instance.GUI_VIEW_TWO_LIST_SELECTED;
		iThreeListSelected = AbstractImages.instance.GUI_VIEW_THREE_LIST_SELECTED;
		
		// Init buttons
		jbSimpleList = new JButton(iSimpleListSelected);
		jbOneList = new JButton(iOneLists);
		jbTwoList = new JButton(iTwoList);
		jbThreeList = new JButton(iThreeList);
		
		// Listeners
		jbSimpleList.addActionListener(this);
		jbOneList.addActionListener(this);
		jbTwoList.addActionListener(this);
		jbThreeList .addActionListener(this);
		
		
		// Styles
		jbSimpleList.setBackground(AbstractColors.GUI_PL_BACKGROUND);
		jbSimpleList.setBorderPainted(false);
		jbSimpleList.setBorder(null);
		
		jbOneList.setBackground(AbstractColors.GUI_PL_BACKGROUND);
		jbOneList.setBorderPainted(false);
		jbOneList.setBorder(null);
		
		jbTwoList.setBackground(AbstractColors.GUI_PL_BACKGROUND);
		jbTwoList.setBorderPainted(false);
		jbTwoList.setBorder(null);
		
		jbThreeList.setBackground(AbstractColors.GUI_PL_BACKGROUND);
		jbThreeList.setBorderPainted(false);
		jbThreeList.setBorder(null);
		
		this.add(jbSimpleList);
		this.add(jbOneList);
		this.add(jbTwoList);
		this.add(jbThreeList);
	}


	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == jbOneList) {
			
			jbSimpleList.setIcon(iSimpleList);
			jbOneList.setIcon(iOneListsSelected);
			jbTwoList.setIcon(iTwoList);
			jbThreeList.setIcon(iThreeList);
			
			model.getMw().actionViewOneList();
			
		} else if (ae.getSource() == jbSimpleList) {
			
			jbSimpleList.setIcon(iSimpleListSelected);
			jbOneList.setIcon(iOneLists);
			jbTwoList.setIcon(iTwoList);
			jbThreeList.setIcon(iThreeList);
			
			model.getMw().actionViewSimpleList();
		
		} else if (ae.getSource() == jbTwoList) {
			
			jbSimpleList.setIcon(iSimpleList);
			jbOneList.setIcon(iOneLists);
			jbTwoList.setIcon(iTwoListSelected);
			jbThreeList.setIcon(iThreeList);
			
			model.getMw().actionViewTwoList();
			
		} else if (ae.getSource() == jbThreeList) {
			
			jbSimpleList.setIcon(iSimpleList);
			jbOneList.setIcon(iOneLists);
			jbTwoList.setIcon(iTwoList);
			jbThreeList.setIcon(iThreeListSelected);
			
			model.getMw().actionViewThreeList();
			
		}
		
	}

}
