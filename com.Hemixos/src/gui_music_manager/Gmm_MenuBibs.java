package gui_music_manager;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import properties.AbstractColors;

import com.Hemixos.Model;

import dto.Library;

public class Gmm_MenuBibs extends JPanel {


	private static final long serialVersionUID = 1L;

	private Model model;

	/**
	 * Constructor
	 * @param model
	 */
	public Gmm_MenuBibs(Model model) {

		this.model = model;
		
		this.setLayout(new GridLayout(0, 1, 0, 5));
		this.setBackground(AbstractColors.GUI_MN_BACKGROUND);
		
		this.setBorder(BorderFactory.createEmptyBorder(15, 0, 5, 0));
		
		
		for (Library lib : model.getMd().getLibs()) {
			
			JPanel newLib = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
			newLib.setBackground(AbstractColors.GUI_MN_BACKGROUND);
			newLib.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
			
			
			JButton jbLibName = new JButton(lib.getLibraryName());
			JLabel jlLibSource = new JLabel(lib.getUserName());
			
			Font newButtonFont = new Font("Tahoma", Font.PLAIN, 16);
			Font newJLabelFont = new Font("Tahoma", Font.PLAIN, 11);
			
			jbLibName.setFont(newButtonFont);
			jbLibName.setForeground(AbstractColors.GUI_MN_LIBS);
			
			jlLibSource.setFont(newJLabelFont);
			jlLibSource.setForeground(AbstractColors.GUI_MN_LIBS_SOURCE);
			
			jbLibName.setBackground(AbstractColors.GUI_MN_BACKGROUND);
			jbLibName.setBorderPainted(false);
			jbLibName.setBorder(null);
			jlLibSource.setBackground(AbstractColors.GUI_MN_BACKGROUND);		
			
			newLib.add(jbLibName);
			newLib.add(jlLibSource);
			
			this.add(newLib);
			
		}

	}

	
	
}
