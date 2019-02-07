import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class isAnagramTest {
    @Before
    public void beforeMethod() {
        System.out.println("TEST");
    }

    @Test
    public void areInputsAnagrams_InitializedWithEmptyInputs_ReturnsFalse() {
        assertFalse(new isAnagram("", "").areInputsAnagrams());
    }

    @Test
    public void areInputsAnagrams_InitializedWithOneLetterInputs_ReturnsTrueOrFalse() {
        assertTrue(new isAnagram("a", "a").areInputsAnagrams());
        assertTrue(new isAnagram("C", "C").areInputsAnagrams());
        assertFalse(new isAnagram("a", "A").areInputsAnagrams());
        assertFalse(new isAnagram("a", "c").areInputsAnagrams());
    }

    @Test
    public void areInputsAnagrams_InitializedWithStringInputs_ReturnsTrueOrFalse() {
        assertTrue(new isAnagram("dog", "god").areInputsAnagrams());
        assertTrue(new isAnagram("god", "dog").areInputsAnagrams());
        assertTrue(new isAnagram("alucard", "dracula").areInputsAnagrams());
        assertTrue(new isAnagram("AAa", "aAA").areInputsAnagrams());
        assertFalse(new isAnagram("BBBB", "BBBb").areInputsAnagrams());
        assertFalse(new isAnagram("qwertyuiop", "poiuytrew").areInputsAnagrams());
        assertFalse(new isAnagram("345", "542").areInputsAnagrams());
        assertFalse(new isAnagram("AAAAA", "aaaaa").areInputsAnagrams());
    }

    @Test
    public void areInputsAnagrams_InitializedWithSpecialInputs_ReturnsTrueOrFalse() {
        assertTrue(new isAnagram("!!!", "!!!").areInputsAnagrams());
        assertTrue(new isAnagram("'\"", "\"'").areInputsAnagrams());
        assertFalse(new isAnagram("?a", "A?").areInputsAnagrams());
        assertFalse(new isAnagram("'''", "''").areInputsAnagrams());
    }
}
