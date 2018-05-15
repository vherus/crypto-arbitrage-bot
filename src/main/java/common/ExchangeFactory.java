package common;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.okcoin.OkCoinExchange;

final class ExchangeFactory {
    static Exchange make(ExchangeContext context) {
        ExchangeSpecification spec = new ExchangeSpecification(context.getExchange());

        spec.setApiKey(context.getApiKey());
        spec.setSecretKey(context.getSecret());

        if (context.getExchange().equals(OkCoinExchange.class)) {
            spec.setUserName(context.getUsername());
        }

        return org.knowm.xchange.ExchangeFactory.INSTANCE.createExchange(spec);
    }
}
