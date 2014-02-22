package gui_music_manager;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import properties.AbstractColors;
import properties.AbstractValues;

import com.Hemixos.Model;

public class Gmm_Container extends JPanel implements ChangeListener {

	private static final long serialVersionUID = 1L;
	
	private Model model;

	/**
	 * Constructor
	 * @param model
	 */
	public Gmm_Container(Model model) {

		this.model = model;
		this.model.getMw().addChangeListener(this);
		model.getMc().regVueCenter(this);
				
		this.setLayout(new BorderLayout());
		this.setBackground(AbstractColors.GUI_MAIN_CONTENT_BACKGROUND);	
		
		model.getMw().actionViewSimpleList();
	}

	public void setViewContent(JPanel vue) {
		
		this.removeAll();
		this.add(vue, BorderLayout.CENTER);
		repaint();
		revalidate();

	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		repaint();
		revalidate();		
	}
	
}
