package gui_actionUpdater;

import java.util.Comparator;

import library.Song;

public class SongTableSorter implements Comparator<Song> {
	
	int colIndex;
	
	  SongTableSorter(int colIndex) {
	    this.colIndex = colIndex;
	  }
	
	  public int compare(Song a, Song b) {
		  
	    Object o1 = a.getTitle();
	    Object o2 = b.getTitle();
	
	    if (o1 instanceof String && ((String) o1).length() == 0) {
	      o1 = null;
	    }
	    if (o2 instanceof String && ((String) o2).length() == 0) {
	      o2 = null;
	    }
	
	    if (o1 == null && o2 == null) {
	      return 0;
	    } else if (o1 == null) {
	      return 1;
	    } else if (o2 == null) {
	      return -1;
	    } else if (o1 instanceof Comparable) {
	
	      return ((Comparable) o1).compareTo(o2);
	    } else {
	
	      return o1.toString().compareTo(o2.toString());
	    }
	  }

	
}
