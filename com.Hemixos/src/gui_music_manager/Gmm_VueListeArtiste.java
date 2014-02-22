package gui_music_manager;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import properties.AbstractValues;

import com.Hemixos.Model;


/**
 * Cette classe représente un liste latérale d'artiste sous la forme d'un JPanel
 * @author Jean-Vital
 *
 */
public class Gmm_VueListeArtiste extends JPanel implements ChangeListener, ListSelectionListener {

	private static final long serialVersionUID = 1L;

	private Model model;
	private JList<String> liste;
	

	/**
	 * Constructeur de la liste
	 * @param model
	 */
	public Gmm_VueListeArtiste(Model model, int hh) {
		
		this.model = model;
		model.getMw().addChangeListener(this);
		
		this.setLayout(new BorderLayout());
				
		liste = new JList<>(model.getMd().getArtistVector());
		model.getMc().regListArtist(liste);
		
		liste.setSize(new Dimension(AbstractValues.GUI_VUE_ARTIST_WIDTH, hh));
		JScrollPane jsp = new JScrollPane(liste, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				
		this.add(jsp, BorderLayout.CENTER);
		
		liste.addListSelectionListener(this);
		
	}


	@Override
	public void stateChanged(ChangeEvent e) {
		repaint();
		revalidate();
	}


	@Override
	public void valueChanged(ListSelectionEvent lse) {
				
		model.getMw().setSelectedArtist(liste.getSelectedIndex());
		
	}

	
	
}
