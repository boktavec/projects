public class Practice {
    public Object getAge(int number) {
        return number;
    }

    public Object getPerson(String name) {
        Object Age = getAge(name.length());
        return Age;
    }

    public static void main(String[] args) {
        Practice p1 = new Practice();
        Object john = p1.getPerson("John");
        System.out.println(john);
    }


}
