package Ex1;

public class Products {

    private static Object[] shirt = {"T-Shirt", "Button Down", "Polo", "Graphic T"};
    private static Object[] pants = {"Jeans", "Khakis", "Shorts", "Slacks"};
    private static Object[] shoes = {"Loafers", "Drivers", "Running Shoes", "Tap Shoes"};


    public static Object pickShirt(int selection) {
        return shirt[selection];
    }

    public static Object pickPants(int selection) {
        return pants[selection];
    }
    public static Object pickShoes(int selection) {
        return shoes[selection];
    }


}
