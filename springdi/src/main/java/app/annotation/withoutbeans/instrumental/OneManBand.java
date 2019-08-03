package app.annotation.withoutbeans.instrumental;

import app.performer.Performer;
import app.performer.exception.PerformerException;

import java.util.Properties;

public class OneManBand implements Performer {	
	
	private Properties instruments;
	
	public OneManBand() {
		
	}
	
	public void setInstruments (Properties instruments) {
		this.instruments = instruments;
	}

	public void perform() throws PerformerException {
		for (Object instrName : instruments.keySet()) {
			String name = (String) instrName;
			System.out.print(name + " : ");
			String instrument = (String) instruments.get(name);
			System.out.println(instrument);
		}
	}

}
