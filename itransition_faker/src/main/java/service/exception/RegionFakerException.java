package service.exception;

public class RegionFakerException extends Exception {
    public RegionFakerException() {
    }

    public RegionFakerException(String message) {
        super(message);
    }

    public RegionFakerException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegionFakerException(Throwable cause) {
        super(cause);
    }

    public RegionFakerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
