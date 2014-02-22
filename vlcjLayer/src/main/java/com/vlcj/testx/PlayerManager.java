package com.vlcj.testx;

import javax.swing.SwingUtilities;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.headless.HeadlessMediaPlayer;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

public class PlayerManager {

    
    private HeadlessMediaPlayer hmp;
    private MediaPlayerFactory mpf;
    
    public PlayerManager(String pmSourceFolder) {
    	
    	
    	/*
    	pmSourceFolder = "C:\\Users\\Jean-Vital\\Downloads\\Hemixos\\VLC\\";
    	pmSourceFolder = "C:\\Program Files\\VideoLAN\\VLC";
    	pmSourceFolder = "C:/Program Files/VideoLAN/VLC";
    	pmSourceFolder = "/VLC";
    	 */
    	System.out.println("to load: " + pmSourceFolder);
    	
    	

				
		
    	// Connect to VLC runnable
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), pmSourceFolder);
        //System.setProperty("jna.library.path", pmSourceFolder);
        
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
    
        this.mpf = new MediaPlayerFactory();
        this.hmp = mpf.newHeadlessMediaPlayer();

        // TODO Ajouter un media player event listener
        //this.hmp.addMediaPlayerEventListener(this);
        
    }
    
    public void play(final String ln) {
    	
    	SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                hmp.playMedia(ln);
            }
        });
        
    }

	public void stop() {
		hmp.stop();
	}

	public void pause() {
		if (hmp.canPause()) {
			hmp.pause();
		} else {
			stop();
		}
	}

	public void play() {
		if (hmp.isPlayable() && !hmp.isPlaying()) {
			hmp.play();
		}
	}
	
	public void seek(float s) {
		// TODO ca ne fonctionne pas encore !
		if (hmp.isSeekable()) {
			System.out.println("seek to:" + s);
			hmp.setPosition(s);
		}
	}
	
	public void setVolumeLevel(int level) {
		hmp.setVolume(level);
	}

	public int getTrackLength() {
		return (int) hmp.getLength();
	}

	public int getTrackLengthPlayed() {
		return (int) hmp.getTime();
	}

	
	
}
























