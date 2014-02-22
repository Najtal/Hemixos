package gui_music_manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

import properties.AbstractColors;
import properties.AbstractPropKey;
import properties.AbstractValues;

import com.Hemixos.Model;

public class Gmm_VueMenuTop extends JPanel {

	
	
	private Model model;
	
	
	
	// JBUTTONS
	private JButton jbETout;
	
	

	/**
	 * Constructor
	 */
	public Gmm_VueMenuTop(Model model) {

		this.model = model;
		
		this.setLayout(new BorderLayout());
		this.setBackground(AbstractColors.GUI_VUE_MENUTOP);
		this.setPreferredSize(new Dimension(WIDTH, AbstractValues.GUI_VUE_MENUTOP_HEIGHT));
		
		initButtons();
		
		initEasyLectureButtons();
		
		initInfoButtons();
	}

	private void initButtons() {
		
		Font butStyle = new Font("Segoe UI", Font.PLAIN, 12);
		
		
		jbETout = new JButton(model.getMw().getLangProperty(AbstractPropKey.VUE_MENUTOP_ECOUTER_TOUT));
		
		
		
		jbETout.setBackground(AbstractColors.GUI_VUE_MENUTOP);
		jbETout.setFont(butStyle);
		jbETout.setForeground(AbstractColors.GUI_VUE_MENUTOP_BUTTON);
		jbETout.setBorder(null);		
	}

	private void initInfoButtons() {
		// TODO Auto-generated method stub
		
	}

	private void initEasyLectureButtons() {

		JPanel jpButList = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		jpButList.setBackground(AbstractColors.GUI_VUE_MENUTOP);
		
		// SIMPLE LIST
		if (model.getMw().getVueSelected() == model.getMw().SIMPLE_LIST) {
			
			jpButList.add(jbETout);
			
		}
		
		this.add(jpButList, BorderLayout.WEST);
		
	}
	
}
