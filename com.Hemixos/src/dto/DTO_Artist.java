package dto;

import gmusic.api.model.Song;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DTO_Artist implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String artistName;
	private Map<String, DTO_Album> mapAlbum;
	private Map<String, Song> mapSong;

	
	protected DTO_Artist(String name) {
		this.artistName = name;
		this.mapAlbum = new HashMap<String, DTO_Album>();
		this.mapSong = new HashMap<String, Song>();
	}


	protected void addAlbum(DTO_Album album) {
		if (!mapAlbum.containsKey(album.getAlbumName()))
			mapAlbum.put(album.getAlbumName(), album);
	}
		
	protected void addSong(Song song) {
		mapSong.put(song.getId(), song);
	}
	
	protected Song getSong(String trackName) {
		if (mapSong.containsKey(trackName)) {
			return mapSong.get(trackName);
		}
		return null;
	}
	
	protected DTO_Album getAlbum(String albumName) {
		if (mapAlbum.containsKey(albumName)) {
			return mapAlbum.get(albumName);
		}
		return null;
	}
	
	
	public String getArtistName() {
		return artistName;
	}


	protected void setArtistName(String artistName) {
		this.artistName = artistName;
	}


	protected Map<String, DTO_Album> getMapAlbum() {
		return mapAlbum;
	}
	
	
	
	
}



