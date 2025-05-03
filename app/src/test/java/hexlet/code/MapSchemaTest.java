package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapSchemaTest {

    @Test
    public void testMapSchemaNull() {

        var v = new Validator();
        var schema = v.map();

        var actual1 = schema.isValid(null);
        var actual2 = schema.sizeof(3).isValid(null);

        assertTrue(actual1);
        assertTrue(actual2);

    }

    @Test
    public void testMapSchemaRequired() {

        var v = new Validator();
        var schema = v.map();

        var data = new HashMap<String, String>();
        var actual1 = schema.required().isValid(data);

        data.put("key1", "value1");
        var actual2 = schema.required().isValid(data);

        assertTrue(actual1);
        assertTrue(actual2);

    }

    @Test
    public void testMapSchemaSizeOf() {

        var v = new Validator();
        var schema = v.map();

        var data = new HashMap<String, String>();

        data.put("key1", "value1");
        var actual1 = schema.sizeof(2).isValid(data);

        data.put("key2", "value2");
        var actual2 = schema.sizeof(2).isValid(data);

        assertFalse(actual1);
        assertTrue(actual2);

    }

    @Test
    public void testMapSchemaRequiredSizeOf() {

        var v = new Validator();
        var schema = v.map();

        var data = new HashMap<String, String>();
        var actual1 = schema.required().isValid(data);

        data.put("key1", "value1");
        var actual2 = schema.required().isValid(data);
        var actual3 = schema.required().sizeof(2).isValid(data);

        data.put("key2", "value2");

        var actual4 = schema.required().sizeof(2).isValid(data);

        assertTrue(actual1);
        assertTrue(actual2);
        assertFalse(actual3);
        assertTrue(actual4);

    }

}
