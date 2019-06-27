package com.company;

public class Main
{

    public static void main(String[] args) {

        int a =10;

        var anon = new Anon() {
            @Override
            public int getVariable () {
                return a;
            }
            public String getClassName(){
                return this.getClass().toString();
            }
        };
        System.out.println(anon.getClassName());
        System.out.println("Anonymous  " + anon.getVariable());


        Outer.StaticNested staticNested = new Outer.StaticNested();
        System.out.println(staticNested.getClassName());

        Outer outer = new Outer();
        outer.callLocalInner();

        Outer.Inner inner = outer.new Inner();
        System.out.println(inner.getClassName());

        for(Season season : Season.values()){
            System.out.print(season + "   ");
        }
    }

}
