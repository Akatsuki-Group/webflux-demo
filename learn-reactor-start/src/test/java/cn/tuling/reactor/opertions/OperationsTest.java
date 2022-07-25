package cn.tuling.reactor.opertions;


import org.junit.Test;
import reactor.core.publisher.Flux;


public class OperationsTest {


    /**
     * take, takelast,takeUntil,elementAt 操作符
     */
    @Test
    public void testTakeMap() {

        Flux<String> just=Flux.just( "a", "b", "c", "d", "e", "f" );
        just.take( 5 )
             .takeLast( 3 )
                .takeUntil(item->item.equalsIgnoreCase( "d" )  )
                .elementAt( 1 )
                .subscribe(System.out::println);

    }



}

