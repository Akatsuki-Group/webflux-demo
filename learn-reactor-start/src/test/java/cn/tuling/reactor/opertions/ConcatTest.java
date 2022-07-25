package cn.tuling.reactor.opertions;


import org.junit.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ConcatTest {
    /*

     concat: 向下游转发接收到的元素来连接所有数据源。当连接多个流时，首先消费并重新发送第一个流的所有元素，然后处理后面的流.。

    */
    @Test
    public void testConcat() throws InterruptedException {


        Flux<Integer> just1 = Flux.just(1, 2, 3, 4, 5).delayElements( Duration.ofSeconds(1));
        Flux<Integer> just2 = Flux.just(10, 20, 30, 40, 50);
        Flux<Integer> just3 = Flux.just(100, 200, 300, 400, 500);

        Flux.concat(just1,just2,just3).subscribe(System.out::println);

        TimeUnit.SECONDS.sleep( Integer.MAX_VALUE );

    }

     /*

     merge: 将来自上游序列的数据合并到一个下游序列中。无论哪个数据源，有数据时立即传递到下游
     */
    @Test
    public void testMerge() throws InterruptedException {
        Flux<Integer> just1 = Flux.just(1, 2, 3, 4, 5).delayElements(Duration.ofSeconds(1));
        Flux<Integer> just2 = Flux.just(10, 20, 30, 40, 50);
        Flux<Integer> just3 = Flux.just(100, 200, 300, 400, 500);

        Flux.merge(just1,just2,just3).subscribe(System.out::println);
        TimeUnit.SECONDS.sleep( Integer.MAX_VALUE );
    }
}
