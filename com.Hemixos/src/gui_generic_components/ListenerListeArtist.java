package gui_generic_components;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.Hemixos.Model;

public class ListenerListeArtist implements ListSelectionListener {

	private Model model;
	private JList liste;

	/**
	 * Constructor
	 * @param model
	 */
	public ListenerListeArtist(Model model, JList liste) {
		this.model = model;
		this.liste = liste;
	}

	
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		model.getMw().setSelectedArtist(liste.getSelectedIndex());		
	}

	
	


}
