package vlcEngine;

import java.util.List;

import javax.swing.SwingUtilities;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.binding.internal.libvlc_media_t;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventListener;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.headless.HeadlessMediaPlayer;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import com.Hemixos.Model;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

public class PlayerManager implements MediaPlayerEventListener {

        private MediaPlayerFactory mpf;
		private HeadlessMediaPlayer hmp;
		private EmbeddedMediaPlayer mediaPlayer;
		private Model model;

	
	/*public static void main(String[] args) {
		PlayerManager pm = new PlayerManager("C:\\Program Files\\VideoLAN\\VLC");
				
		pm.play("http://www.youtube.com/watch?v=cxL0QLvauBU");
		
		
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}*/
		
		
		
    
    public PlayerManager(String pmSourceFolder, Model model) {
    	    
    	this.model = model;
    	
    	/*
    	 * pmSourceFolder = "C:\\Users\\Jean-Vital\\Downloads\\Hemixos\\VLC\\";
    	 * pmSourceFolder = "C:\\Program Files\\VideoLAN\\VLC";
    	 * pmSourceFolder = "C:/Program Files/VideoLAN/VLC";
    	 * pmSourceFolder = "/VLC";
    	 */

    	/*
    	 *  Connect to VLC runnable
    	 */
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), pmSourceFolder);
        //System.setProperty("jna.library.path", pmSourceFolder)
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
        
        /*
         * Initialise media player
         */
        String[] libvlcArgs = {"--vout", "dummy"};
        MediaPlayerFactory factory = new MediaPlayerFactory(libvlcArgs);
        mediaPlayer = factory.newEmbeddedMediaPlayer();
        mediaPlayer.setPlaySubItems(true);
        mediaPlayer.addMediaPlayerEventListener(this);
        
    }
    
    public void play(final String ln) {
    	
    	SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	mediaPlayer.playMedia(ln);
            }
        });
    }

	public void stop() {
		mediaPlayer.stop();
	}

	public void pause() {
		mediaPlayer.pause();		
	}

	public void play() {
		if (!mediaPlayer.isPlaying()) {
			mediaPlayer.play();
		}
	}
	
	public void seek(float s) {
		// TODO ca ne fonctionne pas encore !
		/*if (hmp.isSeekable()) {
			System.out.println("seek to:" + s);
			hmp.setPosition(s);
		}*/
	}
	
	public void setVolumeLevel(int level) {
		mediaPlayer.setVolume(level);
	}

	public int getTrackLength() {
		return (int) mediaPlayer.getLength();
	}

	public int getTrackLengthPlayed() {
		return (int) mediaPlayer.getTime();
	}
	
	public boolean isPlaying() {		
		return mediaPlayer.isPlaying();
	}

	public EmbeddedMediaPlayer getMediaPlayer() {
		return mediaPlayer;
	}

	
	
	
	
	
	
	
	/*
	 * 
	 * Listener
	 * 
	 */
	
	public void backward(MediaPlayer arg0) {
		// TODO Auto-generated method stub
		
	}

	public void buffering(MediaPlayer arg0, float per) {
    	model.getMp().setBuffering(true);
    	model.getMp().setBuffered(per);
	}

	public void endOfSubItems(MediaPlayer arg0) {
		// TODO Auto-generated method stub
		
	}

	public void error(MediaPlayer mpe) {
    	model.getMp().setEnLecture(false);
		System.out.println("error");
	}

	public void finished(MediaPlayer arg0) {
		
        // On receipt of a "finished" event, check if sub-items have been created...
        List<String> subItems = mediaPlayer.subItems();
        System.out.println("subItems=" + subItems);
        // If sub-items were created...
        if(subItems != null && !subItems.isEmpty()) {
            // Pick the first sub-item, and play it...
            String subItemMrl = subItems.get(0);
            mediaPlayer.playMedia(subItemMrl);
            // What will happen next...
            // 1. if the vlc lua script finds the streaming MRL via the normal i.e.
            // "primary" method, then this subitem MRL will be the streaming MRL; or
            // 2. if the vlc lua script does not find the streaming MRL via the primary
            // method, then the vlc lua script fallback method is tried to locate the
            // streaming MRL and the next time a "finished" event is received there will
            // be a new sub-item for the just played subitem, and that will be the
            // streaming MRL
        } else {
            // Your own application would not exit, but would instead probably set some
            // state flag or fire some sort of signal or whatever that the media actually
            // finished
        	model.getMp().setBuffering(false);
        	model.getMp().setEnLecture(false);
        	model.getMp().actionNext();
        	
        	//System.exit(0);
            
            
        }
		
	}

	public void forward(MediaPlayer arg0) {
		// TODO Auto-generated method stub
		
	}

	public void lengthChanged(MediaPlayer arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	public void mediaChanged(MediaPlayer arg0, libvlc_media_t arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}

	public void mediaDurationChanged(MediaPlayer arg0, long arg1) {
		// TODO Auto-generated method stub
		model.getMp().getQueue().getCurrentSong().setDurationMillis(arg1);
	}

	public void mediaFreed(MediaPlayer arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mediaMetaChanged(MediaPlayer arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	public void mediaParsedChanged(MediaPlayer arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	public void mediaStateChanged(MediaPlayer arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	public void mediaSubItemAdded(MediaPlayer arg0, libvlc_media_t arg1) {
		//System.out.println("mediaSubItemAdded: " + mediaPlayer.mrl(arg1));
	}

	public void newMedia(MediaPlayer arg0) {
		// TODO Auto-generated method stub
		
	}

	public void opening(MediaPlayer arg0) {
		System.out.println("opening");
	}

	public void pausableChanged(MediaPlayer arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	public void paused(MediaPlayer arg0) {
		// TODO Auto-generated method stub
		model.getMp().setEnLecture(false);
	}

	public void playing(MediaPlayer arg0) {
    	model.getMp().setEnLecture(true);
    	model.getMp().setBuffering(false);
	}

	public void positionChanged(MediaPlayer arg0, float arg1) {
		// TODO Auto-generated method stub
		
	}

	public void seekableChanged(MediaPlayer arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	public void snapshotTaken(MediaPlayer arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	public void stopped(MediaPlayer arg0) {
    	model.getMp().setEnLecture(false);
    	model.getMp().setBuffering(false);
	}

	public void subItemFinished(MediaPlayer arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	public void subItemPlayed(MediaPlayer arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	public void timeChanged(MediaPlayer arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	public void titleChanged(MediaPlayer arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	public void videoOutput(MediaPlayer arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	
}
























