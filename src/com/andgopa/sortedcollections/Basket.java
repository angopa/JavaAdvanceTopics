package com.andgopa.sortedcollections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andres Gonzalez on 1/18/18
 */
public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new HashMap<>();
    }

    public int addToBsket(StockItem item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            int intBasket = list.getOrDefault(item, 0);
            list.put(item, intBasket);
        }
        return 0;
    }

    public Map<StockItem, Integer> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\n Shopping basket " + name + " contains " + list.size() + " items\n";
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s = s + item.getKey() + ", " + item.getValue() + "purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost " + totalCost;
    }
}
