package app.annotation.instrumental;

import app.annotation.myannotation.StringedInstrument;
import app.annotation.myannotation.Strummed;
import app.instrument.Instrument;
import app.performer.Performer;
import app.performer.exception.PerformerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.inject.Inject;
import javax.inject.Named;

//@Configurable(value = "guitar")
public class Instrumentalist implements Performer {

	private String name;
	private String song;
//	@Named("guitar")
	@Autowired(required = false)
//	@Qualifier(value = "keyboard")
//	@StringedInstrument
	@Strummed
//	@Inject
	private Instrument instrument;
//	@Autowired

	public Instrumentalist(Instrument instrument) {
		this.instrument = instrument;
	}

	public Instrumentalist(String name, String song, Instrument instrument) {
		this.name = name;
		this.song = song;
		this.instrument = instrument;
	}
//	@Autowired

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

//	@Autowired
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

//	@Autowired
	public void hereIsYourInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

}
