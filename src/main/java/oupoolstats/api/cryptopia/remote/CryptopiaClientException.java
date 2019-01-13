package  oupoolstats.api.cryptopia.remote;

public class CryptopiaClientException extends RuntimeException {
    public CryptopiaClientException(String message) {
        super(message);
    }

    public CryptopiaClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
