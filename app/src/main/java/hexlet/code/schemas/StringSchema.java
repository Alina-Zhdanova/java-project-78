package hexlet.code.schemas;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

@Getter
public class StringSchema extends BaseSchema<String> {

    private final Map<String, Predicate<String>> verificationRepository = new HashMap<>();

    public StringSchema required() {
        verificationRepository.put("required", value -> value != null && !value.isEmpty());
        return this;
    }

    public StringSchema minLength(int length) {
        verificationRepository.put("minLength", value -> value.length() >= length);
        return this;
    }

    public StringSchema contains(String substring) {
        verificationRepository.put("contains", value -> value.contains(substring));
        return this;
    }

}
