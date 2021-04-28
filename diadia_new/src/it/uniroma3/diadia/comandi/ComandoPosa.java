package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoPosa implements Comando {
	
	private String attrezzo;
	private IO io;

	@Override
	public void esegui(Partita partita) {

		if (partita.getGiocatore().getBorsa().hasAttrezzo(this.attrezzo)) {
			partita.getStanzaCorrente().addAttrezzo(partita.getGiocatore().getBorsa().removeAttrezzo(this.attrezzo));
			this.io.mostraMessaggio(this.attrezzo + " posato!");
		} else {
			this.io.mostraMessaggio("non possiedi " + this.attrezzo);
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
