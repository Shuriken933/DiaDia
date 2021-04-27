package it.uniroma3.diadia.ambienti;

//import it.uniroma3.diadia.IO;
//import it.uniroma3.diadia.IOConsole;

public class StanzaBuia extends Stanza {
	
	private static final String ATTREZZO_LUCE = "lanterna";
	
//	private IO io;
	private String nomeAttrezzoLuce;
	
	public StanzaBuia(String nome) {
		this(nome, ATTREZZO_LUCE);
	}

	public StanzaBuia(String nome, String attrezzoLuce) {
		super(nome);
		this.nomeAttrezzoLuce = attrezzoLuce;
	}

	@Override
	public String getDescrizione() {
		if(super.hasAttrezzo(this.nomeAttrezzoLuce))
			return super.getDescrizione();
		
		else 
			return "Qui c'è un buio pesto";		
	}
}
