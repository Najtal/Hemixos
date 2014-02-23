package gui_generic_components;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;

import ucc.ActionElementToPlay;

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
		System.out.println("single click");
		if(e.getClickCount() == 2) {
			System.out.println("double click");

			ActionElementToPlay.AddOrPlayElement(model, jtTable);
		}
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
