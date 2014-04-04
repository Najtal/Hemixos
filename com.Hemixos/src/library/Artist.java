package library;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * This class refers to the DTO of an artist. It is used in the library 
 * to organise the songs
 * 
 * @author Jean-Vital
 *
 */
public class Artist implements Serializable {

	// Artist properties
	private String artistName;
	private int nbrAlbums;
	private int nbrTitles;
	
	// Architecture properties
	private Map<String, Album> mapAlbum; // Album.getName - Album
	private Map<String, Song> mapSong; // Chansons orphelines : Song.getId - Song
	private Map<String, Song> mapAllSong; // Toutes les chancons de l'artist : Song.getId - Song


	
	
	/*
	 * Constructors
	 */
	
	private Artist() {};
	
	/**
	 * The main constructor of an Artist
	 * @param artistName The name of the artist
	 */
	protected Artist(String artistName) {
		super();
		this.artistName = artistName;
		this.nbrAlbums = 0;
		this.nbrTitles = 0;
		this.mapAlbum = new HashMap<String, Album>();
		this.mapSong = new HashMap<String, Song>();
		this.mapAllSong = new HashMap<String, Song>();

	}	
	
	
	/*
	 * Methodes fonctionnelles
	 */
	protected void addAlbum(Album album) {
		mapAlbum.put(album.getName(), album);
		nbrAlbums++;
	}
	
	
	protected void addSingleSong(Song song) {
		mapSong.put(song.getId(), song);	
		mapAllSong.put(song.id, song);
		nbrTitles++;
	}
	
	protected void addSong(Song song) {
		mapAllSong.put(song.id, song);
		nbrTitles++;
	}
	

	
	protected Album getAlbum(String albumName) {
		if (mapAlbum.containsKey(albumName)) {
			return mapAlbum.get(albumName);
		}
		return null;
	}
	
	/*
	 * Getters and Setters
	 */
	
	/**
	 * @return the artistName
	 */
	public String getArtistName() {
		return (artistName != null) ? artistName : "-";
	}

	/**
	 * @param artistName the artistName to set
	 */
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	/**
	 * @return the mapAllSong
	 */
	public Map<String, Song> getMapAllSong() {
		return mapAllSong;
	}

	/**
	 * @return the nbrAlbums
	 */
	public int getNbrAlbums() {
		return nbrAlbums;
	}

	/**
	 * @param nbrAlbums the nbrAlbums to set
	 */
	public void setNbrAlbums(int nbrAlbums) {
		this.nbrAlbums = nbrAlbums;
	}

	/**
	 * @return the nbrTitles
	 */
	public int getNbrTitles() {
		return nbrTitles;
	}

	/**
	 * @param nbrTitles the nbrTitles to set
	 */
	public void setNbrTitles(int nbrTitles) {
		this.nbrTitles = nbrTitles;
	}

	/**
	 * @return the mapAlbum
	 */
	public Map<String, Album> getMapAlbum() {
		return mapAlbum;
	}

	/**
	 * @param mapAlbum the mapAlbum to set
	 */
	public void setMapAlbum(Map<String, Album> mapAlbum) {
		this.mapAlbum = mapAlbum;
	}

	/**
	 * @return the mapSong
	 */
	public Map<String, Song> getMapSong() {
		return mapSong;
	}

	/**
	 * @param mapSong the mapSong to set
	 */
	public void setMapSong(Map<String, Song> mapSong) {
		this.mapSong = mapSong;
	}
	

	
	
}
