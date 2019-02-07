import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class CalculatorPreparedTest {

    @Before
    public void beforeMethod() {
        System.out.println("TEST");
    }

    @Test
    public void getSum_InitializedWithObscureInputs_ReturnsNull() {
        assertNull(new CalculatorPrepared(new ArrayList<>() {{ add(null);}}).getSum());
        assertNull(new CalculatorPrepared(new ArrayList<>() {{ add(null); add(-0);}}).getSum());
        assertNull(new CalculatorPrepared(new ArrayList<>() {{}}).getSum());
    }

    @Test
    public void getSum_InitializedWithOneInput_ReturnsInput() {
        assertEquals((Integer) 4, new CalculatorPrepared(new ArrayList<>() {{ add(4);}}).getSum());
        assertEquals((Integer) 999999999, new CalculatorPrepared(new ArrayList<>() {{ add(999999999);}}).getSum());
        assertEquals((Integer) 0, new CalculatorPrepared(new ArrayList<>() {{ add(0);}}).getSum());
        assertEquals((Integer) (-5), new CalculatorPrepared(new ArrayList<>() {{ add(-5);}}).getSum());
    }

    @Test
    public void getSum_InitializedWithMultipleInputs_ReturnsSum() {
        assertEquals(
                (Integer)Arrays.stream(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
                        .mapToInt(Integer::intValue)
                        .sum(),
                new CalculatorPrepared(new ArrayList<>() {{
                    for (int i = 1; i < 11; i++) {
                        add(i);
                    }
                }}).getSum());

        assertEquals(
                (Integer)Arrays.stream(new Integer[] {4328974, 4395, -34282, 895, 0, 1, -723434, 3248})
                        .mapToInt(Integer::intValue)
                        .sum(),
                new CalculatorPrepared(new ArrayList<>() {{
                    add(4328974);
                    add(4395);
                    add(-34282);
                    add(895);
                    add(0);
                    add(1);
                    add(-723434);
                    add(3248);
                }}).getSum());
    }
}