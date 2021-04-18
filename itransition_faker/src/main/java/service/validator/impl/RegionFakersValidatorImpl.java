package service.validator.impl;

import service.LocaleRegion;
import service.validator.ParamsValidator;

public class RegionFakersValidatorImpl implements ParamsValidator<String> {
    @Override
    public boolean validate(String value) {
        for (LocaleRegion locale : LocaleRegion.values()) {
            if (locale.getTitle().equals(value)) {
                return true;
            }
        }

        return false;
    }
}
