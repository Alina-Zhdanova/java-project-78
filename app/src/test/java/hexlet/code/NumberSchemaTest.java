package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberSchemaTest {

    @Test
    public void testNumberSchemaNull() {

        var v = new Validator();
        var schema = v.number();

        var actual1 = schema.positive().isValid(null);
        var actual2 = schema.range(5, 10).isValid(null);
        var actual3 = schema.positive().range(5, 10).isValid(null);

        assertTrue(actual1);
        assertTrue(actual2);
        assertTrue(actual3);

    }

    @Test
    public void testNumberSchemaRequired() {

        var v = new Validator();
        var schema = v.number();

        var actual1 = schema.required().isValid(10);

        assertTrue(actual1);

    }

    @Test
    public void testNumberSchemaPositive() {

        var v = new Validator();
        var schema = v.number();

        var actual1 = schema.positive().isValid(10);
        var actual2 = schema.positive().isValid(-10);

        assertTrue(actual1);
        assertFalse(actual2);

    }

    @Test
    public void testNumberSchemaRange() {

        var v = new Validator();
        var schema = v.number();

        var actual1 = schema.range(5, 10).isValid(5);
        var actual2 = schema.range(5, 10).isValid(10);
        var actual3 = schema.range(5, 10).isValid(7);
        var actual4 = schema.range(5, 10)
            .range(4, 11).isValid(7);

        var actual5 = schema.range(3, 10)
            .range(5, 10).isValid(4);
        var actual6 = schema.range(5, 10).isValid(4);
        var actual7 = schema.range(5, 10).isValid(11);
        var actual8 = schema.range(5, 10).isValid(21);

        assertTrue(actual1);
        assertTrue(actual2);
        assertTrue(actual3);
        assertTrue(actual4);

        assertFalse(actual5);
        assertFalse(actual6);
        assertFalse(actual7);
        assertFalse(actual8);

    }

    @Test
    public void testNumberSchemaRequiredPositiveRange() {

        var v = new Validator();
        var schema = v.number();

        var actual1 = schema.required().positive().range(5, 10).isValid(5);
        var actual2 = schema.required().positive().range(6, 10).isValid(5);
        var actual3 = schema.required().positive().range(-10, -5).isValid(-5);
        var actual4 = schema.required().positive().range(5, 10).isValid(-5);

        assertTrue(actual1);
        assertFalse(actual2);
        assertFalse(actual3);
        assertFalse(actual4);

    }

}
