package com.bole.webflux.function;

import java.util.function.*;

/**
 * @Description:
 * @Author: 伯乐
 * @Date: 2020/12/3 20:02
 */
public class FuntionDemo {

    public static void main(String[] args) {
        // Consumer 输入T 没有输出
        Product p=new Product();
        Consumer<Product> consumer=product->Product.nameOf(product);//lambda
        consumer.accept(p);
        //方法引用
        Consumer<Product> consumer1=Product::nameOf;
        consumer1.accept(p);

        //Supplier 没有输入 一个输出R
        Supplier<Product> supplier=Product::new;
        System.out.println("创建新的对象（Supplier）："+supplier.get());

        //Function 一个输入 T ，一个输出R
        Function<Integer,Integer> function=p::reduceStock;
        System.out.println("减库存成功，剩余库存（Function）"+function.apply(10));

        //一元 输入输出都是T
        UnaryOperator<Integer> unaryOperator=p::reduceStock;
        System.out.println("减库存成功，剩余库存（UnaryOperator）"+unaryOperator.apply(20));

        //二元函数 输入T U,返回R
        BiFunction<Integer,Integer,Integer> biFunction=p::reduceStock;
        System.out.println("减库存成功，剩余库存（BiFunction）"+biFunction.apply(100,30));

    }
}


    class Product {
        private String productName = "手机";
        private Integer stock = 100;

        public Product() {
        }

        public Product(int stock) {
            this.stock = stock;
        }

        public static   void nameOf(Product product) {
            System.out.println("产品名字:" + product);
        }

        public Integer reduceStock(Integer productNum) {
            System.out.print("扣减库存：-" + productNum);
            return this.stock -= productNum;
        }

        public Integer reduceStock(Integer stock,Integer productNum) {
            System.out.print(" 扣减库存：-" + productNum);
            return this.stock = stock-productNum;
        }

        public boolean isEnough(Integer integer){
            return this.stock>integer;
        }

        public Integer getStock(){
            return this.stock;
        }


        @Override
        public String toString() {
            return this.productName+":"+this.stock+"台";
        }


    }
