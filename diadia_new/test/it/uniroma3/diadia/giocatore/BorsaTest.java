package it.uniroma3.diadia.giocatore;



import static org.junit.Assert.*;



import org.junit.Before;
import org.junit.Test;



import it.uniroma3.diadia.attrezzi.Attrezzo;




public class BorsaTest {

	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;



	private Borsa borsa1;
	private Borsa borsa2;




	@Before
	public void setUp() {

		this.borsa1 = new Borsa(2);
		this.borsa2 = new Borsa(1);
		this.attrezzo1 = new Attrezzo("osso", 2);
		this.attrezzo2 = new Attrezzo("martello", 2);
	}



	@Test
	public void testUnAttrezzo() {
		assertTrue(this.borsa1.addAttrezzo(this.attrezzo1));
	}

	@Test
	public void testTroppoPeso() {
		assertFalse(this.borsa2.addAttrezzo(this.attrezzo1));
	}

	@Test
	public void testTroppiAttrezzi() {
		this.borsa1.addAttrezzo(this.attrezzo1);
		assertFalse(this.borsa1.addAttrezzo(this.attrezzo2));
	}

	@Test
	public void testToString() {
		this.borsa1.addAttrezzo(this.attrezzo1);
		assertEquals(this.borsa1.toString(), "Contenuto borsa (2kg/2kg): osso (2kg) " ,this.borsa1.toString());
	}

	@Test
	public void testToStringBorsaVuota() {
		assertEquals(this.borsa1.toString(), "Borsa vuota", this.borsa1.toString());
	}

	@Test
	public void testRimuoviUnAttrezzo() {
		this.borsa1.addAttrezzo(attrezzo2);
		this.borsa1.removeAttrezzo(attrezzo2.getNome());
		assertFalse(this.borsa1.hasAttrezzo(this.attrezzo2.getNome()));
	}

	@Test
	public void testRimuoviAttrezzo() {
		assertEquals(null, this.borsa1.removeAttrezzo("osso"));
	}
}