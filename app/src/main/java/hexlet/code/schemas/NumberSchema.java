package hexlet.code.schemas;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

@Getter
public class NumberSchema extends BaseSchema<Integer> {

    private final Map<String, Predicate<Integer>> nameCheckToMechanicsCheck = new HashMap<>();

    public NumberSchema() {
        super();
    }

    public NumberSchema required() {
        nameCheckToMechanicsCheck.put("required", Objects::nonNull);
        return this;
    }

    public NumberSchema positive() {
        nameCheckToMechanicsCheck.put("positive", value -> value > 0);
        return this;
    }

    public NumberSchema range(int lowerLimit, int upperLimit) {
        nameCheckToMechanicsCheck.put("range", value -> value >= lowerLimit && value <= upperLimit);
        return this;
    }

}
