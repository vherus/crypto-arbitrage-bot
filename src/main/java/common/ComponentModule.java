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
            .toInstance(new ApiComponent(new ExchangeContext(OkCoinExchange.class, "", "")));

        bind(Component.class)
            .annotatedWith(Names.named("Bittrex"))
            .toInstance(new ApiComponent(new ExchangeContext(BittrexExchange.class, "e6cf7534e81d4ce49bc214006bae0c5a", "d54a9496685041ae973f0ba193fa250d")));
    }
}
