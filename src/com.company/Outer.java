package com.company;

public class Outer {

    private static int n = 10;

    public Outer(){

        System.out.println("Outer constructor start");

        StaticNested staticNested = new StaticNested();
        System.out.println("Static nested  " + staticNested.getOuterVariable());

        Inner inner = new Inner();
        System.out.println("Inner  private variable  " + inner.a);
        System.out.println("Inner  private method   " + inner.getOuterVariable());

        System.out.println("Outer constructor finish");

    }

    void callLocalInner(){

         final int a = 15;

        class LocalInner{
            public String getClassName(){
                return this.getClass().toString();
            }
            private int getOuterVariable(){
                return a;
            }
        }

        LocalInner localInner = new LocalInner();

        System.out.println(localInner.getClassName());
        System.out.println("Local Inner  " + localInner.getOuterVariable());

    }

    class Inner{

        private int a = 15;

        public String getClassName(){
            return this.getClass().toString();
        }
        private int getOuterVariable(){
            a = 8;
            return a;
        }
    }
    static class StaticNested{
        public String getClassName(){
            return this.getClass().toString();
        }
        private int getOuterVariable(){
            return n;
        }
    }
}
