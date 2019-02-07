import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApplesTest {
    @Before
    public void beforeMethod() {
        System.out.println("TEST: Method getApple() of Apples class returns \"apple\"");
    }

    @Test
    public void getApple_InitializedInput_ReturnsApple() {
        assertEquals("apple", new Apples().getApple());
    }
}
