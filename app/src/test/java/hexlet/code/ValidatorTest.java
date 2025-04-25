package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {

    @Test
    public void testStringSchemaRequired() {

        var v = new Validator();
        var actual1 = v.string().required().isValid("dddd");

        var actual2 = v.string().required().isValid(null);
        var actual3 = v.string().required().isValid("");

        assertTrue(actual1);

        assertFalse(actual2);
        assertFalse(actual3);
    }

    @Test
    public void testStringSchemaMinLength() {

        var v = new Validator();
        var actual1 = v.string().minLength(3).isValid("dddd");

        var actual2 = v.string().minLength(3).isValid("d");

        assertTrue(actual1);

        assertFalse(actual2);
    }

    @Test
    public void testStringSchemaContains() {

        var v = new Validator();
        var actual1 = v.string().contains("d").isValid("dddd");

        var actual2 = v.string().contains("r").isValid("dddd");

        assertTrue(actual1);

        assertFalse(actual2);
    }

    @Test
    public void testStringSchemaRequiredMinLengthWithContains() {

        var v = new Validator();
        var actual1 = v.string().required().minLength(3).contains("d").isValid("dddd");

        var actual2 = v.string().required().minLength(3).contains("r").isValid("dddd");
        var actual3 = v.string().required().minLength(3).contains("r").isValid("d");
        var actual4 = v.string().required().minLength(3).contains("d").isValid("d");

        var actual5 = v.string().required().minLength(3).contains("r").isValid("");
//        var actual6 = v.string().required().minLength(3).contains("r").isValid(null);


        assertTrue(actual1);

        assertFalse(actual2);
        assertFalse(actual3);
        assertFalse(actual4);

        assertFalse(actual5);
//        assertFalse(actual6);
    }
}
