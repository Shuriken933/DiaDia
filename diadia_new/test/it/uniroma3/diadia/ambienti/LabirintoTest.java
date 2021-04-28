package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class LabirintoTest {

	private Labirinto labirinto;

	@Before
	public void setUp() {

		this.labirinto = new Labirinto();
		labirinto.creaStanze();
	}

	@Test
	public void testGetVincente() {
		assertEquals("Biblioteca", this.labirinto.getStanzaVincente().getNome());
	}


	@Test
	public void testGetIniziale() {
		assertEquals("Atrio", this.labirinto.getStanzaIniziale().getNome());
	}
}
