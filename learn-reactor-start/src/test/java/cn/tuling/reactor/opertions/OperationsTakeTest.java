package cn.tuling.reactor.opertions;


import org.junit.Test;
import reactor.core.publisher.Flux;


public class OperationsTakeTest {


    /**
     * map 操作符
     */
    @Test
    public void testMap() {

        Flux.just( "Beijing","Shanghai","Guangzhou" ).map( item->item.length()).subscribe(System.out::println);

    }



}

