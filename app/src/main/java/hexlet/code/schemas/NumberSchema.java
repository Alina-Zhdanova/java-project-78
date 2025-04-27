package hexlet.code.schemas;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class NumberSchema {

    public NumberSchema() {
    }

    private boolean countRequired;
    private boolean countPositive;
    private boolean countRange;
    private int lowerLimit;
    private int upperLimit;

    public NumberSchema required() {
        countRequired = true;
        return this;
    }

    public NumberSchema positive() {
        countPositive = true;
        return this;
    }

    public NumberSchema range(int lowerLimit, int upperLimit) {
        countRange = true;
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        return this;
    }

    public boolean isValid(Integer value) {

        var isValid = true;

        if (!countRequired && value == null) {
            return true;
        }
        isValid = value != null;

        if (countPositive && isValid) {
            isValid = value > 0;
        }

        if (countRange && isValid) {
            isValid = value >= getLowerLimit() && value <= getUpperLimit();
        }

        return isValid;

    }

}
