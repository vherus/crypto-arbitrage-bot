package bittrex.command;

import command.Command;
import org.knowm.xchange.currency.CurrencyPair;

import java.math.BigDecimal;

public class PlaceBuyOrderCommand implements Command {
    private CurrencyPair currencyPair;
    private BigDecimal limitPrice;
    private BigDecimal originalAmount;

    public PlaceBuyOrderCommand(CurrencyPair currencyPair, BigDecimal limitPrice, BigDecimal originalAmount) {
        this.currencyPair = currencyPair;
        this.limitPrice = limitPrice;
        this.originalAmount = originalAmount;
    }

    public CurrencyPair getCurrencyPair() {
        return currencyPair;
    }

    public BigDecimal getLimitPrice() {
        return limitPrice;
    }

    public BigDecimal getOriginalAmount() {
        return originalAmount;
    }
}
