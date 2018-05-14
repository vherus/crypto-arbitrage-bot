package okex.command;

import command.Command;
import org.knowm.xchange.currency.CurrencyPair;

import java.math.BigDecimal;

public class PlaceSellOrderCommand implements Command {
    private CurrencyPair currencyPair;
    private BigDecimal limitPrice;
    private BigDecimal originalAmount;

    public PlaceSellOrderCommand(CurrencyPair currencyPair, BigDecimal limitPrice, BigDecimal originalAmount) {
        this.currencyPair = currencyPair;
        this.limitPrice = limitPrice;
        this.originalAmount = originalAmount;
    }

    CurrencyPair getCurrencyPair() {
        return currencyPair;
    }

    BigDecimal getLimitPrice() {
        return limitPrice;
    }

    BigDecimal getOriginalAmount() {
        return originalAmount;
    }
}
