import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class CountLettersTest {

    @Before
    public void beforeMethod() {
        System.out.println("TEST");
    }

    @Test
    public void countLetters_InitializedWithEmptyInput_ReturnsEmptyDictionary() {
        HashMap<Character, Integer> map = CountLetters.countLetters("");

        assertTrue(map.isEmpty());
    }

    @Test
    public void countLetters_InitializedWithOneLetterInput_ReturnsSingleHashmap() {
        HashMap<Character, Integer> map = CountLetters.countLetters("a");

        assertFalse(map.isEmpty());
        assertTrue(map.containsKey('a'));
        assertTrue(map.get('a') == 1);
    }

    @Test
    public void countLetters_InitializedWithStringConsistingOneLetter_ReturnsSingleHashmap() {
        HashMap<Character, Integer> map = CountLetters.countLetters("AAAAA");

        assertFalse(map.isEmpty());
        assertTrue(map.containsKey('A'));
        assertTrue(map.get('A') == 5);
    }

    @Test
    public void countLetters_InitializedWithString_ReturnHashmap() {
        HashMap<Character, Integer> map = CountLetters.countLetters("AaBaAbBaUbBuUuAa");

        assertFalse(map.isEmpty());
        assertTrue(map.containsKey('A'));
        assertTrue(map.containsKey('a'));
        assertTrue(map.containsKey('B'));
        assertTrue(map.containsKey('b'));
        assertTrue(map.containsKey('U'));
        assertTrue(map.containsKey('u'));
        assertTrue(map.get('A') == 3);
        assertTrue(map.get('B') == 3);
        assertTrue(map.get('U') == 2);
        assertTrue(map.get('a') == 4);
        assertTrue(map.get('b') == 2);
        assertTrue(map.get('u') == 2);
    }
}
