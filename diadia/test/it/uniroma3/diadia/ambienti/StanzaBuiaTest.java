package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	
	private StanzaBuia stanza;
	private Attrezzo lanterna;

	@Before
	public void setUp()  {
		this.stanza = new StanzaBuia("n11", "lanterna");
		this.lanterna = new Attrezzo("lanterna", 2);
	}

	@Test
	public void testSenzaLanterna() {
		assertEquals(this.stanza.toString(), "Qui c'è un buio pesto", this.stanza.getDescrizione());
		
	}
	
	@Test
	public void testConLanterna() {
		this.stanza.addAttrezzo(this.lanterna);
		assertEquals(this.stanza.toString(), "n11\nUscite: \nAttrezzi nella stanza: lanterna (2kg) " , this.stanza.getDescrizione());
	}

}
