package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringSchemaTest {

    @Test
    public void testStringSchemaNull() {

        var v = new Validator();
        var schema = v.string();

        var actual1 = schema.minLength(3).isValid(null);
        var actual2 = schema.contains("d").isValid(null);
        var actual3 = schema.minLength(3).contains("d").isValid(null);

        assertTrue(actual1);
        assertTrue(actual2);
        assertTrue(actual3);

    }

    @Test
    public void testStringSchemaRequired() {

        var v = new Validator();
        var schema = v.string();

        var actual1 = schema.required().isValid("dddd");
        var actual2 = schema.required().isValid("");

        assertTrue(actual1);
        assertFalse(actual2);

    }

    @Test
    public void testStringSchemaMinLength() {

        var v = new Validator();
        var schema = v.string();

        var actual1 = schema.minLength(3).isValid("dddd");
        var actual2 = schema.minLength(3).minLength(3).isValid("dddd");
        var actual3 = schema.minLength(1).minLength(3).isValid("d");
        var actual4 = schema.minLength(3).isValid("d");

        assertTrue(actual1);
        assertTrue(actual2);
        assertFalse(actual3);
        assertFalse(actual4);

    }

    @Test
    public void testStringSchemaContains() {

        var v = new Validator();
        var schema = v.string();

        var actual1 = schema.contains("d").isValid("dddd");
        var actual2 = schema.contains("d").contains("b").isValid("dddb");
        var actual3 = schema.contains("d").contains("r").isValid("dddd");
        var actual4 = schema.contains("r").isValid("dddd");

        assertTrue(actual1);
        assertTrue(actual2);
        assertFalse(actual3);
        assertFalse(actual4);

    }

    @Test
    public void testStringSchemaRequiredMinLengthWithContains() {

        var v = new Validator();
        var schema = v.string();

        var actual1 = schema.required().minLength(3).contains("d").isValid("dddd");
        var actual2 = schema.required().minLength(3).contains("r").isValid("dddd");
        var actual3 = schema.required().minLength(3).contains("r").isValid("d");
        var actual4 = schema.required().minLength(3).contains("d").isValid("d");
        var actual5 = schema.required().minLength(3).contains("r").isValid("");

        assertTrue(actual1);
        assertFalse(actual2);
        assertFalse(actual3);
        assertFalse(actual4);
        assertFalse(actual5);

    }

}
