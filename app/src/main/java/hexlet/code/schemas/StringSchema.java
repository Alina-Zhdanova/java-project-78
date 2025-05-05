package hexlet.code.schemas;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

@Getter
public final class StringSchema extends BaseSchema<String> {

    private final Map<String, Predicate<String>> nameCheckToMechanicsCheck = new HashMap<>();

    public StringSchema() {
        super();
    }

    public StringSchema required() {
        nameCheckToMechanicsCheck.put("required", value -> value != null && !value.isEmpty());
        return this;
    }

    public StringSchema minLength(int length) {
        nameCheckToMechanicsCheck.put("minLength", value -> value.length() >= length);
        return this;
    }

    public StringSchema contains(String substring) {
        nameCheckToMechanicsCheck.put("contains", value -> value.contains(substring));
        return this;
    }

}
