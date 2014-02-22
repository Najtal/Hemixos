package gui_generic_components;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import com.Hemixos.Model;

public class ListenerVolumeMouse implements MouseWheelListener {

	private Model model;

	public ListenerVolumeMouse(Model model) {

		this.model = model;
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent mwe) {

		
		if (model.getMp().getVolume() > 100) {
			model.getMp().setVolume(100);
		} else {
			model.getMp().setVolume(model.getMp().getVolume() - mwe.getWheelRotation()*2);
		}
		
	}

}
