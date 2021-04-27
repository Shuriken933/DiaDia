package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {
	
	private Partita partita;
	private Comando comandoPrendi;
	private IOConsole io;
	private Attrezzo attrezzo;

	@Before
	public void setUp() {
		
		this.partita = new Partita();
		this.comandoPrendi = new ComandoPrendi();
		this.io = new IOConsole();
		this.attrezzo = new Attrezzo("osso", 2);
	}

	@Test
	public void test() {
		assertTrue(this.partita.getGiocatore().getBorsa().isEmpty());
		
		this.comandoPrendi.esegui(this.partita);
		this.comandoPrendi.setIO(io);
		this.comandoPrendi.setParametro("osso");
		
		assertFalse(this.partita.getGiocatore().getBorsa().isEmpty());
	}

}
