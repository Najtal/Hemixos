package gui_music_manager;

import dto.Library;
import exceptions.UnselectedLibraryException;
import gmusic.api.skyjam.model.Track;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventObject;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;

import ucc.ActionElementToPlay;

import com.Hemixos.Model;

public class Gmm_VueListeTout extends JPanel implements MouseListener, ChangeListener {


	private static final long serialVersionUID = 1L;

	private Model model;

	
	private TableModel tdmListe;
	private JTable jtTable;
	
	
	/**
	 * Constructor
	 * @param model
	 */
	public Gmm_VueListeTout(Model model) {

		this.model = model;
		this.model.getMw().addChangeListener(this);
		
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);

		initTable();
		
	}


	private void initTable() {

		tdmListe = new Gmm_VueListeTDM(model);
		
		jtTable = new JTable(tdmListe);
		jtTable.removeColumn(jtTable.getColumnModel().getColumn(3));
		
		TableCellEditor tce = new TableCellEditor() {
			
			@Override
			public boolean stopCellEditing() {
				return true;
			}
			
			@Override
			public boolean shouldSelectCell(EventObject arg0) {
				return true;
			}
			
			@Override
			public void removeCellEditorListener(CellEditorListener arg0) {
				
			}
			
			@Override
			public boolean isCellEditable(EventObject arg0) {
				return false;
			}
			
			@Override
			public Object getCellEditorValue() {
				return null;
			}
			
			@Override
			public void cancelCellEditing() {
				
			}
			
			@Override
			public void addCellEditorListener(CellEditorListener arg0) {
				
			}
			
			@Override
			public Component getTableCellEditorComponent(JTable table, Object value,
					boolean isSelected, int row, int column) {
				return null;
			}
		};
		
		
		jtTable.setCellEditor(tce);
		
		// Style JTABLE
		jtTable.setShowVerticalLines(true);
		jtTable.setShowHorizontalLines(false);
		jtTable.setUpdateSelectionOnSort(true);
		jtTable.setBorder(null);
		jtTable.setBackground(Color.WHITE);
		
		jtTable.addMouseListener(this);
		
	    JScrollPane scrollPane = new JScrollPane(jtTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    scrollPane.setBorder(null);
	    scrollPane.setBackground(Color.WHITE);
	    this.add(scrollPane, BorderLayout.CENTER);
		
		
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {

		
		ActionElementToPlay.AddOrPlayElement(model, jtTable);
		
		/*int rc = jtTable.getSelectedRow();
		
		Vector<String> vv = (Vector<String>) model.getMd().getListePisteData().get(rc);
		String idt = vv.get(3);
				
		
		Library ltmp = null;
		try {
			ltmp = model.getMd().getLib();
		} catch (UnselectedLibraryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Track x = ltmp.getMapTracks().get(idt);
		
		model.getMp().play(x);*/
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
	}


	@Override
	public void stateChanged(ChangeEvent e) {
		
		this.removeAll();
		initTable();
		
		repaint();
		revalidate();
	}
	
}
