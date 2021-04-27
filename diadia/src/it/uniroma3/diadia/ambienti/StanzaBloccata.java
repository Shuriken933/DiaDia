//package it.uniroma3.diadia.ambienti;
//
//public class StanzaBloccata extends Stanza {
//
//	private static final String ATTREZZO_SBLOCCANTE = "passepartout";
//	private static final String DIREZIONE_BLOCCATA = "est";
//	
//	private String nomeAttrezzoSbloccante;
//	private String nomeDirezioneBloccata;
//
//	public StanzaBloccata(String nome) {
//		this(nome, ATTREZZO_SBLOCCANTE, DIREZIONE_BLOCCATA);
//	}
//
//	public StanzaBloccata(String nome, String attrezzoParticolare, String direzioneBloccata) {
//		
//		super(nome);
//		this.nomeAttrezzoSbloccante = attrezzoParticolare;
//		this.nomeDirezioneBloccata = direzioneBloccata;
//	}
//	
//	@Override
//	public Stanza getStanzaAdiacente(String dir) {
//		
//		if(dir.equals(this.nomeDirezioneBloccata) && !this.hasAttrezzo(this.nomeAttrezzoSbloccante))
//			return this;
//		
//		else 
//			return super.getStanzaAdiacente(dir);
//	}
//	
//	@Override
//	public String getDescrizione() {
//		if(this.getStanzaAdiacente(this.nomeDirezioneBloccata) && this.hasAttrezzo(this.nomeAttrezzoSbloccante)) {
//			return "Senza " + this.nomeAttrezzoSbloccante + "non puoi aprire la porta in quella direzione";
//		}
//		else return super.getDescrizione();
//			
//		
//		
//	}
//}
