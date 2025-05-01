package hexlet.code.schemas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.function.Predicate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BaseSchema<T> {

    private T checkedValue;
    private Map<String, Predicate<T>> verificationRepository;

    public boolean isValid(T valueForVerification) {

        checkedValue = valueForVerification;

        if (!getVerificationRepository().containsKey("required") && checkedValue == null) {
            return true;
        }

        var finalVerificationRepository = getVerificationRepository().values();
        var isValid = true;

        for (var check : finalVerificationRepository) {
            isValid = isValid && check.test(checkedValue);
        }

        return isValid;

    }

}
