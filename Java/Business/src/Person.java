public class Person {
    private String middleName = "Christopher";
    //Method is a function - use void
    public void sayHello() {
        System.out.println("Hello");
    }
    // void method(type var)
    public void saySomething(String something) {
        System.out.println(something);
    }

    public char getMiddleInitial() {
        return middleName.charAt(0);
    }

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.sayHello();
        p1.saySomething("My name is Carl");
        System.out.println(p1.getMiddleInitial());
    }

}
