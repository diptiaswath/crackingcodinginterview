package design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/problems/stock-price-fluctuation/solution/
public class StockPriceFluctuation {

    // store price of stock at each timestamp
    private Map<Integer, Integer> tsStockPrice;

    // store for each stock price, its frequency (#how many time we have seen stock price)
    private TreeMap<Integer, Integer> stockPriceFreq;

    // latest timestamp seen thus far
    private int latestTs;

    public StockPriceFluctuation() {
        this.tsStockPrice = new HashMap<>();
        this.stockPriceFreq = new TreeMap<>((a, b) -> Integer.compare(a, b));
        this.latestTs = 0;
    }

    public void update(int timestamp, int price) {
        this.latestTs = Math.max(this.latestTs, timestamp);

        if (tsStockPrice.containsKey(timestamp)) {
            int oldStockPrice = tsStockPrice.get(timestamp);

            // add and remove a record in sorted map takes O(Log N) * N where n = # of calls to update()
            stockPriceFreq.put(oldStockPrice, stockPriceFreq.get(oldStockPrice) - 1);

            if (stockPriceFreq.get(oldStockPrice) == 0) {
                stockPriceFreq.remove(oldStockPrice);
            }
        }

        tsStockPrice.put(timestamp, price);
        stockPriceFreq.put(price, stockPriceFreq.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return tsStockPrice.get(this.latestTs);
    }

    public int maximum() {
        return stockPriceFreq.lastKey();
    }

    public int minimum() {
        return stockPriceFreq.firstKey();
    }
}
