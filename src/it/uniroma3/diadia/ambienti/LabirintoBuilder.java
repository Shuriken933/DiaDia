package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

//public class LabirintoBuilder{
//	
//	Labirinto labirinto;
//	private Map<String,Stanza> nome2stanza;
//	private Stanza ultimaStanza;
//	
//	public LabirintoBuilder() {
//		this.labirinto = new Labirinto();
//		this.nome2stanza = new HashMap<String, Stanza>();
//	}
//	
//	
//	// metodi
//	public void addStanza(String nomeStanza) {
//		Stanza nuovaStanza = new Stanza(nomeStanza);
//		this.ultimaStanza = nuovaStanza;
//		this.nome2stanza.put(nomeStanza, nuovaStanza);
//	}
//	
//	public void addStanzaMagica(String nomeStanza) {
//		Stanza nuovaStanza = new StanzaMagica(nomeStanza);
//		this.ultimaStanza = nuovaStanza;
//		this.nome2stanza.put(nomeStanza, nuovaStanza);
//	}
//	
//	public void addStanzaBuia(String nomeStanza) {
//		Stanza nuovaStanza = new StanzaBuia(nomeStanza);
//		this.ultimaStanza = nuovaStanza;
//		this.nome2stanza.put(nomeStanza, nuovaStanza);
//	}
//	
//	public void addStanzaBloccata(String nomeStanza) {
//		Stanza nuovaStanza = new StanzaBloccata(nomeStanza);
//		this.ultimaStanza = nuovaStanza;
//		this.nome2stanza.put(nomeStanza, nuovaStanza);
//	}
//	
//	public void addStanzaIniziale(String nomeStanza) {
//		Stanza nuovaStanza = new Stanza(nomeStanza);
//		this.ultimaStanza = nuovaStanza;
//		this.labirinto.setStanzaIniziale(nuovaStanza);
//		this.nome2stanza.put(nomeStanza, nuovaStanza);
//	}
//	
//	public void addStanzaVincente(String nomeStanza) {
//		Stanza nuovaStanza = new Stanza(nomeStanza);
//		this.ultimaStanza = nuovaStanza;
//		this.labirinto.setStanzaVincente(nuovaStanza);
//		this.nome2stanza.put(nomeStanza, nuovaStanza);
//	}
//	
//	public void addAdiacenza(String primaStanza_nome, String secondaStanza_nome, String direzione) {
//		Stanza primaStanza = this.nome2stanza.get(primaStanza_nome);
//		Stanza secondaStanza = this.nome2stanza.get(secondaStanza_nome);
//		primaStanza.impostaStanzaAdiacente(direzione, secondaStanza);
//	}
//	
//	public void addAttrezzo(String nomeAttrezzo, int peso) {
//		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
//		this.ultimaStanza.addAttrezzo(attrezzo);
//	}
//	
//	public Labirinto getLabirinto() {
//		return labirinto;
//	}
//	
//	
//
//}


public class LabirintoBuilder {
	
	private Labirinto labirinto;
	private Stanza ultimaAggiunta;
	private Map<String,Stanza> nome2stanza;
	
	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
		this.nome2stanza = new HashMap<String, Stanza>();
	}
	
	public LabirintoBuilder addStanzaIniziale(String nomeStanzaIniziale) {
		Stanza iniziale = new Stanza(nomeStanzaIniziale);
		this.labirinto.setStanzaIniziale(iniziale);
		this.aggiungiAMappaEAggiornaUltima(iniziale);
		return this;
	}
	
	public LabirintoBuilder addStanzaVincente(String nomeStanzaVincente) {
		Stanza vincente = new Stanza(nomeStanzaVincente);
		this.labirinto.setStanzaVincente(vincente);
		this.aggiungiAMappaEAggiornaUltima(vincente);
		return this;
	}
	
	public LabirintoBuilder addAdiacenza(String partenza, String adiacente, String direzione) {
		Stanza stanzaPartenza = this.nome2stanza.get(partenza);
		Stanza stanzaAdiacente = this.nome2stanza.get(adiacente);
		stanzaPartenza.impostaStanzaAdiacente(direzione, stanzaAdiacente);
		return this;
	}
	
	public LabirintoBuilder addAttrezzo(String nome, int peso) {
		Attrezzo a= new Attrezzo(nome, peso);
		this.ultimaAggiunta.addAttrezzo(a);
		return this;
	}

	public LabirintoBuilder addStanza(String nome) {
		Stanza stanza = new Stanza(nome);
		this.aggiungiAMappaEAggiornaUltima(stanza);
		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String nome) {
		Stanza stanza = new StanzaMagica(nome);
		this.aggiungiAMappaEAggiornaUltima(stanza);
		return this;
	}
	
	public LabirintoBuilder addStanzaBuia(String nome, String attrezzoPerVedere) {
		Stanza stanza = new StanzaBuia(nome,attrezzoPerVedere);
		this.aggiungiAMappaEAggiornaUltima(stanza);
		return this;
	}
	
	public LabirintoBuilder addStanzaBloccata(String nome, String attrezzoSbloccante, String direzioneBloccata) {
		Stanza stanza = new StanzaBloccata(nome, attrezzoSbloccante, direzioneBloccata);
		this.aggiungiAMappaEAggiornaUltima(stanza);
		return this;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	private void aggiungiAMappaEAggiornaUltima(Stanza stanza) {
		this.ultimaAggiunta = stanza;
		this.nome2stanza.put(stanza.getNome(), stanza);
	}

}
