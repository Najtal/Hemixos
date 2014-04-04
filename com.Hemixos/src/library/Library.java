package library;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import com.Hemixos.Model;

import exceptions.UndefineGoogleManagerAPI;

public class Library implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private GregorianCalendar gcCreation;
	private GregorianCalendar gcLastUpdate;
	
	// Login/User info
	private String libraryName;
	private String userName;
	private String password;	
	
	// Architecture data
	private int nbrTitres;
	private int nbrAlbums;
	private int nbrArtists;
	
	private Map<String, Artist> mapArtist; // Artist.getName - Artist
	private Map<String, Album> mapAlbums; // Album.getName - Album
	private Map<String, Song> mapSongs; // Song.getId - Song
	//private Playlists playlists;
	
	private ArrayList<Song> alSong; // All the songs
	
	
	/*
	 * Constructor
	 */
	@SuppressWarnings("unused")
	private Library() {}
	
	/**
	 * Main constructor
	 * @param libraryName The name of the library
	 * @param userName The name of the User
	 * @param password The name of the password
	 */
	public Library(String libraryName, String userName, String password) {
		
		this.libraryName = libraryName;
		this.userName = userName;
		this.password = password;
		
		this.nbrArtists = 0;
		this.nbrAlbums = 0;
		this.nbrTitres = 0;
		
		this.mapArtist = new HashMap<String, Artist>();
		this.mapAlbums = new HashMap<String, Album>();
		this.mapSongs = new HashMap<String, Song>();

		this.gcCreation = new GregorianCalendar();
		this.gcLastUpdate = gcCreation;
		
		this.alSong = new ArrayList<Song>();
	}

	

	/*
	 * Functionnal methods
	 */
	public void addSong(gmusic.api.model.Song song) {
		
		Artist artist = null;
		Album album = null;
		Song nSong = null;
		
		// On récupère les infos nécessaire a la structure
		@SuppressWarnings("unused")
		String s_title = song.getName();
		String s_artist = song.getAlbumArtist();
		String s_album = song.getAlbum();
		String i_songId = song.getId();		
			
		if (s_artist.startsWith("//") || s_album.startsWith("//")){
			return;
		}
		
		/*
		 *  L'artiste
		 */
		// On crée un artist s'il n'existe pas déjà
		if (!mapArtist.containsKey(s_artist)) {
			artist = new Artist(s_artist);
			mapArtist.put(s_artist, artist);
			nbrArtists++;
		} else {
			// Sinon on le retrouve simplement
			artist = mapArtist.get(s_artist);
		}
		

		// Si la piste connait son album
		if (s_album.length() != 0) {
			
			/*
			 * L'album
			 */
			// Si l'album existe déjà dans l'artist
			if (artist.getMapAlbum().containsKey(s_album)) {
				album = artist.getAlbum(s_album);	
			} else {
				album = new Album(artist, song.isSubjectToCuration(), s_album, song.getAlbumArtUrl(), song.getTotalDiscs(), song.getCreationDate(), song.getMetajamId(), song.getType(), song.getDisc());
				mapAlbums.put(s_album, album);
				nbrAlbums++;
			}
			
			
			/*
			 * La song
			 */
			// On crée la nouvelle song
			nSong = new Song(artist, album, song);
			alSong.add(nSong);			
			mapSongs.put(i_songId, nSong);
			nbrTitres++;
			
			
			
		// Si la piste ne connait pas son album, 
		// On l'ajoute a l'artist
		} else {
			// On crée la nouvelle song
			nSong = new Song(artist, album, song);
			alSong.add(nSong);
			artist.addSingleSong(nSong);
			mapSongs.put(nSong.getId(), nSong);
			nbrTitres++;
		}
		
	}
	
	
	
	public int addSongCollection(Collection<gmusic.api.model.Song> songs) throws Exception {
		
		int nbrSongsAdded = 0;
		if (songs == null) {
			throw new Exception("The song Collection is null !");
		}
		
		java.util.Iterator<gmusic.api.model.Song> its = songs.iterator();
		while (its.hasNext()) {
			addSong(its.next());
			nbrSongsAdded++;
		}
		
		 return nbrSongsAdded;
	}
	
	
	
	/*
	 * Getters and Setters
	 */
	
	/**
	 * @return the gcCreation
	 */
	public GregorianCalendar getGcCreation() {
		return gcCreation;
	}

	/**
	 * @param gcCreation the gcCreation to set
	 */
	public void setGcCreation(GregorianCalendar gcCreation) {
		this.gcCreation = gcCreation;
	}

	/**
	 * @return the gcLastUpdate
	 */
	public GregorianCalendar getGcLastUpdate() {
		return gcLastUpdate;
	}

	/**
	 * @param gcLastUpdate the gcLastUpdate to set
	 */
	public void setGcLastUpdate(GregorianCalendar gcLastUpdate) {
		this.gcLastUpdate = gcLastUpdate;
	}

	/**
	 * @return the libraryName
	 */
	public String getLibraryName() {
		return libraryName;
	}

	/**
	 * @param libraryName the libraryName to set
	 */
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the nbrTitres
	 */
	public int getNbrTitres() {
		return nbrTitres;
	}

	/**
	 * @return the nbrAlbums
	 */
	public int getNbrAlbums() {
		return nbrAlbums;
	}

	/**
	 * @return the nbrArtists
	 */
	public int getNbrArtists() {
		return nbrArtists;
	}

	/**
	 * @return the mapArtist
	 */
	public Map<String, Artist> getMapArtist() {
		return mapArtist;
	}

	/**
	 * @return the mapAlbums
	 */
	public Map<String, Album> getMapAlbums() {
		return mapAlbums;
	}

	/**
	 * @return the mapSongs
	 */
	public Map<String, Song> getMapSongs() {
		return mapSongs;
	}

	/**
	 * @return the alSong
	 */
	public ArrayList<Song> getAlSong() {
		return alSong;
	}
	
	

	
	
	
	
}
