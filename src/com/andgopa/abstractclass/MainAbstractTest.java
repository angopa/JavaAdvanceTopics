package com.andgopa.abstractclass;

/**
 * Created by paezand on 11/8/17.
 */

public class MainAbstractTest {

    public static void main(String[] args) {
        MyLinkList list = new MyLinkList(null);
        list.traverse(list.getRoot());

        String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";
        String[] data = stringData.split(" ");
        for (String s : data) {
            list.addItem(new Node(s));
        }

        list.traverse(list.getRoot());
    }

}
