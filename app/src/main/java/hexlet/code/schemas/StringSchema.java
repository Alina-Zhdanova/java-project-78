package hexlet.code.schemas;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class StringSchema {

    public StringSchema() {
    }

    private int countRequired;
    private int countMinLength;
    private int countContains;
    private int length;
    private String substring;
    private final ArrayList<Boolean> repositoryAuditResults = new ArrayList<>();

    public StringSchema required() {
        countRequired += 1;
        return this;
    }

    public StringSchema minLength(int length) {
        countMinLength += 1;
        this.length = length;
        return this;
    }

    public StringSchema contains(String substring) {
        countContains += 1;
        this.substring = substring;
        return this;
    }

    public boolean isValid(String value) {

        if (getCountRequired() != 0) {
            repositoryAuditResults.add(!(value == null) && !value.isEmpty());
        }
        if (getCountMinLength() != 0) {
            assert value != null;
            repositoryAuditResults.add(value.length() >= getLength());
        }


        if (getCountContains() != 0) {
            assert value != null;
            repositoryAuditResults.add(value.contains(getSubstring()));
        }

        return !getRepositoryAuditResults().contains(false);
    }
}
