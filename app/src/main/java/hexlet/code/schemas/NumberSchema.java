package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        nameCheckToMechanicsCheck.put("required", Objects::nonNull);
        return this;
    }

    public NumberSchema positive() {
        nameCheckToMechanicsCheck.put("positive", value -> value == null || value > 0);
        return this;
    }

    public NumberSchema range(int lowerLimit, int upperLimit) {
        nameCheckToMechanicsCheck.put("range", value -> value >= lowerLimit && value <= upperLimit);
        return this;
    }

}
