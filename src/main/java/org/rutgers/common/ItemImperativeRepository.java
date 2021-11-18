package org.rutgers.common;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Repository
public class ItemImperativeRepository {

    public Item getItem() {
        sleep();
        return new Item("Hello world");
    }

    public List<Item> getLotOfItemsNaive() {
        sleep();
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            items.add(new Item("Item " + i));
        }
        return items;
    }

    /**
     * THIS IS 100% SYNCHRONOUS
     *
     * @return
     */
    public List<Item> getLotOfItems() {
        sleep();
        List<Item> items;
        Stream<Item> itemStream = IntStream.range(0, 100).boxed()
                .map(i -> new Item("Item " + i));
        items = itemStream.collect(Collectors.toList());
        return items;
    }

    private void sleep() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
