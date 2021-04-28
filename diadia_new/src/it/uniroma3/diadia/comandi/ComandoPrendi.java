package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	
	private String attrezzo;
	
	private IO io;

	@Override
	public void esegui(Partita partita) {

		if (partita.getStanzaCorrente().hasAttrezzo(attrezzo)) {
			Attrezzo attrezzoScambio = partita.getStanzaCorrente().getAttrezzo(attrezzo);
			partita.getGiocatore().getBorsa().addAttrezzo(attrezzoScambio);
			partita.getStanzaCorrente().removeAttrezzo(attrezzoScambio);
			this.io.mostraMessaggio(attrezzo + " preso!");
		} else {
			this.io.mostraMessaggio(attrezzo + " non è nella stanza");
		}

	}

	@Override
	public void setParametro(String parametro) {
		this.attrezzo = parametro;
	}

	@Override
	public void setIO(IO console) {
		this.io = console;

	}

}
