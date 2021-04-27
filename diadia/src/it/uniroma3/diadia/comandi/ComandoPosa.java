package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoPosa implements Comando {
	
	private IO io;
	private String attrezzo;

	@Override
	public void esegui(Partita partita) {
		
		if (partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo)) {
			partita.getStanzaCorrente().addAttrezzo(partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo));
			this.io.mostraMessaggio(attrezzo + " posato!");
		} else {
			this.io.mostraMessaggio("non possiedi "+ attrezzo);
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
