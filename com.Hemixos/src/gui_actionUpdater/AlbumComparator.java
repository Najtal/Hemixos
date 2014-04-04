package gui_actionUpdater;

import java.text.Collator;
import java.util.Comparator;

import library.Album;
import library.Artist;

import com.sun.jna.platform.win32.Netapi32Util.User;


public class AlbumComparator implements Comparator<Album> {

    private Collator collator = Collator.getInstance(); 

    @Override
    public int compare(Album o1, Album o2) {
    	
        int compare = compareString(o1.getName(), o2.getName());
        
        if (compare == 0) {
            return compareString(o1.getName(), o2.getName());
        }
        
        return compare;
    }

    private int compareString(String o1, String o2) {
        return collator.compare(o1, o2);
    }



}
