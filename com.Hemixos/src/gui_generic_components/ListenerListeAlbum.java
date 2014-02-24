package gui_generic_components;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.Hemixos.Model;

public class ListenerListeAlbum implements ListSelectionListener {

	private Model model;
	private JList liste;

	/**
	 * Constructor
	 * @param model
	 */
	public ListenerListeAlbum(Model model, JList liste) {
		this.model = model;
		this.liste = liste;
	}

	
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		model.getMw().setSelectedAlbum(liste.getSelectedIndex());		
	}

}

