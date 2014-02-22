package gui_music_manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import properties.AbstractValues;

import com.Hemixos.Model;

public class Gmm_VueOne extends JPanel implements ChangeListener {

	private static final long serialVersionUID = 1L;
	
	
	private Model model;

	private JPanel jpMenuTop;
	private JPanel jpList;
	
	
	/**
	 * Constructor
	 */
	public Gmm_VueOne(Model model) {

		this.model = model;
		model.getMw().addChangeListener(this);
		
		this.setLayout(new BorderLayout());
		
		JPanel centreListeArtist = new JPanel(new BorderLayout());
		this.add(centreListeArtist, BorderLayout.WEST);
		centreListeArtist.setPreferredSize(new Dimension(AbstractValues.GUI_VUE_ARTIST_WIDTH, centreListeArtist.getHeight()));
		
		JPanel listeArtist = new Gmm_VueListeArtiste(model, centreListeArtist.getHeight());
		centreListeArtist.add(listeArtist, BorderLayout.CENTER);
		
		JPanel listeTout = new Gmm_VueSimple(model);
		this.add(listeTout, BorderLayout.CENTER);
	
	}


	@Override
	public void stateChanged(ChangeEvent arg0) {
		revalidate();
	}
	
	
}

