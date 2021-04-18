package service;

public enum LocaleRegion {
    US("en_US"), RU("ru_RU"), UKR("uk_UA");

    private String title;

    LocaleRegion(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static LocaleRegion getLocaleRegionByName(String regionName) {
        switch (regionName) {
            case "en_US" : {
                return US;
            }
            case "ru_RU" : {
                return RU;
            }
            case "uk_UA" : {
                return UKR;
            }
        }

        return US;
    }
}
