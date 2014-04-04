package gui_actionUpdater;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.SortOrder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import org.jdesktop.swingx.JXList;

import properties.AbstractColors;

import com.Hemixos.Model;
import com.Hemixos.TableModel_Tracks;

import exceptions.UnselectedLibraryException;
import gui_generic_components.ListenerListeAlbum;
import gui_generic_components.ListenerListeArtist;
import gui_generic_components.ListenerTableColumn;
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
	
	private static boolean isTrackTableMouseListenerAdded = false;


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
	 * Met a jour et fait le lien entre la JListe des ARTISTES et le Model
	 * @param model
	 * @throws UnselectedLibraryException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void refreshArtistList(Model model) throws UnselectedLibraryException {
		JXList jla = model.getMc().jlArtistes;
				
		jla.setListData(model.getMd().getArtistVector());
		jla.setCellRenderer(new ArtistListCellRenderer());
		
		jla.addListSelectionListener(new ListenerListeArtist(model, jla));
	}
	
	
	/**
	 * Met a jour et fait le lien entre la JListe des ALBUMS et le Model
	 * @param model
	 * @throws UnselectedLibraryException
	 */
	public static void refreshAlbumList(Model model) throws UnselectedLibraryException {
		JList jla = model.getMc().jlAlbums;
		jla.setListData(model.getMd().getAlbumVector());
		jla.setCellRenderer(new AlbumCellRenderer());
		jla.addListSelectionListener(new ListenerListeAlbum(model, jla));
	}
	
	
	/**
	 * Met a jour et fait le lien entre la JTable de la GUI et le model
	 * @param model
	 */
	public static void refreshTrackTable(Model model) {
		
		TableModel tdmListe = new SongTableModel(model);//TableModel_Tracks(model);
		JTable jtTable = model.getMc().jtTableTrack;
		
		//JTable jtTable = new SongTableRenderer();
		
		jtTable.setModel(tdmListe);
		
		
		// TODO Les listener sur les colonnes ne fonctionnent pas
		//jtTable.getColumnModel().addColumnModelListener(new ListenerTableColumn());
		jtTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jtTable.getColumnModel().getColumn(0).setPreferredWidth(250);
		jtTable.getColumnModel().getColumn(1).setPreferredWidth(250);
		jtTable.getColumnModel().getColumn(2).setPreferredWidth(250);
		jtTable.getColumnModel().getColumn(3).setPreferredWidth(250);
		//jtTable.removeColumn(jtTable.getColumnModel().getColumn(3));
		
		// Listener
		if (!isTrackTableMouseListenerAdded) {
			jtTable.addMouseListener(new ListenerTableTrack(model, jtTable));
			isTrackTableMouseListenerAdded = true;
		}
				
		
		// Style
		//jtTable.setBackground(Color.WHITE);
		jtTable.setShowVerticalLines(false);
		jtTable.setShowHorizontalLines(false);
		jtTable.setUpdateSelectionOnSort(true);
		//jtTable.setOpaque(true);
		
		
		JTableHeader header = jtTable.getTableHeader();
		header.setBackground(AbstractColors.GUI_LISTE_TRACK_HEADER_BACKGROUND);
		header.getColumnModel().setColumnSelectionAllowed(false);

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
