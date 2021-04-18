package service.validator;

public interface ParamsValidator<V> {
    boolean validate(V value);
}
