package gui_music_manager;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.Hemixos.Model;

public class Gmm_VueSimple extends JPanel implements ChangeListener {

	private static final long serialVersionUID = 1L;
	
	
	private Model model;

	private JPanel jpMenuTop;
	private JPanel jpList;
	
	
	/**
	 * Constructor
	 */
	public Gmm_VueSimple(Model model) {

		this.model = model;
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);

		model.getMw().addChangeListener(this);
		
		this.setBackground(Color.WHITE);
		
		jpMenuTop = new Gmm_VueMenuTop(model);
		jpList = new Gmm_VueListeTout(model);
		
		this.add(jpMenuTop, BorderLayout.NORTH);
		this.add(jpList, BorderLayout.CENTER);
		
	}


	@Override
	public void stateChanged(ChangeEvent arg0) {
		revalidate();
	}
	
	
}
