package com.bole.webflux.reactive;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * @Description:
 * @Author: 伯乐
 * @Date: 2020/12/3 21:15
 */
public class ReactiveDemo {
    public static void main(String[] args) {

        //发布者
        SubmissionPublisher<String> publisher = new SubmissionPublisher<String>();
        //订阅者
        Flow.Subscriber subscriber = new Flow.Subscriber() {
            private Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {//入参 订阅协议
                System.out.println("建立订阅关系第一次调用");
                this.subscription = subscription;
                this.subscription.request(1);
            }

            @Override
            public void onNext(Object item) {
                System.out.println("接收数据：" + item);
                this.subscription.request(100);
                // this.subscription.cancel();
                //handler 过滤器   这句话放哪
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("数据接收完成");

            }
        };

        //Processor

        //建立订阅关系
        publisher.subscribe(subscriber);

       // publisher.subscribe(Processor);
        //Processor.subscribe(subscriber);

        try {
            //发数据
            for (int i = 0; i <300 ; i++) {
                System.out.println("开始发送数据："+"webflux"+i);
                publisher.submit("webflux"+i);
            }
            Thread.currentThread().join();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //结束
            publisher.close();
        }
    }


}
