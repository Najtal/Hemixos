package gui_generic_components;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.GregorianCalendar;

import javax.swing.JTable;

import ucc.ActionElementToPlay;
import util.TimeUtil;

import com.Hemixos.Model;


/**
 * 
 * Cette classe gère les interractions avec la JTable de tracks de la GUI
 * 
 * @author Jean-Vital
 *
 */
public class ListenerTableTrack implements MouseListener {

	
	private Model model;
	private JTable jtTable;

	private static int lastSelectedTrack = -1;
	private static long lastSelectedTrackTime = new GregorianCalendar().getTimeInMillis();
	
	
	/**
	 * Constructor
	 * @param model
	 * @param jtTable
	 */
	public ListenerTableTrack(Model model, JTable jtTable) {

		this.model = model;
		this.jtTable = jtTable;
	}

	
	
	/*
	 * MouseListener
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if ((e.getClickCount() == 2)
				&& (e.getWhen() - lastSelectedTrackTime > 1000
				|| lastSelectedTrack == jtTable.getSelectedRow())) {

			lastSelectedTrackTime = e.getWhen();
			lastSelectedTrack = jtTable.getSelectedRow();
			
			ActionElementToPlay.AddOrPlayElement(model, jtTable);

		}
		
		//model.getMc().jpTrackContainer.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

}
