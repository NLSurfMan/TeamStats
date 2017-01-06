package nl.wveldhuis.ts.ui.util;

import java.util.ArrayList;
import java.util.List;

public class MRU<T> {
    private List<T> items;
    private int itemsToKeep = 10;

    public MRU() {
        items = new ArrayList<T>();
    }

    public MRU(int itemsToKeep) {
        this();
        this.itemsToKeep = itemsToKeep;
    }

    public void addItem(T item) {
        items.add(0, item);
        while (items.size() > itemsToKeep) {
            items.remove(items.size() - 1);
        }
    }

    public List<T> getItems() {
        return items;
    }

    public int getItemsToKeep() {
        return itemsToKeep;
    }
}
