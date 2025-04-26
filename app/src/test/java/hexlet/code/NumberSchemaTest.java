package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberSchemaTest {

        @Test
        public void testNumberSchemaRequired() {

            var v = new Validator();
            var actual1 = v.number().required().isValid(10);

            var actual2 = v.number().required().isValid(null);

            assertTrue(actual1);

            assertFalse(actual2);
        }

        @Test
        public void testNumberSchemaPositive() {

            var v = new Validator();
            var actual1 = v.number().positive().isValid(10);

            var actual2 = v.number().positive().isValid(-10);

            assertTrue(actual1);

            assertFalse(actual2);
        }

        @Test
        public void testNumberSchemaRange() {

            var v = new Validator();
            var actual1 = v.number().range(5, 10).isValid(5);
            var actual2 = v.number().range(5, 10).isValid(10);
            var actual3 = v.number().range(5, 10).isValid(7);

            var actual4 = v.number().range(5, 10).isValid(4);
            var actual5 = v.number().range(5, 10).isValid(11);
            var actual6 = v.number().range(5, 10).isValid(21);

            assertTrue(actual1);
            assertTrue(actual2);
            assertTrue(actual3);

            assertFalse(actual4);
            assertFalse(actual5);
            assertFalse(actual6);
        }
    //
    //    @Test
    //    public void testStringSchemaRequiredMinLengthWithContains() {
    //
    //        var v = new Validator();
    //        var actual1 = v.string().required().minLength(3).contains("d").isValid("dddd");
    //
    //        var actual2 = v.string().required().minLength(3).contains("r").isValid("dddd");
    //        var actual3 = v.string().required().minLength(3).contains("r").isValid("d");
    //        var actual4 = v.string().required().minLength(3).contains("d").isValid("d");
    //
    //        var actual5 = v.string().required().minLength(3).contains("r").isValid("");
    ////        var actual6 = v.string().required().minLength(3).contains("r").isValid(null);
    //
    //
    //        assertTrue(actual1);
    //
    //        assertFalse(actual2);
    //        assertFalse(actual3);
    //        assertFalse(actual4);
    //
    //        assertFalse(actual5);
    ////        assertFalse(actual6);
    //    }
}
