package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;

public class StregaTest {
	
	private Partita partita;
	private Strega strega;

	@Before
	public void setUp() throws Exception {
		Labirinto labirinto = new LabirintoBuilder()
				.addStanzaIniziale("LabCampusOne")
				.addStanza("Biblioteca")
				.addAttrezzo("osso", 1)
				.addAttrezzo("chiave", 2)
				.addAdiacenza("LabCampusOne", "Biblioteca", "nord")
				.addStanza("N10")
				.addAttrezzo("torcia", 3)
				.addAdiacenza("LabCampusOne", "N10", "sud")
				.addStanza("Stanza vuota")
				.addAdiacenza("LabCampusOne", "Stanza vuota", "ovest")
				.getLabirinto();
		this.partita = new Partita(labirinto);
		this.strega = new Strega("strega", "presentazione");
	}

	@Test
	public void testAgisci_NoSaluto() {
		this.strega.agisci(this.partita);
		assertEquals("Stanza vuota", this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testAgisci_Saluto() {
		this.strega.saluta();
		this.strega.agisci(this.partita);
		assertEquals("Biblioteca", this.partita.getStanzaCorrente().getNome());
	}

}