package gui_actionUpdater;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import library.Artist;

public class ArtistListCellRenderer extends DefaultListCellRenderer {

	public Component getListCellRendererComponent(JList<?> list,
            Object value, int index, boolean isSelected, boolean cellHasFocus) {
		
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		
		if (value instanceof Artist) {
			Artist a = (Artist)value;
		
		setText(a.getArtistName());
		//setToolTipText(a.getDescription());
		// setIcon(ingredient.getIcon());
		}
		
		return this;
	}
	
}
