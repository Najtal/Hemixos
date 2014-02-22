package gui_music_manager;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import properties.AbstractColors;
import properties.AbstractValues;
import util.StringTransform;

import com.Hemixos.Model;

public class Gmm_PlayerInfoLecture extends JPanel {

	
	private static final long serialVersionUID = 1L;
	
	
	private Model model;
	
	private int width;

	
	public Gmm_PlayerInfoLecture(Model model) {
		
		this.model = model;
		this.model.getMc().regJpInfo(this);
		
		this.setBackground(AbstractColors.GUI_PL_BACKGROUND);
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	}
	
	
	
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(AbstractColors.GUI_INFO_BORDER);
		g.drawRoundRect(20, 15, getInfoWidth(), this.getHeight()-30, 8, 8);

		
		int playerWidth = 15+this.getHeight()-35;
		
		
		g.setColor(AbstractColors.GUI_INFO_NOT_PLAYED);
		g.fillRect(20, playerWidth, getInfoWidth()+2, 6);
		
		
		
		/*
		 * length = 210000 (ms)
		 * played =  60000 (ms)
		 * 
		 */
		long length = 	model.getMp().getTrackLength(); 
		long pos = 		model.getMp().getTrackLengthPlayed();
		
		if (length < 1) {
			length = 1;
			pos = 0;
		}
		int playedWidth = (int) ((int) (getInfoWidth()*pos)/length);

		g.setColor(AbstractColors.GUI_INFO_PLAYED);
		g.fillRect(20, playerWidth, playedWidth, 6);

		
		if (model.getMp().getPlayingSong() != null) {
			String title = model.getMp().getPlayingSong().getTitle();
			String artist = model.getMp().getPlayingSong().getArtist();
			
			String name = artist + " - " + title;
			
			Font fTitle = new Font("Lucie Sans", Font.BOLD, 14);
			Font fTime = new Font("Lucie Sans", 0, 10);

			g.setFont(fTitle);
			g.setColor(AbstractColors.GUI_PL_INFO_TITLE);
			g.drawString(name, getInfoWidth()/2-name.length()*6/2, 34);
			
			if (model.getMp().isEnLecture()) {
				g.setFont(fTime);
				g.setColor(AbstractColors.GUI_PL_INFO_TIME);
				g.drawString(StringTransform.milliSecToString(model.getMp().getTrackLengthPlayed()), 30+model.getMw().getBorderTampon()/4, 45);
				g.drawString(StringTransform.milliSecToString(model.getMp().getTrackLength()), getInfoWidth()-model.getMw().getBorderTampon()/5-10, 45);
			}
			
		}
		
		
	}
	
	



	private int getInfoWidth() {
		return model.getMw().getFrameWidth() - 880 - model.getMw().getBorderTampon()*2;
	}
	

}
