class A {}
class B extends A {}
class C extends B {}

public class Test {
    public static void main(String[] args) {
        A a = new C();
        B b = (B) a;
        C c = (C) b;
        System.out.print("OK");
    }
}