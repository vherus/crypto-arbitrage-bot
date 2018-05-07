package api.okex.domain;

import api.DomainEntity;

import java.math.BigDecimal;

public final class Ticker implements DomainEntity {
    private final BigDecimal buy;
    private final BigDecimal high;
    private final BigDecimal last;
    private final BigDecimal low;
    private final BigDecimal sell;
    private final BigDecimal vol;

    private Ticker(BigDecimal buy, BigDecimal high, BigDecimal last, BigDecimal low, BigDecimal sell, BigDecimal vol) {
        this.buy = buy;
        this.high = high;
        this.last = last;
        this.low = low;
        this.sell = sell;
        this.vol = vol;
    }

    public BigDecimal getBuy() {
        return buy;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public BigDecimal getLast() {
        return last;
    }

    public BigDecimal getLow() {
        return low;
    }

    public BigDecimal getSell() {
        return sell;
    }

    public BigDecimal getVol() {
        return vol;
    }

    public static class Builder {
        private BigDecimal buy;
        private BigDecimal high;
        private BigDecimal last;
        private BigDecimal low;
        private BigDecimal sell;
        private BigDecimal vol;
        private boolean isBuilt = false;

        public Builder() {
            //
        }

        public Ticker build() {
            this.validateState();
            Ticker ticker = new Ticker(this.buy, this.high, this.last, this.low, this.sell, this.vol);
            this.isBuilt = true;
            return ticker;
        }

        private void validateState() {
            if (this.isBuilt) {
                throw new IllegalStateException("Ticker already built");
            }
        }

        public Ticker.Builder buy(BigDecimal buy) {
            this.buy = buy;
            return this;
        }

        public Ticker.Builder high(BigDecimal high) {
            this.high = high;
            return this;
        }

        public Ticker.Builder last(BigDecimal last) {
            this.last = last;
            return this;
        }

        public Ticker.Builder low(BigDecimal low) {
            this.low = low;
            return this;
        }

        public Ticker.Builder sell(BigDecimal sell) {
            this.sell = sell;
            return this;
        }

        public Ticker.Builder vol(BigDecimal vol) {
            this.vol = vol;
            return this;
        }
    }
}
