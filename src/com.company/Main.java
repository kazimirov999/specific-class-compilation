package com.company;

public class Main {
    public static void main(String[] args) {
        MyOuterExample outerExample = new MyOuterExample();
        outerExample.printOuterMethod();
        MyOuterExample.MyInnerExample innerExample = outerExample.new MyInnerExample();
        MyOuterExample.StaticNested staticNested = new MyOuterExample.StaticNested();
        staticNested.printStaticNested();
        innerExample.printInnerMethod();
        MyOuterExample.Anonymous anonymous = outerExample.new Anonymous() {
            @Override
            void printMethod (){
            }
        };
        outerExample.printVariables();
        System.out.println("Now is a(an) " + Seasons.SUMMER);
    }
}
