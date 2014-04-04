package gui_actionUpdater;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import library.Album;

public class AlbumCellRenderer extends DefaultListCellRenderer {
	
	public Component getListCellRendererComponent(JList<?> list,
            Object value, int index, boolean isSelected, boolean cellHasFocus) {
		
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		
		if (value instanceof Album) {
			Album a = (Album)value;
		
		setText(a.getName());
		//setToolTipText(a.getDescription());
		// setIcon(ingredient.getIcon());
		}
		
		return this;
	}
}
