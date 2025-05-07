package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public final class MapSchema extends BaseSchema<Map<String, String>> {

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

                    if (!isValid) {
                        return false;
                    }

                    var valueForVerification = entry.getValue();
                    var check = schemas.get(entry.getKey());
                    isValid = check.isValid(valueForVerification);

                }

                return isValid;

            });

    }

}
