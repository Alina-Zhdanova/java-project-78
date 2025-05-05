package hexlet.code.schemas;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

@Getter
public class MapSchema extends BaseSchema<Map<String, String>> {

    private final Map<String, Predicate<Map<String, String>>> nameCheckToMechanicsCheck = new HashMap<>();

    public MapSchema() {
        super();
    }

    public MapSchema required() {
        nameCheckToMechanicsCheck.put("required", Objects::nonNull);
        return this;
    }

    public MapSchema sizeof(int mapSize) {
        nameCheckToMechanicsCheck.put("sizeof", value -> value.size() >= mapSize);
        return this;
    }

    public void shape(Map<String, BaseSchema<String>> schemas) {

        nameCheckToMechanicsCheck.put("shape",
            value -> {
                var isValid = true;
                var entries = value.entrySet();

                for (var entry : entries) {

                    var valueForVerification = entry.getValue();

                    if (valueForVerification == null || valueForVerification.isEmpty()) {
                        return false;
                    }

                    var check = schemas.get(entry.getKey());
                    isValid = isValid && check.isValid(valueForVerification);

                }

                return isValid;

            });

    }

}
