package dto;

import gmusic.api.model.Song;
import gmusic.api.skyjam.model.AlbumArtRef;
import gmusic.api.skyjam.model.Track;

import java.io.Serializable;
import java.util.HashMap;

public class DTO_Album implements Serializable {

	private String albumName;
	private DTO_Artist artist;
	
	private HashMap<String, Song> mapSongs;
	
	private AlbumArtRef cover;

	
	protected DTO_Album(String name, DTO_Artist artist) {
		this.albumName = name;
		this.artist = artist;
		this.mapSongs = new HashMap<String, Song>(); // String = track.getId();
		this.cover = null;
	}


	protected void addSong(Song song) {
		if (!mapSongs.containsKey(song.getId()))
			mapSongs.put(song.getId(), song);
		
		/*if (cover == null && track.getAlbumArtRef().iterator().hasNext()) {
				cover = track.getAlbumArtRef().iterator().next();
		}*/
	}
	
	protected Song getTrack(String trackName) {
		if (mapSongs.containsKey(trackName)) {
			return mapSongs.get(trackName);
		}
		return null;
	}


	protected AlbumArtRef getCover() {
		return cover;
	}

	protected void setCover(AlbumArtRef cover) {
		this.cover = cover;
	}


	public String getAlbumName() {
		return albumName;
	}


	protected void setAlbumName(String albumName) {
		this.albumName = albumName;
	}


	public DTO_Artist getArtist() {
		return artist;
	}


	protected void setArtist(DTO_Artist artist) {
		this.artist = artist;
	}


	protected HashMap<String, Song> getMapSongs() {
		return mapSongs;
	}

}


