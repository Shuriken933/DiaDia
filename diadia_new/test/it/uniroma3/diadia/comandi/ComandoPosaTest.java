package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoPosaTest {
	
	private Partita partita;
	private ComandoPosa comandoPosa;
	private Stanza stanza;
	private Attrezzo osso;
	private IOConsole io;

	@Before
	public void setUp(){
		
		this.partita = new Partita();
		this.comandoPosa = new ComandoPosa();
		this.osso = new Attrezzo("osso", 2);
		this.stanza = new Stanza("Inferno");
		this.io = new IOConsole();
		
		this.partita.setStanzaCorrente(stanza);
		this.partita.getGiocatore().getBorsa().addAttrezzo(osso);
	}

	@Test
	public void borsaNonVuota() {
		assertFalse(this.partita.getGiocatore().getBorsa().isEmpty());
		assertTrue(this.partita.getStanzaCorrente().isEmpty());
	}
	
	@Test
	public void posaConBorsa1Elemento() {
		this.comandoPosa.setIO(io);
		this.comandoPosa.setParametro("osso");
		this.comandoPosa.esegui(partita);
		assertEquals(true, this.partita.getGiocatore().getBorsa().isEmpty());
	}

}
