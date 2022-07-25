package com.bole.webflux.reactive;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * @Description:
 * @Author: 伯乐
 * @Date: 2020/12/1 20:21
 */
public class ReactiveStreamDemo2 {

    public static void main(String[] args) {
        //1-建立发布者
        SubmissionPublisher<String> publisher = new SubmissionPublisher<String>();
        //2-创建处理器
        ReactiveProcessor processor = new ReactiveProcessor();
        //3-发布者与处理器建立订阅关系
        publisher.subscribe(processor);

        //4-创建订阅者
        Flow.Subscriber<String> subscriber = new Flow.Subscriber<String>() {
            private Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                System.out.println("建立订阅关系");
                this.subscription = subscription;
                this.subscription.request(1);
            }

            @Override
            public void onNext(String item) {
                System.out.println("接收数据:" + item);

                //背压实现的核心
                this.subscription.request(1);
                //this.subscription.cancel();
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("出现异常");
                throwable.printStackTrace();
                this.subscription.cancel();
            }

            @Override
            public void onComplete() {
                System.out.println("数据接收完成");
            }
        };
        //5-中间处理器与订阅者建立订阅关系
        processor.subscribe(subscriber);

        for (int i = 0; i < 500; i++) {
            System.out.println("发布数据 = " + i);
            publisher.submit("bole:" + i);
        }
        publisher.close();
        try {
            Thread.currentThread().join(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
