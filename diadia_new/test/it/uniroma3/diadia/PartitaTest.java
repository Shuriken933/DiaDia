package it.uniroma3.diadia;

 

import static org.junit.Assert.*;

 

import org.junit.Before;
import org.junit.Test;

 

public class PartitaTest {
    
    private Partita partita;
    
    @Before
    public void setUp() {
        this.partita = new Partita();
    }

 

    @Test
    public void testIsFinita_CFU() {
        this.partita.getGiocatore().setCfu(0);
        assertTrue(this.partita.isFinita());
    }
    
    @Test
    public void testIsFinita_vinta() {
        this.partita.setStanzaCorrente(this.partita.getStanzaCorrente().getStanzaAdiacente("nord"));
        assertTrue(this.partita.isFinita());
    }
    
    @Test
    public void testIsFinita_Finita() {
        this.partita.setFinita();
        assertTrue(this.partita.isFinita());
    }

 

}