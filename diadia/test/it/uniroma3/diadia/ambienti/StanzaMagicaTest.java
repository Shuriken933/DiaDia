//package it.uniroma3.diadia.ambienti;
//
//import static org.junit.Assert.*;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import it.uniroma3.diadia.attrezzi.Attrezzo;
//
//public class StanzaMagicaTest {
//	
//	private StanzaMagica stanzaMagica;
//	private Attrezzo attrezzo;
//
//	@Before
//	public void setUp() {
//		this.stanzaMagica = new StanzaMagica("Inferno", 0);
//		this.attrezzo = new Attrezzo("penna", 2);
//		
//		this.stanzaMagica.addAttrezzo(this.attrezzo);
//	}
//
//	@Test
//	public void test() {
//		assertEquals("annep", this.stanzaMagica.getAttrezzo("penna"));
//		assertEquals(4, this.stanzaMagica.getAttrezzo("annep").getPeso());
//		
//	}
//
//}
