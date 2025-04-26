package hexlet.code;


import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

public class Validator {

    public Validator() {
    }

    public StringSchema string() {
        return new StringSchema();
    }

    public NumberSchema number() {
        return new NumberSchema();
    }

    //Вызов метода string() создает схему StringSchema.
    //Эта схема используется для валидации строковых данных.
    //После создания схемы можно конфигурировать ее,
    //добавляя различные ограничения при помощи вызова методов на объекте StringSchema.

}
