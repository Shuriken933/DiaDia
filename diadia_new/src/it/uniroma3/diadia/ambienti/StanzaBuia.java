package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe StanzaBuia - una stanza in un gioco di ruolo.
 * Se nella stanza non è presente un attrezzo particolare (ad esempio lanterna),
 * la stanza risulterà buia e non sarà possibile avere una sua descrizione.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author studente 
 * @see Stanza
 * @version base
*/

public class StanzaBuia extends Stanza {
	
	private String nomeAttrezzoLuminoso;
    //private Attrezzo[] attrezzi;
	
	/**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public StanzaBuia(String nome, String nomeAttrezzoLuminoso) {
    	super(nome);
    	this.nomeAttrezzoLuminoso = nomeAttrezzoLuminoso;
    }
    
    
    /**
     * Restituisce la descrizione della stanza solo se è presente un oggetto luminoso.
     * @return la descrizione della stanza
     */
    @Override
    public String getDescrizione() {
    	for (Attrezzo attrezzo : super.attrezzi) {
			if(attrezzo != null && attrezzo.getNome() == this.nomeAttrezzoLuminoso) return super.toString();
		}
    	StringBuilder risultato = new StringBuilder();
    	risultato.append("qui c'è un buio pesto");
        return risultato.toString();
    }
    
    
    
    
    
    

}
