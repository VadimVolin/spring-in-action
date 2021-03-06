package app.javaconfig.instrumental;

import app.javaconfig.instrument.Instrument;
import app.javaconfig.performer.Performer;
import app.javaconfig.performer.exception.PerformerException;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable("pianist")
public class Instrumentalist implements Performer {

	private String name;
	private String song;
	private Instrument instrument;

	public Instrumentalist(Instrument instrument) {
		this.instrument = instrument;
	}

	public Instrumentalist(String name, String song, Instrument instrument) {
		this.name = name;
		this.song = song;
		this.instrument = instrument;
	}

	public Instrumentalist() {

	}

	public void perform() throws PerformerException {
		System.out.println("Playing " + song + " : ");
		instrument.play();
	}

	@Override
	public String toString() {
		return (name == null ? "" : name) + " singe " + song + " -- " + instrument.toString();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public String getSong() {
		return song;
	}

	public String screamSong() {
		return song;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
	
}
