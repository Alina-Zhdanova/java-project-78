package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void testMapSchemaShape() {

        var v = new Validator();
        var schema = v.map();

        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required());
        schemas.put("lastName", v.string().required().minLength(2));
        schema.shape(schemas);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        var actual1 = schema.isValid(human1);

        assertTrue(actual1);

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        schema.isValid(human2);
        var actual2 = schema.isValid(human2);

        assertFalse(actual2);

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        var actual3 = schema.isValid(human3);

        assertFalse(actual3);

        Map<String, String> human4 = new HashMap<>();
        human4.put("firstName", "Anna");
        human4.put("lastName", "");
        var actual4 = schema.isValid(human4);

        assertFalse(actual4);

    }

}
