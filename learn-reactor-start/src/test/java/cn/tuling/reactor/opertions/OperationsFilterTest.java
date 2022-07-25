package cn.tuling.reactor.opertions;


import org.junit.Test;
import reactor.core.publisher.Flux;


public class OperationsFilterTest {


    /**
     * filter 操作符
     */
    @Test
    public void testFilter() {

        Flux<String> just=Flux.just( "Beijing", "Shanghai", "Guangzhou" );
        just.filter( item->!item.contains( "i" ) ).subscribe(System.out::println);




    }
















    /**
     * ignoreElements  忽略所有的元素
     * ignoreElements 返回Mono<T>并过滤所有元素。结果序列仅在原始序列结束后结束。
     */
    @Test
    public void ignoreElementsTest() {
        Flux<String> just=Flux.just( "Beijing", "Shanghai", "Guangzhou" );

        just.ignoreElements().subscribe(
                System.out::println,
                err -> {
                    err.printStackTrace();
                },
                () -> {
                    System.out.println( "done!" );
                }
        );


    }


}

