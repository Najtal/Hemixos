package gui_actionUpdater;

import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class SongTableRenderer extends JTable implements TableCellRenderer {

	
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		
		return null;
	}
	
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row,
			int column) {

		Component c = super.prepareRenderer(renderer, row, column);
		// We want renderer component to be transparent
		// so background image is visible
		if (c instanceof JComponent)
			((JComponent) c).setOpaque(false);
		return c;
		
		//return super.prepareRenderer(renderer, row, column);
	}

}
