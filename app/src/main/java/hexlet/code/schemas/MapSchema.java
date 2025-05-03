package hexlet.code.schemas;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

@Getter
public class MapSchema extends BaseSchema<Map<String, String>> {

    private final Map<String, Predicate<Map<String, String>>> verificationRepository = new HashMap<>();

    public MapSchema required() {
        verificationRepository.put("required", Objects::nonNull);
        return this;
    }

    public MapSchema sizeof(int mapSize) {
        verificationRepository.put("sizeof", value -> value.size() >= mapSize);
        return this;
    }

}
