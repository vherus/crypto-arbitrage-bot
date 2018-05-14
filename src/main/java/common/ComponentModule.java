package common;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import org.knowm.xchange.bittrex.BittrexExchange;
import org.knowm.xchange.okcoin.OkCoinExchange;

public class ComponentModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Component.class)
            .annotatedWith(Names.named("Okex"))
            .toInstance(new ApiComponent(new ExchangeContext(OkCoinExchange.class.getName())));

        bind(Component.class)
            .annotatedWith(Names.named("Bittrex"))
            .toInstance(new ApiComponent(new ExchangeContext(BittrexExchange.class.getName())));
    }
}
