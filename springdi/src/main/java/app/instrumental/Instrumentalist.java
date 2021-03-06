package app.instrumental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import app.instrument.Instrument;
import app.performer.Performer;
import app.performer.exception.PerformerException;

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
		System.out.println(name + " Playing " + song + " : ");
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

	public Instrument getInstrument() {
		return instrument;
	}
	
}
