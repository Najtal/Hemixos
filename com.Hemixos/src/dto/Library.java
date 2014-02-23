package dto;

import gmusic.api.model.Playlists;
import gmusic.api.model.Song;
import gmusic.model.Tune;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Library implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private GregorianCalendar gcCreation;
	private GregorianCalendar gcLastUpdate;
	
	private String libraryName;
	private String userName;
	private String password;
	
	private int nbrTitres;
	private int nbrAlbums;
	private int nbrArtists;
	
	private Map<String, DTO_Artist> mapArtist; // Key = track.getArtist
	private Map<String, DTO_Album> mapAlbums; // key = track.getAlbumTitle
	private Map<String, Song> mapSongs; // Key = track.getId
	private Playlists playlists;
	
	private ArrayList<Song> alSong;
	private ArrayList<Tune> alTune;	


	public Library(String libraryName, String userName, String password) {
		this.libraryName = libraryName;
		this.userName = userName;
		this.password = password;
		
		this.nbrArtists = 0;
		this.nbrAlbums = 0;
		this.nbrTitres = 0;
		
		this.mapArtist = new HashMap<String, DTO_Artist>();
		this.mapAlbums = new HashMap<String, DTO_Album>();
		this.mapSongs = new HashMap<String, Song>();

		this.gcCreation = new GregorianCalendar();
		this.gcLastUpdate = gcCreation;
		
		this.alSong = new ArrayList<Song>();
		this.alTune = new ArrayList<Tune>();
	}
	
	
	/**
	 * Ajoute une Track a la librairie
	 * Ajoute l'artiste s'il n'existe pas
	 * Ajoute l'album s'il n'xiste pas
	 * Ajoute la piste
	 * @param track
	 */
	public void addSong(Song song) {
				
		alTune.add(song);
		alSong.add(song);			
		
		DTO_Artist dtoArtist = null;
		DTO_Album dtoAlbum = null;
					
		// On s'occupe de l'artiste
		String artName = song.getArtist();
		if (!mapArtist.containsKey(artName)) {
			// L'artiste n'existe pas
			dtoArtist= new DTO_Artist(artName);
			mapArtist.put(artName, dtoArtist);
			nbrArtists++;
		} else {
			dtoArtist = mapArtist.get(artName);
		}
		
		
		// On s'occupe de l'album
		String albName = song.getAlbum();
		
		// Si la piste connait son album
		if (albName.length() != 0) {

			if (!dtoArtist.getMapAlbum().containsKey(albName)) {
				// L'album n'existe pas encore
				dtoAlbum = new DTO_Album(albName, dtoArtist);
				mapAlbums.put(albName, dtoAlbum);
				nbrAlbums++;
				dtoArtist.addAlbum(dtoAlbum);
			} else {
				dtoAlbum = dtoArtist.getAlbum(albName);
			}
			
			
			
			// On s'occupe de la Track
			String trackId = song.getId();
			if (!dtoAlbum.getMapSongs().containsKey(trackId)) {
				// la piste n'existe pas encore dans la bib
				dtoAlbum.addSong(song);
				mapSongs.put(trackId, song);
				
				nbrTitres++;
			} else {
				dtoAlbum.addSong(song);
			}
			
			
		// Si la piste ne connait pas son album
		} else {
			dtoArtist.addSong(song);
			
			mapSongs.put(song.getId(), song);
			nbrTitres++;
		}

	}
	
	

	
	public void addSongs(Collection<Song> songs) {
		for (Song song : songs) {
			addSong(song);
		}
		
		 TreeMap<String, DTO_Artist> mapArtist = new TreeMap<String, DTO_Artist>(this.mapArtist);
	}
	
	public void addPlaylists(Playlists playlists) {
		this.playlists = playlists;
	}


	
	/*
	 * GETTERS and SETTERS
	 */
	
	public GregorianCalendar getGcLastUpdate() {
		return gcLastUpdate;
	}


	public void setGcLastUpdate(GregorianCalendar gcLastUpdate) {
		this.gcLastUpdate = gcLastUpdate;
	}


	public String getLibraryName() {
		return libraryName;
	}


	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public GregorianCalendar getGcCreation() {
		return gcCreation;
	}


	public int getNbrTitres() {
		return nbrTitres;
	}


	public int getNbrAlbums() {
		return nbrAlbums;
	}


	public int getNbrArtists() {
		return nbrArtists;
	}


	public Map<String, DTO_Artist> getMapArtist() {
		return mapArtist;
	}


	public Map<String, DTO_Album> getMapAlbums() {
		return mapAlbums;
	}


	public Map<String, Song> getMapSongs() {
		return mapSongs;
	}


	public Playlists getPlaylists() {
		return playlists;
	}

	public ArrayList<Song> getAlTrack() {
		return alSong;
	}

	
	
	
	
	
	
}
