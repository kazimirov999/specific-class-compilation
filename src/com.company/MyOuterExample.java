package com.company;

public class MyOuterExample {
    static int staticInteger = 11;
    int noStaticInteger = 21;
    private int privateInteger = 23;
    final int finalInteger = 7;

    static class StaticNested{
        void printStaticNested(){
            System.out.println("Static variable in a static nested class method: " + MyOuterExample.staticInteger);
        }
    }

    void printOuterMethod(){
        System.out.println("Printed MyOuterExample method");
    }

    class MyInnerExample{
        void printInnerMethod(){
            System.out.println("Printed MyInnerExample method");
            System.out.println("Static variable in an inner class method: " + staticInteger);
            System.out.println("No-static variable in an inner class method: " + noStaticInteger);
            System.out.println("Private variable in an inner class method: " + privateInteger);
            System.out.println("Final variable in an inner class method: " + finalInteger);
        }

    }
    class Anonymous{
        void printMethod(){

        }
    }

    void printVariables(){
        class MyLocalExample{
                public String getLocalName(){
                    String cassName = this.getClass().toString();
                    System.out.println(cassName);
                    return cassName;
                }
                public void localVariables() {
                    System.out.println("Final variable in a Local class method: " + finalInteger);
                    System.out.println("No-static variable in a Local class method: " + noStaticInteger);
                }
        }
        MyLocalExample localExample = new MyLocalExample();
        localExample.localVariables();
        localExample.getLocalName();
    }

}
