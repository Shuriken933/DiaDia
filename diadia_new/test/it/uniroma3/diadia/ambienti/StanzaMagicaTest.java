package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {
	
	private StanzaMagica stanzaMagica;
	private Attrezzo attrezzo;

	@Before
	public void setUp() {
		this.attrezzo = new Attrezzo("attrezzo", 2);
		this.stanzaMagica = new StanzaMagica("Inferno",0);
		this.stanzaMagica.addAttrezzo(attrezzo);
	}

	@Test
	public void nomeInvertito_PesoRaddoppiato() {
		assertTrue(this.stanzaMagica.hasAttrezzo("ozzertta"));
		assertEquals("ozzertta", this.stanzaMagica.getAttrezzo("ozzertta").getNome());
		assertEquals(4, this.stanzaMagica.getAttrezzo("ozzertta").getPeso());
	}

}
