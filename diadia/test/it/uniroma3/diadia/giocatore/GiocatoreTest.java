package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GiocatoreTest {
	
	private Giocatore giocatore;
	int cfu;
	
	@Before
	public void setUp() {
		
		this.giocatore = new Giocatore();
		this.giocatore.setCfu(3);
	}	

	@Test
	public void testDecrementaCfu() {
		this.giocatore.decrementaCfu(cfu);
		assertEquals(2, this.giocatore.getCfu());		
	}

}
