package library;

import java.io.Serializable;
import java.util.HashMap;

public class Album implements Serializable {

	// Album Properties

	private String name;
	protected String composer;

	private Artist artist;
	
	private int totalDiscs;
	private int totalTracks;
	private boolean subjectToCuration;
	private int track;
	private float creationDate;
	private double lastPlayed;
	private String metajamId;
	private String albumArtUrl;
	private int type;
	private int disc;

	private HashMap<String, Song> mapSongs; // Song.getId - Song

	
	/*
	 * Constructors
	 */
	
	private Album() {}
	
	/**
	 * The main constructor of an Album
	 * @param subjectToCuration
	 * @param name
	 * @param albumArtUrl
	 * @param totalDiscs
	 * @param creationDate
	 * @param metajamId
	 * @param type
	 * @param disc
	 */
	protected Album(Artist artist, boolean subjectToCuration, String name, String albumArtUrl,
			int totalDiscs, float creationDate, String metajamId, int type, int disc) {
		super();
		this.artist = artist;
		this.totalTracks = 0;
		this.subjectToCuration = subjectToCuration;
		this.name = name;
		this.albumArtUrl = albumArtUrl;
		this.totalDiscs = totalDiscs;
		this.track = 0;
		this.creationDate = creationDate;
		this.lastPlayed = 0;
		this.metajamId = metajamId;
		this.type = type;
		this.disc = disc;
		this.mapSongs = new HashMap<String, Song>();
		
		this.artist.addAlbum(this);

		
	}
	
	/*
	 * Functionnal methods
	 */
	
	protected void addSong(Song song) {
		if (mapSongs.containsKey(song.getId())) {
			return; 
		}
		
		mapSongs.put(song.getId(), song);
		song.setAlbum(this);
		totalTracks++;
		
		artist.addSong(song);
	}
	
	
	
	
	/*
	 * Getters and Setters
	 */
	
	/**
	 * @return the totalTracks
	 */
	public int getTotalTracks() {
		return totalTracks;
	}

	/**
	 * @return the composer
	 */
	public String getComposer() {
		return composer;
	}

	/**
	 * @param composer the composer to set
	 */
	public void setComposer(String composer) {
		this.composer = composer;
	}

	/**
	 * @return the artist
	 */
	public Artist getArtist() {
		return artist;
	}

	/**
	 * @param artist the artist to set
	 */
	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	/**
	 * @param totalTracks the totalTracks to set
	 */
	public void setTotalTracks(int totalTracks) {
		this.totalTracks = totalTracks;
	}
	/**
	 * @return the subjectToCuration
	 */
	public boolean isSubjectToCuration() {
		return subjectToCuration;
	}
	/**
	 * @param subjectToCuration the subjectToCuration to set
	 */
	public void setSubjectToCuration(boolean subjectToCuration) {
		this.subjectToCuration = subjectToCuration;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return (name != null) ? name : "-";
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the totalDiscs
	 */
	public int getTotalDiscs() {
		return totalDiscs;
	}
	/**
	 * @param totalDiscs the totalDiscs to set
	 */
	public void setTotalDiscs(int totalDiscs) {
		this.totalDiscs = totalDiscs;
	}
	/**
	 * @return the track
	 */
	public int getTrack() {
		return track;
	}
	/**
	 * @param track the track to set
	 */
	public void setTrack(int track) {
		this.track = track;
	}
	/**
	 * @return the albumArtUrl
	 */
	public String getAlbumArtUrl() {
		return albumArtUrl;
	}
	/**
	 * @param albumArtUrl the albumArtUrl to set
	 */
	public void setAlbumArtUrl(String albumArtUrl) {
		this.albumArtUrl = albumArtUrl;
	}
	/**
	 * @return the creationDate
	 */
	public float getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(float creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the lastPlayed
	 */
	public double getLastPlayed() {
		return lastPlayed;
	}
	/**
	 * @param lastPlayed the lastPlayed to set
	 */
	public void setLastPlayed(double lastPlayed) {
		this.lastPlayed = lastPlayed;
	}
	/**
	 * @return the metajamId
	 */
	public String getMetajamId() {
		return metajamId;
	}
	/**
	 * @param metajamId the metajamId to set
	 */
	public void setMetajamId(String metajamId) {
		this.metajamId = metajamId;
	}
	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}
	/**
	 * @return the disc
	 */
	public int getDisc() {
		return disc;
	}
	/**
	 * @param disc the disc to set
	 */
	public void setDisc(int disc) {
		this.disc = disc;
	}

	/**
	 * @return the mapSongs
	 */
	public HashMap<String, Song> getMapSongs() {
		return mapSongs;
	}
	
	
}
