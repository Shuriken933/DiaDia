package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Questa classe modella un labirinto
 *
 * @author studenti
 * @see Stanza
 * @version 0.3
 */


public class Labirinto {
	
	public static LabirintoBuilder newBuilder() {
		return new LabirintoBuilder();
	}

	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;

	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}

	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}

	public void setStanzaIniziale(Stanza stanzaIniziale) {
		this.stanzaIniziale = stanzaIniziale;
	}

	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}

	public static class LabirintoBuilder {

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
			this.ultimaAggiunta = iniziale;
			this.nome2stanza.put(iniziale.getNome(), iniziale);
			return this;
		}

		public LabirintoBuilder addStanzaVincente(String nomeStanzaVincente) {
			Stanza vincente = new Stanza(nomeStanzaVincente);
			this.labirinto.setStanzaVincente(vincente);
			this.ultimaAggiunta = vincente;
			this.nome2stanza.put(vincente.getNome(), vincente);
			return this;
		}

		public LabirintoBuilder addAdiacenza(String partenza, String adiacente, String direzione) {
			Stanza stanzaPartenza = this.nome2stanza.get(partenza);
			Stanza stanzaAdiacente = this.nome2stanza.get(adiacente);
			stanzaPartenza.impostaStanzaAdiacente(Direzione.valueOf(direzione.toUpperCase()), stanzaAdiacente);
			return this;
		}

		public LabirintoBuilder addAttrezzo(String nome, int peso) {
			Attrezzo a = new Attrezzo(nome, peso);
			this.ultimaAggiunta.addAttrezzo(a);
			return this;
		}

		public LabirintoBuilder addStanza(String nome) {
			Stanza stanza = new Stanza(nome);
			this.ultimaAggiunta = stanza;
			this.nome2stanza.put(stanza.getNome(), stanza);
			return this;
		}

		public LabirintoBuilder addStanzaMagica(String nome) {
			Stanza stanza = new StanzaMagica(nome);
			this.ultimaAggiunta = stanza;
			this.nome2stanza.put(stanza.getNome(), stanza);
			return this;
		}

		public LabirintoBuilder addStanzaBuia(String nome, String attrezzoPerVedere) {
			Stanza stanza = new StanzaBuia(nome,attrezzoPerVedere);
			this.ultimaAggiunta = stanza;
			this.nome2stanza.put(stanza.getNome(), stanza);
			return this;
		}

		public LabirintoBuilder addStanzaBloccata(String nome, String attrezzoSbloccante, Direzione direzioneBloccata) {
			Stanza stanza = new StanzaBloccata(nome, attrezzoSbloccante, direzioneBloccata);
			this.ultimaAggiunta = stanza;
			this.nome2stanza.put(stanza.getNome(), stanza);
			return this;
		}

		public Labirinto getLabirinto() {
			return this.labirinto;
		}

	}

}
