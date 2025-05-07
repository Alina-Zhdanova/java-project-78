package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {

    protected Map<String, Predicate<T>> nameCheckToMechanicsCheck = new HashMap<>();

    public boolean isValid(T checkedValue) {

        if (!nameCheckToMechanicsCheck.containsKey("required") && checkedValue == null) {
            return true;
        }

        var checks = nameCheckToMechanicsCheck.values();
        var isValid = true;

        for (var check : checks) {
            isValid = isValid && check.test(checkedValue);
        }

        return isValid;

    }

}
