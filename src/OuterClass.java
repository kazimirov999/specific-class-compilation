public class OuterClass {
    static int staticNumber = 1;
    int noStaticNumber = 2 ;
    private int privateNumber = 3;
    final int finalNumber = 4;

    void printOuterMethod(){
        System.out.println("In a outer class method");
    }
    static class StaticNestedClass{
        void printStaticNested(){
            System.out.println(OuterClass.staticNumber + " - Static variable in a static nested class method");
        }
    }
    class InnerClass{
        void printInnerMethod(){
            System.out.println(staticNumber + " - Static variable in a inner class method");
            System.out.println(noStaticNumber + " - No-static variable in a inner class method");
            System.out.println(privateNumber + " - Private variable in a inner class method");
            System.out.println(finalNumber + " - Final variable in a inner class method");
        }
    }
    class Anonymous{
        void print(){

        }
    }
    void printVars(){

        class LocalClass{

            void printLocal(){
                System.out.println(finalNumber + "  - Final variable in a Local class method");
                System.out.println(noStaticNumber + "  - No-static variable in a Local class method");

            }
        }
        LocalClass localClass = new LocalClass();
        localClass.printLocal();
    }
    public enum MyEnum {
        WINTER,
        SPRING,
        SUMMER,
        AUTUMN
    }
}
