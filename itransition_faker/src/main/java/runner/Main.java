package runner;

import service.CsvFakerGenerator;
import service.LocaleRegion;
import service.exception.RegionFakerException;
import service.validator.impl.CountArgumentsValidatorImpl;
import service.validator.impl.CountFakersValidatorImpl;
import service.validator.impl.RegionFakersValidatorImpl;

public class Main {
    public static void main(String[] args) {
        try {
            if (! new CountArgumentsValidatorImpl().validate(args.length)) {
                throw new IllegalArgumentException("The number of command line arguments can be only 2 (count fakers, region name).");
            }
            if (!new CountFakersValidatorImpl().validate(Integer.parseInt(args[0]))) {
                throw new IllegalArgumentException("The args[0] must be greater than 0.");
            }
            if (!new RegionFakersValidatorImpl().validate(args[1])) {
                throw new RegionFakerException("The args[1] can be only: en_US, ru_RU, uk_UA.");
            }

            CsvFakerGenerator generator = new CsvFakerGenerator();

            for (int i = 0; i < Integer.parseInt(args[0]); i++) {
                String s = generator.getFakerToCsvFormat(LocaleRegion.getLocaleRegionByName(args[1]));
                System.out.println(s);
            }
        } catch (IllegalArgumentException | RegionFakerException e) {
            System.out.println(e.getMessage());
        }
    }
}
