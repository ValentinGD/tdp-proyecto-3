package logica;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Musica {

	private String path_pista = "src/sonidos/battle-march-action-loop.wav";
	private AudioInputStream audio_stream;
	private Clip audio_clip;
	private boolean esta_sonando;
	
	public Musica() {
		try {
			audio_stream = AudioSystem.getAudioInputStream(new File(path_pista).getAbsoluteFile());
			audio_clip = AudioSystem.getClip();
	        audio_clip.open(audio_stream);
	        esta_sonando = false;
		} catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
			e.printStackTrace();
			System.out.println("Problema con el archivo de audio.");
		}
	}
	
	public void stop() {
		
	}
	
	public void play_pause() {
		if (esta_sonando) {
			audio_clip.stop();
			esta_sonando = false;
		}
		else {
			audio_clip.start();
			esta_sonando = true;
		}
	}

}