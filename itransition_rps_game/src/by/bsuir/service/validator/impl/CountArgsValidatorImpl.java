package by.bsuir.service.validator.impl;

import by.bsuir.service.validator.GameValidator;

public class CountArgsValidatorImpl implements GameValidator {
    @Override
    public boolean validate(String[] args) {
        return args != null && (args.length > 2 && args.length % 2 == 1);
    }
}
