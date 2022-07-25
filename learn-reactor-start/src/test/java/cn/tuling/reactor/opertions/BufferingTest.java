package cn.tuling.reactor.opertions;


import org.junit.Test;
import reactor.core.publisher.Flux;

public class BufferingTest {
    // buffer:  缓冲元素到List 容器中，结果流的类型为Flux<List<T>>，每一次onNext 方法调用会buffer指定数量的元素
    @Test
    public void testBuffering(){
        Flux.range(1,50).buffer(5).subscribe(System.out::println);
    }
}
