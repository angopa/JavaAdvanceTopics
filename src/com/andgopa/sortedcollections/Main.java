package com.andgopa.sortedcollections;

import java.util.Map;

/**
 * Created by Andres Gonzalez on 1/18/18
 */
public class Main {

    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.85, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.00, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);
        temp = new StockItem("cup", 0.45, 7);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 100);
        stockList.addStock(temp);

        Basket timsBasket = new Basket("Tim");
        sellItem(timsBasket, "car", 1);

        sellItem(timsBasket, "car", 1);

        sellItem(timsBasket, "car", 1);
        sellItem(timsBasket, "spanner", 5);

        sellItem(timsBasket, "juice", 4);
        sellItem(timsBasket, "cup", 12);
        sellItem(timsBasket, "bread", 1);

        Basket basket = new Basket("customer");

        sellItem(basket, "cup", 100);
        sellItem(basket, "juice", 50);
        sellItem(basket, "cup", 1);
        removedItem(basket, "cup", 1);
        System.out.println(basket);

        removedItem(timsBasket, "cup", 1);
        removedItem(timsBasket, "car", 9);
        removedItem(timsBasket, "cup", 1);
        System.out.println("cars remove: " + removedItem(timsBasket, "car", 1)); // should not remove any

        System.out.println(timsBasket);

        //Remove all items from tim's basket
        removedItem(timsBasket, "bread", 1);
        removedItem(timsBasket, "cup", 3);
        removedItem(timsBasket, "juice", 4);
        removedItem(timsBasket, "cup", 4);
        System.out.println(timsBasket);

        System.out.println("\nDisplay stock list before and after checkout");
        System.out.println(basket);
        System.out.println(stockList);
        checkOut(basket);
        System.out.println(basket);
        System.out.println(stockList);
    }

    public static int sellItem(Basket basket, String item, int quantity) {
        //retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if (stockList.reservedStock(item, quantity) != 0) {
            return basket.addToBsket(stockItem, quantity);
        }
        return 0;
    }

    public static int removedItem(Basket basket, String item, int quantity) {
        //retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if (basket.removeFromBasket(stockItem, quantity) == quantity) {
            return stockList.unreservedStock(item, quantity);
        }
        return 0;
    }

    public static void checkOut(Basket basket) {
        for (Map.Entry<StockItem, Integer> item : basket.Items().entrySet()) {
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.clearBasket();
    }
}
