package util;

import org.knowm.xchange.dto.trade.LimitOrder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

final class OrderBookMerger {
    static ArrayList<LimitOrder> merge(List<LimitOrder> bookOne, List<LimitOrder> bookTwo) {
        ArrayList<LimitOrder> merged = new ArrayList<>();

        merged.addAll(bookOne);
        merged.addAll(bookTwo);
        merged.sort(Comparator.comparing(LimitOrder::getLimitPrice));

        Collections.reverse(merged);

        return merged;
    }
}
