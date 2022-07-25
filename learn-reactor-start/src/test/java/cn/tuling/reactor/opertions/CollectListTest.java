package cn.tuling.reactor.opertions;


import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.List;

public class CollectListTest {

    @Test
    public void testCollectList(){
        Mono<List<Integer>> listMono = Flux.just(3, 1, 21, 14, 25, 36, 17, 28, 19).collectList();
        listMono.subscribe(item->{
            System.out.println(item.getClass());
            System.out.println(item);
        });

        Mono<List<Integer>> sortedMono = Flux.just(3, 1, 21, 14, 25, 36, 17, 28, 19).collectSortedList();
        sortedMono.subscribe(System.out::println);
        // 反序
        Mono<List<Integer>> reverseSortedMono = Flux.just(3, 1, 21, 14, 25, 36, 17, 28, 19).collectSortedList( Comparator.reverseOrder());
        reverseSortedMono.subscribe(System.out::println);
    }

}
