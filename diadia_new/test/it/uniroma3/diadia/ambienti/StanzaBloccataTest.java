package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
	
	private StanzaBloccata stanzaBloccata;
	private Stanza stanza;
	private Attrezzo attrezzo;
	private IO io;

	@Before
	public void setUp(){
		this.stanzaBloccata = new StanzaBloccata("stanza bloccata", "sud", "chiave");
		this.stanza = new Stanza("stanza");
		this.stanzaBloccata.impostaStanzaAdiacente("sud", stanza);
		this.attrezzo = new Attrezzo("chiave", 1);
		this.io = new IOConsole();
	}
	
	@Test
	public void testGetStanzaAdiacente_direzioneSbagliata() {
		assertEquals(null, this.stanzaBloccata.getStanzaAdiacente("nord"));
	}

	@Test
	public void testGetStanzaAdiacente_direzioneBloccata() {
		this.io.mostraMessaggio("\nTEST direzione bloccata");
		assertEquals(null, this.stanzaBloccata.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testGetStanzaAdiacente_direzioneSbloccata() {
		this.io.mostraMessaggio("\nTEST direzione sbloccata");
		this.stanzaBloccata.addAttrezzo(this.attrezzo);
		assertEquals(stanza, this.stanzaBloccata.getStanzaAdiacente("sud"));
	}

}
