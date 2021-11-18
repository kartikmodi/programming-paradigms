package org.rutgers.imperative;

import org.rutgers.common.Item;
import org.rutgers.common.ItemImperativeRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/imperative")
@AllArgsConstructor
class ImperativeController {

    private final ItemImperativeRepository repository;

    @GetMapping("/item")
    Item getItem() {
        return repository.getItem();
    }

    @GetMapping("/items")
    List<Item> getItems() {
        return repository.getLotOfItems();
    }

    @GetMapping("/itemsNaive")
    List<Item> getItemsNaive() {
        return repository.getLotOfItemsNaive();
    }
}
