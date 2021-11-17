package logica;

//no olvidar cerrar el audio al terminar el juego (para liberar recursos).

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

	private static final int AUDIO_DETENIDO = 0;
	private static final int AUDIO_EN_REPRODUCCION = 1;
	private static final int AUDIO_PAUSADO = 2;
	private int status;
	
	public Musica() {
		//COMENTAR ESTO PARA COMENZAR CON MUSICA ATR.
		status = AUDIO_DETENIDO;
		
		//COMENTAR ESTO PARA COMENZAR EN SILENCIO.
//		preparar_audio();
//		play();
	}
	
	public void stop() {
		if (status == AUDIO_EN_REPRODUCCION || status == AUDIO_PAUSADO) {
			audio_clip.stop();
			status = AUDIO_DETENIDO;
			audio_clip.close();
		}
	}
	
	public void play_pause() {
		switch (status) {
			case AUDIO_EN_REPRODUCCION: { //Procedo a pausar la música.
				audio_clip.stop();
				status = AUDIO_PAUSADO;
				break;
			}
			case AUDIO_PAUSADO: { //Continúo la reproducción desde donde estaba.
				play();
				break;
			}
			case AUDIO_DETENIDO: { //Inicio reproducción desde el principio.
				preparar_audio();
				play();
				break;
			}
		}
	}
	
	private void play() {
		audio_clip.start();
		status = AUDIO_EN_REPRODUCCION;
		audio_clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	private void preparar_audio() {
		try {
			audio_stream = AudioSystem.getAudioInputStream(new File(path_pista).getAbsoluteFile());
			audio_clip = AudioSystem.getClip();
			audio_clip.open(audio_stream);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
			System.out.println("Error con el archivo de audio.");
		}
	}

}