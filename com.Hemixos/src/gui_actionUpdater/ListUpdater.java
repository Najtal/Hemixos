package gui_actionUpdater;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import com.Hemixos.Model;
import com.Hemixos.TableModel_Tracks;

import exceptions.UnselectedLibraryException;
import gui_generic_components.ListenerListeAlbum;
import gui_generic_components.ListenerListeArtist;
import gui_generic_components.ListenerTableTrack;


/**
 * 
 * Classe qui gère les JList et les JTable de la GUI
 * 
 * @author Jean-Vital
 *
 */
public class ListUpdater implements ActionListener {

	
	
	private Model model;
	
	private JButton jbAllArtist;
	private JButton jbAllAlbum;


	/**
	 * Constructeur
	 * @param model
	 */
	public ListUpdater(Model model) {

		this.model = model;
	
		jbAllArtist = model.getMc().jbArtistsAll;
		jbAllAlbum = model.getMc().jbalbumAll;
		
		jbAllArtist.addActionListener(this);
		jbAllAlbum.addActionListener(this);
		
	}
	
	
	
	/**
	 * Met a jour et fait le lien entre la JListe des Artistes et le Model
	 * @param model
	 * @throws UnselectedLibraryException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void refreshArtistList(Model model) throws UnselectedLibraryException {
		JList jla = model.getMc().jlArtistes;
		jla.setListData(model.getMd().getArtistVector());
		jla.addListSelectionListener(new ListenerListeArtist(model, jla));
	}
	
	
	/**
	 * Met a jour et fait le lien entre la JListe des Albums et le Model
	 * @param model
	 * @throws UnselectedLibraryException
	 */
	public static void refreshAlbumList(Model model) throws UnselectedLibraryException {
		JList jla = model.getMc().jlAlbums;
		jla.setListData(model.getMd().getAlbumVector());
		jla.addListSelectionListener(new ListenerListeAlbum(model, jla));
	}
	
	
	/**
	 * Met a jour et fait le lien entre la JTable de la GUI et le model
	 * @param model
	 */
	public static void refreshTrackTable(Model model) {
		
		TableModel tdmListe = new TableModel_Tracks(model);
		JTable jtTable = model.getMc().jtTableTrack;
		
		jtTable.setModel(tdmListe);
		jtTable.removeColumn(jtTable.getColumnModel().getColumn(3));

		jtTable.addMouseListener(new ListenerTableTrack(model, jtTable));
		
		jtTable.setShowVerticalLines(true);
		jtTable.setShowHorizontalLines(false);
		jtTable.setUpdateSelectionOnSort(true);
		
	}



	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == jbAllArtist) {
			model.getMd().setSelectedArtist(-1);
		} else if (ae.getSource() == jbAllAlbum) {
			model.getMd().setSelectedAlbum(-1);
		}
		
	}
		
	
}
