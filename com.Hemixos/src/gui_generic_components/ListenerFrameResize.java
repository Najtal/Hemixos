package gui_generic_components;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

import com.Hemixos.Model;

public class ListenerFrameResize implements ComponentListener, WindowListener, WindowFocusListener, WindowStateListener {

	private Model model;

	/**
	 * Constructor
	 * @param model
	 */
	public ListenerFrameResize(Model model) {
		this.model = model;
	}

	
	/*
	 * ComponentListener
	 */
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


	/*
	 * WindowListener
	 */
	@Override
	public void windowActivated(WindowEvent arg0) {
		model.getMw().actionResize();
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
	}
	
	
	/*
	 * WindowFocusListener
	 */
	@Override
	public void windowGainedFocus(WindowEvent e) {
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
	}


	/*
	 * WindowStateListener
	 */
	@Override
	public void windowStateChanged(WindowEvent arg0) {
		model.getMw().actionResize();
	}

}



