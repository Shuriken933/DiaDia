package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosaTest {

	private Comando comandoPosa;
	private Partita partita;
	private Attrezzo attrezzo;
	private IOConsole io;

	@Before
	public void setUp() {
		
		this.partita = new Partita();
		this.attrezzo = new Attrezzo("osso", 2);
		this.partita.getGiocatore().getBorsa().addAttrezzo(this.attrezzo);
		this.comandoPosa = new ComandoPosa();
		this.io = new IOConsole();

	}

	
	@Test
	public void testPosaUnAttrezzo()  {
		assertFalse(this.partita.getGiocatore().getBorsa().isEmpty());
		
		this.comandoPosa.setParametro("osso");
		this.comandoPosa.setIO(io);
		this.comandoPosa.esegui(this.partita);
		
		assertTrue(this.partita.getGiocatore().getBorsa().isEmpty());
		
		
	}
}
