package service.validator.impl;

import service.validator.ParamsValidator;

public class CountArgumentsValidatorImpl implements ParamsValidator<Integer>  {
    @Override
    public boolean validate(Integer value) {
        return value != null && value == 2;
    }
}
