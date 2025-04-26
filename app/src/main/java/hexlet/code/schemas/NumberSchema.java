package hexlet.code.schemas;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class NumberSchema {

    public NumberSchema() {
    }

    private int countRequired;
    private int countPositive;
    private int countRange;
    private int lowerLimit;
    private int upperLimit;
    private final ArrayList<Boolean> repositoryAuditResults = new ArrayList<>();

    public NumberSchema required() {
        countRequired += 1;
        return this;
    }

    public NumberSchema positive() {
        countPositive += 1;
        return this;
    }

    public NumberSchema range(int lowerLimit, int upperLimit) {
        countRange += 1;
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        return this;
    }

    public boolean isValid(Integer value) {

        if (getCountRequired() != 0) {
            repositoryAuditResults.add(value != null);
        }
        if (getCountPositive() != 0) {
            assert value != null;
            repositoryAuditResults.add(value > 0);
        }
        if (getCountRange() != 0) {
            assert value != null;
            repositoryAuditResults.add(value >= getLowerLimit() && value <= getUpperLimit());
        }

        return !getRepositoryAuditResults().contains(false);
    }
}
