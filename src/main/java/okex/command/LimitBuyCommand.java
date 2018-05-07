package okex.command;

import command.Command;
import org.knowm.xchange.currency.CurrencyPair;

import java.math.BigDecimal;

public class LimitBuyCommand implements Command {
    private CurrencyPair currencyPair;
    private BigDecimal price;
    private BigDecimal quantity;

    public LimitBuyCommand(CurrencyPair currencyPair, BigDecimal price, BigDecimal quantity) {
        this.currencyPair = currencyPair;
        this.price = price;
        this.quantity = quantity;
    }

    public CurrencyPair getCurrencyPair() {
        return currencyPair;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }
}
