package cn.tuling.reactor.opertions;


import lombok.Builder;
import lombok.Data;
import org.junit.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class FluxTest {
    @Test
    public void testGenerate() throws InterruptedException {

        AtomicLong atomicLong=new AtomicLong( 1 );
        Flux<Object> objectFlux=Flux.generate( item -> {

            item.next( atomicLong.getAndIncrement() );

        } ).delayElements( Duration.ofSeconds( 1 ) );



        objectFlux.subscribe( item->{
            System.out.println("first subscriber: "+item);
        } );



        objectFlux.subscribe( item->{
            System.out.println("second subscriber: "+item);
        } );

        TimeUnit.SECONDS.sleep( Integer.MAX_VALUE );



    }

    @Test
    public void testGenerate2(){
        Flux.generate( ()->"x",
                (f,s)->{
                    if (f.contains( "xxx" )){
                        s.next( " changed: "+"yyy" );
                        return  "yyy";
                    }else if (f.contains( "yyy")){
                        s.complete();
                        return "yyy";
                    }
                    s.next( " changed: "+f+"x" );
                   return  f+"x";} )
                .subscribe(System.out::println);
    }

    @Test
    public void testGenerate3() throws InterruptedException {

        Flux.generate(
                ()->UserInfo.builder().name( "gj" ).build(),
                (f,s)-> {
                    if (f.getName().length()==10){
                        s.complete();
                        return f;
                    }

                    f.setName( f.getName()+"x" );
                    s.next(f );
                    return f;
                },
                item->{
                    System.out.println(" consumer: "+item+"  ");
                } )
                .subscribe(System.out::println);
        TimeUnit.SECONDS.sleep( Integer.MAX_VALUE );
    }

    @Test
    public void testAsyncCreate() throws InterruptedException {


        Flux.create( item->{


            item.next( UUID.randomUUID().toString() );

        } ).subscribe(System.out::println);
        TimeUnit.SECONDS.sleep( Integer.MAX_VALUE );
    }
}

@Data
@Builder
class UserInfo{
    private String name;
}



