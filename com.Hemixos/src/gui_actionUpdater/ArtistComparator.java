package gui_actionUpdater;

import java.text.Collator;
import java.util.Comparator;

import library.Artist;

import com.sun.jna.platform.win32.Netapi32Util.User;


public class ArtistComparator implements Comparator<Artist> {

    private Collator collator = Collator.getInstance(); 

    @Override
    public int compare(Artist o1, Artist o2) {
        int compare = compareString(o1.getArtistName(), o2.getArtistName());
        
        if (compare == 0) {
            return compareString(o1.getArtistName(), o2.getArtistName());
        }
        
        return compare;
    }

    private int compareString(String o1, String o2) {
        return collator.compare(o1, o2);
    }

}
