package gui_generic_components;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyEvent;

import com.Hemixos.Model;

public class ListenerFrameResize implements ComponentListener {

	private Model model;

	public ListenerFrameResize(Model model) {
		this.model = model;
	}

	@Override
	public void componentHidden(ComponentEvent e) {
	}

	@Override
	public void componentMoved(ComponentEvent e) {
	}

	@Override
	public void componentResized(ComponentEvent e) {
		model.getMw().actionResize();		
	}

	@Override
	public void componentShown(ComponentEvent e) {
	}
	

}



