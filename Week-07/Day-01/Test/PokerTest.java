import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class PokerTest {

    @Before
    public void beforeMethod() {
        System.out.println("TEST");
    }

    @Test
    public void checkIfTie_InitializedWithEmptyHand_ReturnTrue() {
        assertEquals(new PokerHand("").getPokerhand(), new PokerHand("").getPokerhand());
    }

    @Test
    public void checkIfTie_InitializedWithSameHand_ReturnTrue() {
        assertEquals(new PokerHand("2H3D5S9CKD").getPokerhand(),
                new PokerHand("2H3D5S9CKD").getPokerhand());
    }

    @Test
    public void checkIfWhiteWins_InitializedWithNumbers_ReturnTrue() {
        assertTrue(new PokerHand("2H3D5S9C7D").determineWinner(new PokerHand("2H3D5S7C8D")));
        assertTrue(new PokerHand("5H4D6S7C7D").determineWinner(new PokerHand("4H3D5S6C6D")));
        assertTrue(new PokerHand("9H9D9S9C9D").determineWinner(new PokerHand("8H8D8S8C8D")));
    }

    @Test
    public void checkIfBlackWins_InitializedWithSymbols_ReturnFalse() {
        assertFalse(new PokerHand("2H3D5S9C8D").determineWinner(new PokerHand("2H3D5SAC8D")));
        assertFalse(new PokerHand("5H4D6S7C2D").determineWinner(new PokerHand("4HJD5S6CQD")));
        assertFalse(new PokerHand("9H4DKSJC5D").determineWinner(new PokerHand("8HADKSJC4D")));
    }

    @Test
    public void checkIfWhiteWins_InitializedWithPairs_ReturnTrue() {
        assertTrue(new PokerHand("2H2D5S9C9D").determineWinner(new PokerHand("2H3D3SAC2D")));
        assertTrue(new PokerHand("AHAD4S4C4D").determineWinner(new PokerHand("4HJD5S6C6D")));
        assertTrue(new PokerHand("KHKD4S2C1D").determineWinner(new PokerHand("JHJD8S8C8D")));
    }

    @Test
    public void checkIfBlackWins_InitializedWithPairs_ReturnFalse() {
        assertFalse(new PokerHand("2H2D5S9C9D").determineWinner(new PokerHand("2H3D3SACAD")));
        assertFalse(new PokerHand("KHKD4S4C4D").determineWinner(new PokerHand("4HJD5SACAD")));
        assertFalse(new PokerHand("QHQD4S2C1D").determineWinner(new PokerHand("JHJD8SKCKD")));
    }

    @Test
    public void checkIfWhiteWins_InitializedWithTwoPairs_ReturnTrue() {
        assertTrue(new PokerHand("2H2D5S9C9D").determineWinner(new PokerHand("2H3D5SACAD")));
        //assertTrue(new PokerHand("AHAD4S4C4D").determineWinner(new PokerHand("4HJD5S6C6D")));
        //assertTrue(new PokerHand("KHKD4S2C1D").determineWinner(new PokerHand("JHJD8S8C8D")));
    }
}