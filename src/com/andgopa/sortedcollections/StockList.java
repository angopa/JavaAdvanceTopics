package com.andgopa.sortedcollections;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Andres Gonzalez on 1/14/18
 */
public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item) {
        if (item != null) {
            // check if already have quantities of this item
            StockItem inStock = list.getOrDefault(item.getName(), item);
            // If there are already stocks of this item, adjust quantity
            if (inStock != item) {
                item.adjustStock(inStock.availableQuantity());
            }

            list.put(item.getName(), item);
            return item.availableQuantity();
        }
        return 0;
    }


    public int sellStock(String item, int quantity) {
        StockItem inStock = list.get(item);
        if (inStock != null && quantity > 0) {
            return inStock.finaliseStock(quantity);
        }
//        StockItem inStock = list.getOrDefault(item, null);
//        if ((inStock != null) && (quantity > 0) && (inStock.availableQuantity() >= quantity)) {
//            inStock.adjustStock(-quantity);
//            return quantity;
//        }
        return 0;
    }

    public int reservedStock(String item, int quantity) {
        StockItem inStock = list.get(item);
        if (inStock != null && quantity > 0) {
            return inStock.resevedStock(quantity);
        }
        return 0;
    }

    public int unreservedStock(String item, int quantity) {
        StockItem inStock = list.get(item);
        if (inStock != null && quantity > 0) {
            return inStock.unreservedStock(quantity);
        }
        return 0;
    }


    public StockItem get(String item) {
        return list.get(item);
    }

    public Map<String, Double> priceList() {
        Map<String, Double> prices = new LinkedHashMap<>();
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    public Map<String, StockItem> items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();
            double itemValue = stockItem.getPrice() * stockItem.availableQuantity();
            s = s + stockItem + ". There are " + stockItem.availableQuantity() + " in stock. Value of Items: ";
            s = s + itemValue + "\n";
            totalCost += itemValue;
        }

        return s + "Total Stock Value: " + totalCost;
    }
}
