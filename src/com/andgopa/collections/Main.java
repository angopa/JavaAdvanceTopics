package com.andgopa.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Andres Gonzalez on 11/27/17
 */
public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("Olympiian", 8, 12);

        if (theatre.reserveSeat("A02")) {
            System.out.println("Please pay for A02");
        } else {
            System.out.println("Seat already reserved");
        }

        List<Theatre.Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);

        List<Theatre.Seat> priceSeat = new ArrayList<>(theatre.getSeats());
        priceSeat.add(theatre.new Seat("B00", 13.00));
        priceSeat.add(theatre.new Seat("A00", 13.00));
        Collections.sort(priceSeat, Theatre.PRICE_ORDER);
        priceSeat.get(10).setPrice(9999.0);
        printList(priceSeat);
    }

    public static void printList(List<Theatre.Seat> list) {
        for (Theatre.Seat seat : list) {
            System.out.print("[" + seat.getSeatNumber() + ", $" + seat.getPrice() + "]");
        }

        System.out.println();
        System.out.println("==============================================================");
    }

    public static void sortList(List<? extends Theatre.Seat> list) {
        for (int i = 0 ; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    Collections.swap(list, i , j);
                }
            }
        }
    }
}
