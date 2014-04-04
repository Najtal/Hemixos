package gui_generic_components;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;

public class ListenerTableColumn implements TableColumnModelListener {

	@Override
	public void columnAdded(TableColumnModelEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void columnMarginChanged(ChangeEvent e) {
		System.out.println("column margin changed");
	}

	@Override
	public void columnMoved(TableColumnModelEvent e) {
		System.out.println("column moved");
	}

	@Override
	public void columnRemoved(TableColumnModelEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void columnSelectionChanged(ListSelectionEvent e) {
		System.out.println("column selection changed");
	}

}
