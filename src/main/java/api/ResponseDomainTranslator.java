package api;

import api.exception.ResponseNotSupportedException;
import api.okex.domain.Hydration.exception.HydrationException;

public interface ResponseDomainTranslator {
    DomainEntity translate(ApiResponse response) throws HydrationException, ResponseNotSupportedException;
}
