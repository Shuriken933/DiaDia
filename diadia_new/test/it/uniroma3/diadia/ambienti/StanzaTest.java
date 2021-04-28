package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;

import it.uniroma3.diadia.attrezzi.Attrezzo;


import org.junit.Test;


public class StanzaTest {

	private Stanza stanza1;
	private Stanza stanza2;

	private Attrezzo attrezzo;

	@Before
	public void setUp() {
		this.stanza1 = new Stanza("N16");
		this.stanza2 = new Stanza("N11");
		this.attrezzo = new Attrezzo("osso", 2);
	}

	@Test
	public void testUnAttrezzo() {
		assertTrue("osso", this.stanza1.addAttrezzo(this.attrezzo));
	}


	@Test
	public void testNessunAttrezzo() {
		assertNotSame("zaino", this.stanza1.addAttrezzo(this.attrezzo));
	}

	@Test
	public void testAlmenoUnAttrezzo() {
		assertNotNull("questa stanza non è vuota", this.stanza1.addAttrezzo(this.attrezzo));
	}



	@Test
	public void testToString() {
		assertEquals(this.stanza1.toString(), "N16\nUscite: \nAttrezzi nella stanza: ", this.stanza1.toString());
	}

	@Test
	public void testUnaStanzaAdiacente() {
		this.stanza1.impostaStanzaAdiacente("nord", stanza2);
		assertSame(this.stanza2, this.stanza1.getStanzaAdiacente("nord"));
	}

	@Test
	public void testNessunaStanzaAdiacente() {
		assertNull(this.stanza1.getStanzaAdiacente("nord"));
	}




	@Test
	public void testRimuoviAttrezzo() {
		this.stanza1.addAttrezzo(attrezzo);
		this.stanza1.removeAttrezzo(attrezzo);
		assertNull("nessun attrezzo", this.stanza1.getAttrezzo("osso"));
	}
}
