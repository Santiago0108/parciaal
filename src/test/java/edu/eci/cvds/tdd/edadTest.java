package edu.eci.cvds.tdd;

import edu.eci.cvds.tdd.registry.*;


import static org.junit.Assert.*;
import org.junit.Test;


public class edadTest {
    private AgeCheker ageCheker= new AgeCheker();

    @Test
    public void testEsMenor() {
        assertTrue(ageCheker.isMinor(10));
    }

    @Test
    public void testEsNoMenor() {
        assertFalse(ageCheker.isMinor(25));
    }

    @Test
    public void testEsNoMenorNegativo() {
        assertFalse(ageCheker.isMinor(-5));
    }
}


