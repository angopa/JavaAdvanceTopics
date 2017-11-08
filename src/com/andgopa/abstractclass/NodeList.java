package com.andgopa.abstractclass;

/**
 * Created by paezand on 11/8/17.
 */

public interface NodeList {

    ListItem getRoot();

    boolean addItem(ListItem item);

    boolean removeItem(ListItem item);

    void traverse(ListItem root);
}
