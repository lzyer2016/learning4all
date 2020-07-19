package com.learning4algorithm.leetcode.easy;


public class Water_Bottles {

    public static int numWaterBottles(int numBottles, int numExchange) {
        int ret = numBottles;
        while (numExchange <= numBottles) {
            int drink = numBottles / numExchange;
            int empty = numBottles % numExchange;
            ret += drink;
            numBottles = drink + empty;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(numWaterBottles(5, 5));
    }
}
