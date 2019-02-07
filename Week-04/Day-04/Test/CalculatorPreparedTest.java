import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


// Recommended naming of the class:
// [NameOfTheClassUnderTest + Tests]
public class CalculatorPreparedTest {

    // Recommended naming of the test method:
    // [MethodName_StateUnderTest_ExpectedBehavior]
    //
    // Like:
    // void sum_NegativeNumberAs1stParam_ReturnsZero()
    // void sum_NegativeNumberAs2ndParam_ExceptionThrown ()
    // void sum_SimpleValues_Calculated ()

    List<Integer> initials2 = new ArrayList(Arrays.asList(new Integer[]{5, -4, 3}));

    @Before
    public void beforeMethod(){
        System.out.println("BeforeMethodCalled");
    }
    @BeforeClass
    public static void beforeClassMethod(){
        System.out.println("BeforeClassMethodCalled");
    }
    @After
    public void afterMethod(){
        System.out.println("AfterMethodCalled");
    }
    @AfterClass
    public static void afterClassMethod(){
        System.out.println("AfterClassMethodCalled");
    }


    @Test
    public void emtpyTest(){
        System.out.println("emtpyTest called");
        System.out.println("Initials2: " + initials2.get(0));
    }

    //region testing getSum
    @Test
    public void getSum_InitializedInput_ReturnsSum() {
        // Setup
        // prepare data, environment for the test
        List<Integer> initials = new ArrayList(Arrays.asList(new Integer[]{5, -4, 3}));
        CalculatorPrepared calculator = new CalculatorPrepared(initials);

        // Act
        // use the unit to be tested (interaction with the SUT (System Under Test))
        Integer sum = calculator.getSum();

        // Verify
        // do everything necessary to determine if the expected outcome has been obtained.
        assertEquals((Integer)4, sum);

        // Teardown
        // Lets get back to the original state - not needed here
        System.out.println("getSum_InitializedInput_ReturnsSum called");
    }

    @Test
    public void getSum_EmptyInput_ReturnsZero() {
        // Setup
        // prepare data, environment for the test
        List<Integer> initials = new ArrayList<>();
        CalculatorPrepared calculator = new CalculatorPrepared(initials);

        // Act
        // use the unit to be tested (interaction with the SUT (System Under Test))
        int sum = calculator.getSum();

        // Verify
        // do everything necessary to determine if the expected outcome has been obtained.
        assertEquals(0, sum);

        // Teardown
        // Lets get back to the original state
        // - not needed here
        System.out.println("getSum_EmptyInput_ReturnsZero called");
    }
    //endregion

    //region testing isPositive
    @Test
    public void isPositive_WithPositive_ReturnsTrue(){
        // Setup
        List<Integer> initials = new ArrayList(Arrays.asList(new Integer[]{5, -4, 3}));
        CalculatorPrepared calculator = new CalculatorPrepared(initials);

        // Act
        boolean isPositive = calculator.isPositive(0);

        // Verify
        assertTrue(isPositive);
        System.out.println("isPositive_WithPositive_ReturnsTrue called");
    }

    @Test
    public void isPositive_WithNegative_ReturnsFalse(){
        // Setup
        List<Integer> initials = new ArrayList(Arrays.asList(new Integer[]{5, -4, 3}));
        CalculatorPrepared calculator = new CalculatorPrepared(initials);

        // Act
        boolean isPositive = calculator.isPositive(1);

        // Verify
        assertFalse(isPositive);
        System.out.println("isPositive_WithNegative_ReturnsFalse called");
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void isPositive_WithWrongIndex_ThrowsIndexOutOfBoundsException(){
        // Setup
        List<Integer> initials = new ArrayList(Arrays.asList(new Integer[]{5, -4, 3}));
        CalculatorPrepared calculator = new CalculatorPrepared(initials);

        // Act
        Boolean isPositive = calculator.isPositive(5);
        System.out.println("isPositive_WithWrongIndex_ThrowsIndexOutOfBoundsException called");
    }
    //endregion

    //region testing addNUmber
    @Test
    public void addNumber(){
        List<Integer> initials = new ArrayList(Arrays.asList(new Integer[]{5, -4, 3}));
        CalculatorPrepared calculator = new CalculatorPrepared(initials);

        calculator.addNumber(65);

        Integer result = calculator.getNumbers().get(3);
        assertEquals((Integer)65, result);
        System.out.println("addNumber called");
    }
    //endregion

    //region testing getMaximum
    @Test
    public void getMaximum_OneMaximum_ReturnsMaximum(){
        List<Integer> initials = new ArrayList(Arrays.asList(new Integer[]{5, 2, 3, 2, 3, 2}));
        CalculatorPrepared calculator = new CalculatorPrepared(initials);

        int result = calculator.getMaximumOccurence();

        assertEquals(2, result);
        System.out.println("getMaximum_OneMaximum_ReturnsMaximum called");

        // Simply to check how fields behave here
        initials2.set(0, 50);
        System.out.println("Initials2 changed to 50");
    }

    @Test
    public void getMaximum_MoreMaximum_ReturnsNull(){
        List<Integer> initials = new ArrayList(Arrays.asList(new Integer[]{2, 5, 3, 2, 3, 4, 7}));
        CalculatorPrepared calculator = new CalculatorPrepared(initials);

        Integer result = calculator.getMaximumOccurenceFixed();

        assertNull(result);
        System.out.println("getMaximum_MoreMaximum_ReturnsNull called");
    }
    //endregion
}