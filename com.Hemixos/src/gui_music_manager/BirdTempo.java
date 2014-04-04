package gui_music_manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import properties.AbstractImages;

import com.Hemixos.Model;

public class BirdTempo extends JPanel implements ChangeListener {
	
	private static Image logo;

	public BirdTempo() {
		this.setLayout(new BorderLayout());
		logo = AbstractImages.instance.GUI_SONG_JT_LOGO;
		Model.getInstance().getMw().addChangeListener(this);
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int panelHeight = this.getHeight();
		
		//Model.getInstance().getMc().jp

		if (panelHeight > 700) {
			//g.drawImage(logo, 0, panelHeight-512, 512, 512, null);
		}
		
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		repaint();
	}
	
}
