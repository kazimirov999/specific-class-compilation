public class Main {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.printOuterMethod();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        OuterClass.StaticNestedClass staticNestedClass = new OuterClass.StaticNestedClass();
        staticNestedClass.printStaticNested();
        innerClass.printInnerMethod();
        OuterClass.Anonymous anonymous = outerClass.new Anonymous() {
            @Override
            void print (){
            }
        };
        outerClass.printVars();
        System.out.println("Now is : " + OuterClass.MyEnum.SUMMER);
    }
}