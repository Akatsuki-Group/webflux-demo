package com.bole.webflux.reactive;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * @Description:
 * @Author: 伯乐
 * @Date: 2020/12/1 20:14
 */
public class ReactiveProcessor extends SubmissionPublisher<String> implements Flow.Processor<String, String> {
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("Processor建立订阅关系");
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(String item) {
        System.out.println("Processor接收数据:" + item);
        //中间处理
        this.submit(item.toUpperCase());
        //背压实现的核心
        this.subscription.request(1);
        //this.subscription.cancel();
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Processor出现异常");
        throwable.printStackTrace();
        this.subscription.cancel();
    }

    @Override
    public void onComplete() {
        System.out.println("Processor数据接收完成");
    }
}
