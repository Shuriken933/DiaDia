package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	
	private IO io;
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "guarda"};


	@Override
	public void esegui(Partita partita) {

		System.out.print("COMANDI DEL GIOCO: ");
		for(int i=0; i< elencoComandi.length; i++)
			this.io.mostraMessaggio(elencoComandi[i]+" ");
		this.io.mostraMessaggio("");
		this.io.mostraMessaggio("BORSA GIOCATORE: " + partita.getGiocatore().getBorsa().toString());
		this.io.mostraMessaggio("");this.io.mostraMessaggio("");
	}	

	@Override
	public void setParametro(String parametro) {
		
	}

	@Override
	public void setIO(IO console) {
		this.io = console;

	}

}
