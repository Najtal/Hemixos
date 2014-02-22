package gui_generic_components;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import com.Hemixos.Model;

public class ListenerFrameMove implements MouseMotionListener {

	
	private Model model;

	public ListenerFrameMove(Model model) {
		this.model = model;
	}
	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		//model.getMw().getFrame().setLocation(new Point(e.getX(), e.getY()));
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}
