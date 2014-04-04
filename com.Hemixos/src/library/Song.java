package library;

import java.io.Serializable;

/**
 * 
 * This class is the DTO of a song used to organise the library
 * 
 * @author Jean-Vital
 *
 */
public class Song implements Serializable {
	
	// Song properties
	protected String title;
	
	protected Artist artist;
	protected Album album;
	
	protected String genre;
	protected int year;
	protected String rating;
	private String url;
	
	protected int beatsPerMinute;
	protected long durationMillis;
	
	protected String id;
	protected boolean deleted;
	protected int playCount;
	
	
	// Song source
	private gmusic.api.model.Song sourceSong;
	
	
	
	/*
	 * Constructor
	 */
	
	private Song() {}
	
	/**
	 * Main constructor of a song
	 * @param title The title of the song
	 * @param artist The Artist of the song
	 * @param album The Album of the song
	 * @param genre
	 * @param year
	 * @param rating
	 * @param beatsPerMinute
	 * @param durationMillis
	 * @param id
	 */
	protected Song(Artist artist, Album album, gmusic.api.model.Song ss) {
		super();
		this.sourceSong = ss;
		this.title = ss.getName();
		this.artist = artist;
		this.album = album;
		this.genre = ss.getGenre();
		this.year = ss.getYear();
		this.rating = ss.getRating();
		this.beatsPerMinute = ss.getBeatsPerMinute();
		this.durationMillis = ss.getDurationMillis();
		this.id = ss.getId();
		
		if (album != null) {
			this.album.addSong(this);
		}
	}
	
	
	/*
	 * Getters and Setters
	 */	
	
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the sourceSong
	 */
	public gmusic.api.model.Song getSourceSong() {
		return sourceSong;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the artist
	 */
	public Artist getArtist() {
		return (artist != null) ? artist : null;
	}
	/**
	 * @param artist the artist to set
	 */
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	/**
	 * @return the album
	 */
	public Album getAlbum() {
		return album;
	}
	/**
	 * @param album the album to set
	 */
	public void setAlbum(Album album) {
		this.album = album;
	}
	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}
	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the beatsPerMinute
	 */
	public int getBeatsPerMinute() {
		return beatsPerMinute;
	}
	/**
	 * @param beatsPerMinute the beatsPerMinute to set
	 */
	public void setBeatsPerMinute(int beatsPerMinute) {
		this.beatsPerMinute = beatsPerMinute;
	}
	/**
	 * @return the durationMillis
	 */
	public long getDurationMillis() {
		return durationMillis;
	}
	/**
	 * @param durationMillis the durationMillis to set
	 */
	public void setDurationMillis(long durationMillis) {
		this.durationMillis = durationMillis;
	}
	/**
	 * @return the deleted
	 */
	public boolean isDeleted() {
		return deleted;
	}
	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	/**
	 * @return the playCount
	 */
	public int getPlayCount() {
		return playCount;
	}
	/**
	 * @param playCount the playCount to set
	 */
	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	
	
	

	
	
}
