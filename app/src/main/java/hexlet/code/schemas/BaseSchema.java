package hexlet.code.schemas;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.function.Predicate;

@Getter
@NoArgsConstructor
public abstract class BaseSchema<T> {

    private Map<String, Predicate<T>> nameCheckToMechanicsCheck;

    public boolean isValid(T checkedValue) {

        nameCheckToMechanicsCheck = getNameCheckToMechanicsCheck();

        if (!getNameCheckToMechanicsCheck().containsKey("required") && checkedValue == null) {
            return true;
        }

        var finalVerificationRepository = getNameCheckToMechanicsCheck().values();
        var isValid = true;

        for (var check : finalVerificationRepository) {
            isValid = isValid && check.test(checkedValue);
        }

        return isValid;

    }

}
