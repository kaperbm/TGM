import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Kacper Bohaczyk
 * @version 30-11-2023
 */
public class ExpressionTest {

    @Test
    @DisplayName("Division testen")
    public void testDivide() {
        assertEquals(3.0, new Divide(new Number(9.0), new Number(3.0)).evaluate());
    }

    @Test
    @DisplayName("Multiplikation testen")
    public void testMultiplicate() {
        assertEquals(10.0, new Multiplicate(new Number(2.0), new Number(5.0)).evaluate());
    }

    @Test
    @DisplayName("Max testen")
    public void testMax() {
        assertEquals(9.0, new Max(new Number(3.0), new Number(9.0)).evaluate());
    }

    @Test
    @DisplayName("Min testen")
    public void testMin() {
        assertEquals(3.0, new Min(new Number(3.0), new Number(9.0)).evaluate());
    }

    @Test
    @DisplayName("Addition testen")
    public void testPlus() {
        assertEquals(5.0, new Add(new Number(2.0), new Number(3.0)).evaluate());
    }

    @Test
    @DisplayName("Subtraktion testen")
    public void testMinus() {
        assertEquals("((3.0 ^ 2.0) - 5.0)", new Subtract(new Exponential(new Number(3.0), new Number(2.0)), new Number(5.0)).toString());
    }

    @Test
    @DisplayName("Exponential testen")
    public void testExponential() {
        assertEquals(9.0, new Exponential(new Number(3.0), new Number(2.0)).evaluate());
    }

    @Test
    @DisplayName("Negation testen")
    public void testNegation() {
        assertEquals(-2.0, new Negate(new Number(2)).evaluate());
    }

    @Test
    @DisplayName("Division durch Null testen")
    public void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Divide(new Number(3), new Number(0)).evaluate();
        });
    }

    @Test
    @DisplayName("Negative Wurzel testen")
    public void testExponentialWithNegativeHalf() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Exponential(new Number(6), new Number(-0.5)).evaluate();
        });
    }
    @Test
    @DisplayName("Leere Liste testen")
    public void testEmptyList() {
        assertThrows(IllegalStateException.class, () -> {
            new Max().evaluate();
        });
    }

    @Test
    @DisplayName("StringBuilder testen")
    public void testStringBuild() {
        assertEquals("Min(3.0, 9.0)", new Min(new Number(3.0), new Number(9.0)).toString());
    }
}
