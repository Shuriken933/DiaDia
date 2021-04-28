package it.uniroma3.diadia.ambienti;


import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza{
	
	private String nomeDirezioneBloccata;
	private String nomeAttrezzoSbloccaDirezione;
	
	public StanzaBloccata(String nome, String nomeDirezioneBloccata, String nomeAttrezzoSbloccaDirezione) {
		super(nome);
		this.nomeDirezioneBloccata = nomeDirezioneBloccata;
		this.nomeAttrezzoSbloccaDirezione = nomeAttrezzoSbloccaDirezione;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {      
        
		Stanza stanza = null;
		for(int i=0; i<super.numeroStanzeAdiacenti; i++) {
			if (super.direzioni[i].equals(direzione) && direzione != this.nomeDirezioneBloccata)
        		stanza = this.stanzeAdiacenti[i];
			else if (super.direzioni[i].equals(direzione) && direzione == this.nomeDirezioneBloccata) {
				if(super.hasAttrezzo(nomeAttrezzoSbloccaDirezione)) {
					stanza = super.stanzeAdiacenti[i];
					super.io.mostraMessaggio("direzione sbloccata");
                }
				else {
					super.io.mostraMessaggio("direzione bloccata");
					super.getNome();
					}
			}
		}
        return stanza;
	}
	


	
    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
	@Override
    public String getDescrizione() {
        return this.toString();
    }
	
	/**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    public String toString() {
    	StringBuilder risultato = new StringBuilder();
    	risultato.append(super.getNome());
    	risultato.append("\nUscite: ");
    	for (String direzione : super.direzioni)
    		if (direzione != null && direzione != this.nomeDirezioneBloccata) {
    			risultato.append(" " + direzione);
    		}
    		else if(direzione != null && direzione == this.nomeDirezioneBloccata) {
    			risultato.append(" " + direzione + "bloccato");
    		}
    	risultato.append("\nAttrezzi nella stanza: ");
    	for (Attrezzo attrezzo : super.getAttrezzi()) {
    		if(attrezzo != null)
    			risultato.append(attrezzo.toString()+" ");
    	}
    	risultato.append("\nAttrezzo sbloccante: " + this.nomeAttrezzoSbloccaDirezione);
    	return risultato.toString();
    }

	
	
}
