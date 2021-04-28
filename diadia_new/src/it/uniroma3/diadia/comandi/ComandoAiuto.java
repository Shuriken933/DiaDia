package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};
	
	private IO io;

	@Override
	public void esegui(Partita partita) {

		this.io.mostraMessaggio("COMANDI DEL GIOCO: ");
		for(int i=0; i< elencoComandi.length; i++) 
			this.io.mostraMessaggio(elencoComandi[i]+" ");
		this.io.mostraMessaggio("");
		this.io.mostraMessaggio("BORSA GIOCATORE: " + partita.getGiocatore().getBorsa().toString());
		this.io.mostraMessaggio("");this.io.mostraMessaggio("");

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setIO(IO console) {
		this.io = console;

	}

}
