package cn.tuling.reactor.opertions;


import org.junit.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ZipTest {



    @Test
    public void testZip() throws InterruptedException {

        Flux<Integer> just1 = Flux.just(1, 2, 3, 4, 5).delayElements( Duration.ofSeconds(1));
        Flux<Integer> just2 = Flux.just(10, 20, 30, 40,50);
        Flux<Integer> just3 = Flux.just(100, 200, 300, 400, 500);

        Flux.zip(just1,just2,just3)
                .map(item ->  item.getT1() +item.getT2() +item.getT3()   )
                .subscribe(System.out::println);

        TimeUnit.SECONDS.sleep( Integer.MAX_VALUE );
    }
}
