package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        nameCheckToMechanicsCheck.put("required", value -> value != null && !value.isEmpty());
        return this;
    }

    public StringSchema minLength(int length) {
        nameCheckToMechanicsCheck.put("minLength", value -> value == null || value.length() >= length);
        return this;
    }

    public StringSchema contains(String substring) {
        nameCheckToMechanicsCheck.put("contains", value -> value.contains(substring));
        return this;
    }

}
