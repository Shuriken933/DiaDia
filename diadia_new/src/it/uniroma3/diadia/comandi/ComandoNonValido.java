package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {

	private IO console;

	@Override
	public void esegui(Partita partita) {
		this.console.mostraMessaggio("comando non valido!");
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setIO(IO console) {
		this.console = console;
	}

}
