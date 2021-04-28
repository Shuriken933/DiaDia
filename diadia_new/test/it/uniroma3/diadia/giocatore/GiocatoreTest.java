package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

 

import org.junit.Before;
import org.junit.Test;


public class GiocatoreTest {
    
    private Giocatore giocatore;
    public final static int CFU = 3;
    
    @Before
    public void setUp() {
        this.giocatore = new Giocatore();
        this.giocatore.setCfu(CFU);
    }
    

    @Test
    public void testDecrementaCfu() {
        this.giocatore.decreasesCfu(CFU);
        assertEquals(2, this.giocatore.getCfu());
    }

}
