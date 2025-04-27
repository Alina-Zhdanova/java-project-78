package hexlet.code.schemas;

import lombok.Getter;

@Getter
public class StringSchema {

    private boolean countRequired;
    private boolean countMinLength;
    private boolean countContains;
    private int length;
    private String substring;

    public StringSchema required() {
        countRequired = true;
        return this;
    }

    public StringSchema minLength(int length) {
        countMinLength = true;
        this.length = length;
        return this;
    }

    public StringSchema contains(String substring) {
        countContains = true;
        this.substring = substring;
        return this;
    }

    public boolean isValid(String value) {

        var isValid = true;

        if (!countRequired && value == null) {
            return true;
        }
        isValid = value != null && !value.isEmpty();

        if (countMinLength && isValid) {
            isValid = value.length() >= getLength();
        }

        if (countContains && isValid) {
            isValid = value.contains(getSubstring());
        }

        return isValid;
    }

}
