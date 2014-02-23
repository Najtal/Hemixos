package gui_actionUpdater;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import com.Hemixos.Model;
import com.Hemixos.TableModel_Tracks;

import exceptions.UnselectedLibraryException;
import gui_generic_components.ListenerListeArtist;
import gui_generic_components.ListenerTableTrack;


/**
 * 
 * Classe qui gère les JList et les JTable de la GUI
 * 
 * @author Jean-Vital
 *
 */
public class ListUpdater {

	
	/**
	 * Met a jour et fait le lien entre la JListe de la GUI et le Model
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
		
	
}
