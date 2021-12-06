package logica;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import app.App;

public class Musica extends Thread {

	private String path_pista = App.configuration.getProperty("RutaMusica");
	private AudioInputStream audio_stream;
	private Clip audio_clip;

	private static final int AUDIO_DETENIDO = 0;
	private static final int AUDIO_EN_REPRODUCCION = 1;
	private static final int AUDIO_PAUSADO = 2;
	private int status;
	private boolean status_inicial;

	public Musica(boolean status_inicial) {
		this.status_inicial = status_inicial;
		start();
	}

	@Override
	public void run() {
		if (status_inicial) {
			preparar_audio();
			play_audio();
		} else {
			status = AUDIO_DETENIDO;
		}
	}

	public void stop_audio() {
		if (status == AUDIO_EN_REPRODUCCION || status == AUDIO_PAUSADO) {
			audio_clip.stop();
			status = AUDIO_DETENIDO;
			audio_clip.close();
		}
	}

	public void play_pause_audio() {
		switch (status) {
		case AUDIO_EN_REPRODUCCION: { // Se pausa la música.
			audio_clip.stop();
			status = AUDIO_PAUSADO;
			break;
		}
		case AUDIO_PAUSADO: { // Se continúa la reproducción desde donde estaba previamente.
			play_audio();
			break;
		}
		case AUDIO_DETENIDO: { // Se inicia la reproducción desde el principio.
			preparar_audio();
			play_audio();
			break;
		}
		}
	}

	private void play_audio() {
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