package com.zach.labuladong.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Design an algorithm that accepts a stream of integers and retrieves the product of the last k integers of the stream.
 * Implement the ProductOfNumbers class:
 * ProductOfNumbers() Initializes the object with an empty stream.
 * void add(int num) Appends the integer num to the stream.
 * int getProduct(int k) Returns the product of the last k numbers in the current list. You can assume that always the current list has at least k numbers.
 * The test cases are generated so that, at any time, the product of any contiguous sequence of numbers will fit into a single 32-bit integer without overflowing.
 * Example:
 * Input
 * ["ProductOfNumbers","add","add","add","add","add","getProduct","getProduct","getProduct","add","getProduct"]
 * [[],[3],[0],[2],[5],[4],[2],[3],[4],[8],[2]]
 * Output
 * [null,null,null,null,null,null,20,40,0,null,32]
 */
public class ProductOfNumbers {
   private List<Integer> prefixProduct =  new ArrayList<>();
   private int size=0;
   public ProductOfNumbers(){
       this.prefixProduct.add(1);
       this.size=0;
   }

   public void add(int num){
       if(num==0){
           this.prefixProduct.clear();
           this.prefixProduct.add(1);
           this.size=0;
       }else {
           this.prefixProduct.add(this.prefixProduct.get(size)*num);
           this.size++;
       }
   }

   public int getProduct(int k){
       if(k>size){
           return 0;
       }
       return prefixProduct.get(size)/prefixProduct.get(size-k);
   }



    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);
        productOfNumbers.add(0);
        productOfNumbers.add(2);
        productOfNumbers.add(5);
        productOfNumbers.add(4);
        productOfNumbers.add(2);
        productOfNumbers.add(8);
        productOfNumbers.add(2);

        int product = productOfNumbers.getProduct(8);
        System.out.println(product);


    }
}
