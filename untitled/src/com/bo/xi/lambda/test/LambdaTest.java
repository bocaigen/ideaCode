package com.bo.xi.lambda.test;

/**
 * Created by Administrator on 2018/3/24.
 */
public class LambdaTest {

    public static void main(String[] args) {
        MathOperation mathOperation = (int a, int b) -> a + b;
        int operation = mathOperation.operation(5, 8);
        System.out.println("=============="+operation);
    }

    

    interface MathOperation{
        int operation(int a,int b);
    }
}
