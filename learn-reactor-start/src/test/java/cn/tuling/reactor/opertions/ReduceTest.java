package cn.tuling.reactor.opertions;


import org.junit.Test;
import reactor.core.publisher.Flux;

public class ReduceTest {


    /**
     * Flux.reduce:
     * reduce 需要一个初始值和一个函数，该函数会将前一步的结果与当前步的元素组合在一起,
     * reduce只会生成一个最终结果的元素：
     *
     * 如: 计算 1 到 5 之间的整数相加
     */
    @Test
  public void testReduce(){

        Flux<Integer> just=Flux.just( 1, 2, 3, 4, 5 );
        just.reduce( 0, (preResult, cur )-> preResult+ cur ).subscribe(System.out::println);


    }
}
