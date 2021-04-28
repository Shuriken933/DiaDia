package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {
	
	private Partita partita;
	private ComandoPrendi comandoPrendi;
	private Stanza stanza;
	private Attrezzo osso;
	private IOConsole io;

	@Before
	public void setUp() {
		this.partita = new Partita();
		this.comandoPrendi = new ComandoPrendi();
		this.osso = new Attrezzo("osso", 2);
		this.stanza = new Stanza("Inferno");
		this.io = new IOConsole();
		
		this.partita.setStanzaCorrente(stanza);
		this.partita.getStanzaCorrente().addAttrezzo(osso);
	}

	@Test
	public void aggiungiUnAttrezzoABorsa_borsaNonVuota_stanzaVuota() {
		this.comandoPrendi.setIO(io);
		this.comandoPrendi.setParametro("osso");
		this.comandoPrendi.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().isEmpty());
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo(osso.getNome()));
	}
	
	@Test
	public void aggiungiUnAttrezzoNonEsistente() {
		this.comandoPrendi.setIO(io);
		this.comandoPrendi.setParametro("ossicino");
		this.comandoPrendi.esegui(partita);
		assertTrue(this.partita.getGiocatore().getBorsa().isEmpty());
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo(osso.getNome()));
	}

}


