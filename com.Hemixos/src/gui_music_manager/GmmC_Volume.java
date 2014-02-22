package gui_music_manager;

import gui_generic_components.ListenerVolumeMouse;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;

import javax.swing.JPanel;

import properties.AbstractColors;
import properties.AbstractValues;

import com.Hemixos.Model;

public class GmmC_Volume extends JPanel {

	private static final long serialVersionUID = 1L;

	
	private Model model;

	
	/**
	 * Constructor
	 * @param model
	 */
	public GmmC_Volume(Model model) {
		this.model = model;
		
		//model.getMc().regJpVolume(this);
		
		this.setPreferredSize(new Dimension(AbstractValues.GUI_PL_HEIGHT-10, AbstractValues.GUI_PL_HEIGHT-10));
		this.setBackground(AbstractColors.GUI_PL_BACKGROUND);
		
		this.addMouseWheelListener(new ListenerVolumeMouse(model));	

	}

	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		// Dessine le cercle du dessous
		g.setColor(AbstractColors.GUI_PL_VOL_BACK);
		g.fillOval(0, 10, 50, 50);
		
		// Dessine le cercle actif
		g.setColor(AbstractColors.GUI_PL_VOL_FRONT);
		Graphics2D g2d = (Graphics2D) g.create();

        int width = 50;
        int height = 50;
        int radius = Math.min(width, height);

        int x = (width - radius) / 2;
        int y = (height - radius) / 2;
        int start = 90;
        int extent = Math.round((float) model.getMp().getVolume()/100 * - 360f);

        g2d.fill(new Arc2D.Float(x, y+10, radius, radius, start, extent, Arc2D.PIE));
        g2d.dispose();

		// Recouvre le centre
		g.setColor(AbstractColors.GUI_PL_BACKGROUND);
		g.fillOval(4, 14, 42, 42);

		// Ecrit le % au centre
		Font pct = new Font("Lucie Sans", Font.BOLD, 14);
		g.setFont(pct);
		g.setColor(AbstractColors.GUI_PL_VOL_TXT);
		if (model.getMp().getVolume() > 9 && model.getMp().getVolume() < 100) {
			g.drawString(model.getMp().getVolume()+"", 18, 40);
		} else if (model.getMp().getVolume() > 99) {
			g.drawString(model.getMp().getVolume()+"", 15, 40);
		} else {
			g.drawString(model.getMp().getVolume()+"", 22, 40);
		}
		

	}
	
	
}
