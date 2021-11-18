package org.rutgers.reactive;

import org.rutgers.common.Item;
import org.rutgers.common.ItemReactiveRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/reactive")
class ReactiveController {

    private final ItemReactiveRepository repository;

    @GetMapping("/item")
    Mono<Item> getItem() {
        return repository.getItem();
    }

    @GetMapping("/items")
    Flux<Item> getItems() {
        return repository.getLotOfItems();
    }

    @GetMapping("/items/blocked")
    Flux<Item> getItemsBlocking() {
        return repository.getItemsBlocking();
    }
}
