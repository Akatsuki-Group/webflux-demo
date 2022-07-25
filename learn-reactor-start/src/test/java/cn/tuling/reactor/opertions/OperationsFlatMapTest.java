package cn.tuling.reactor.opertions;

import lombok.Builder;
import lombok.Data;
import org.junit.Test;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;


public class OperationsFlatMapTest {


    /**
     * flatMap 操作符
     */
    @Test
    public void testFlatMap() {

        Flux<User> userFlux=Flux.just(
                User.builder().id( 1 ).tags( Arrays.asList( "80后","技术管理","资深技术专家","极客精神" ) ).build(),
                User.builder().id( 2 ).tags( Arrays.asList( "技术管理","极客精神" ) ).build(),
                User.builder().id( 3 ).tags( Arrays.asList( "学霸","初学者" ) ).build() );

        userFlux.flatMap( item-> Flux.fromStream( item.getTags().stream()  ) ).subscribe(System.out::println);

    }



}
@Data
@Builder
class User{
    private Integer id;
    private List<String> tags;
}
