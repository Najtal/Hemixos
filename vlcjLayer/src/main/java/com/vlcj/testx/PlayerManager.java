package com.vlcj.testx;

import javax.swing.SwingUtilities;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.binding.internal.libvlc_media_t;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventListener;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.headless.HeadlessMediaPlayer;
import uk.co.caprica.vlcj.player.list.MediaListPlayer;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

public class PlayerManager implements MediaPlayerEventListener {

        private MediaPlayerFactory mpf;
		private HeadlessMediaPlayer hmp;

    
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
        
        hmp.addMediaPlayerEventListener(this);
                
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
		hmp.pause();		
	}

	public void play() {
		if (!hmp.isPlaying()) {
			hmp.play();
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
		hmp.setVolume(level);
	}

	public int getTrackLength() {
		return (int) hmp.getLength();
	}

	public int getTrackLengthPlayed() {
		return (int) hmp.getTime();
	}
	
	public boolean isPlaying() {		
		return hmp.isPlaying();
	}

	public HeadlessMediaPlayer getMediaPlayer() {
		return hmp;
	}

	
	
	
	public void backward(MediaPlayer arg0) {
		// TODO Auto-generated method stub
		
	}

	public void buffering(MediaPlayer arg0, float arg1) {
		// TODO Auto-generated method stub
		
	}

	public void endOfSubItems(MediaPlayer arg0) {
		// TODO Auto-generated method stub
		
	}

	public void error(MediaPlayer arg0) {
		// TODO Auto-generated method stub
		
	}

	public void finished(MediaPlayer arg0) {
		// TODO Auto-generated method stub
		System.out.println("finish :)");
		
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
		// TODO Auto-generated method stub
		
	}

	public void newMedia(MediaPlayer arg0) {
		// TODO Auto-generated method stub
		
	}

	public void opening(MediaPlayer arg0) {
		// TODO Auto-generated method stub
		
	}

	public void pausableChanged(MediaPlayer arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	public void paused(MediaPlayer arg0) {
		// TODO Auto-generated method stub
		
	}

	public void playing(MediaPlayer arg0) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
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
























