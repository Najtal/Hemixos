package com.Hemixos;

import javax.swing.table.DefaultTableModel;


/**
 * 
 * Model de la JTable qui contient toute les pistes
 * 
 * @author Jean-Vital
 *
 */
public class TableModel_Tracks extends DefaultTableModel {
	
	private static final long serialVersionUID = 1L;
	private Model model;

	
	/**
	 * Constructor
	 * @param model
	 */
	public TableModel_Tracks(Model model) {
        
		super(model.getMd().getListePisteData(), model.getMd().getListePisteCN());

		this.model = model;

	}
	
	
    @Override
    public boolean isCellEditable(int row, int column) {
       //all cells false
       return false;
    }


}
