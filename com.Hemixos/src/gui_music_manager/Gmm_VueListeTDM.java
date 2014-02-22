package gui_music_manager;

import javax.swing.table.DefaultTableModel;

import com.Hemixos.Model;

public class Gmm_VueListeTDM extends DefaultTableModel {
	
	private static final long serialVersionUID = 1L;
	private Model model;

	public Gmm_VueListeTDM(Model model) {
        
		super(model.getMd().getListePisteData(), model.getMd().getListePisteCN());

		this.model = model;

	}

	 
	
}
