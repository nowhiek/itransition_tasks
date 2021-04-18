package by.bsuir.service.validator.impl;

import by.bsuir.service.validator.GameValidator;
import java.util.Arrays;

public class DuplicateArgsValidatorImpl implements GameValidator {
    @Override
    public boolean validate(String[] args) {
        return Arrays.stream(args).distinct().count() == args.length;
    }
}
