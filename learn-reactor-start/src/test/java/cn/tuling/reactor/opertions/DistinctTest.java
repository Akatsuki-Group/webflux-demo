package cn.tuling.reactor.opertions;


import org.junit.Test;
import reactor.core.publisher.Flux;

public class DistinctTest {


    @Test
    public void testDistinct() {

        Flux<Integer> just=Flux.just( 1, 1, 5, 2, 2, 2, 1, 2, 3, 3, 2, 2, 3, 3, 4, 4, 4, 5, 5, 5, 5, 4, 4, 4, 4, 5, 5 );

        System.out.println( "distinct: " );
        just.distinct().subscribe( System.out::println );
        System.out.println( "distinctUntilChanged:" );
        just.distinctUntilChanged().subscribe( System.out::println );
    }
}
