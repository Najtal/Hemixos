package gui_actionUpdater;

import exceptions.UnselectedLibraryException;
import gmusic.api.skyjam.model.AlbumArtRef;

import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.text.html.HTMLDocument.Iterator;

import library.Album;
import library.Song;
import properties.AbstractImages;
import util.StringTransform;

import com.Hemixos.Model;


/**
 * 
 * Cette classe met a jour les informations de la barre de liste de lecture en cours
 * 
 * @author Jean-Vital
 *
 */
public class InfoPisteLectureUpdater implements Runnable {

	
	private static Model model;
	private static InfoPisteLectureUpdater instance;
	Thread runner;
	
	private static JButton iAlbumCover;
	private static JLabel jlTitre;
	private static JLabel jlArtist;
	private static JLabel jlAlbum;
	private static JLabel jlDuree;
	
	
	public InfoPisteLectureUpdater(Model model) {
		
		this.model = model;
	
		jlTitre = model.getMc().jlTitleValue;
		jlArtist = model.getMc().jlArtistValue;
		jlAlbum = model.getMc().jlAlbumValue;
		jlDuree = model.getMc().jlDureeValue;
		iAlbumCover = model.getMc().jbPisteImage;
		
		instance = this;
	}
	
	
	
	/**
	 * Met a jour les infos
	 */
	public void updateInfoPiste() {
		
		runner = new Thread(this);
		runner.start();
		
	}
	
	
	
	/**
	 * Met a jour les infos et la cover (ou� ou� ;)
	 */
	public void run() {

		Song s = model.getMp().getPlayingSong();
		
		jlArtist.setText(s.getArtist().getArtistName());
		jlAlbum.setText((s.getAlbum() != null) ? s.getAlbum().getName() : "");
		jlTitre.setText(s.getTitle());
		jlDuree.setText(StringTransform.milliSecToString(s.getDurationMillis()));
		
		String uriCover = null;
		Image image = null;

		if (s.getAlbum() != null) {

			Album album = null;
			try {
				album = model.getMd().getLib().getMapAlbums().get(s.getAlbum());
				
				
				java.util.Iterator<String> itat = album.getMapSongs().keySet().iterator();
				while (itat.hasNext()) {
					
					if (album.getMapSongs().get(itat.next()).getAlbum().getAlbumArtUrl() != null) {
						uriCover = album.getMapSongs().get(itat.next()).getAlbum().getAlbumArtUrl().toString();
						break;
					}	
				}
				
				if (uriCover == null) {
					iAlbumCover.setIcon(AbstractImages.instance.ICON_COIN_GAUCHE);
				} else {
					image = ImageIO.read(new URL(uriCover));
					model.getMp().setPlayingTrackCover(image);
					
					image = image.getScaledInstance(70,	70,	java.awt.Image.SCALE_SMOOTH);
					
					iAlbumCover.setIcon(new ImageIcon(image));
				}

			} catch (Exception e1) {
				iAlbumCover.setIcon(AbstractImages.instance.ICON_COIN_GAUCHE);
			}
		}
		
	}



	public static InfoPisteLectureUpdater getInstance() {
		return instance;
	}
	
	
}
