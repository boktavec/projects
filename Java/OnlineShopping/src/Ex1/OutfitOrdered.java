package Ex1;

import java.util.Arrays;

public class OutfitOrdered {
    private static Object[] itemsOrdered;
    static Products product = new Products();


    public static Object[] clothesSelected(int shirt, int pants, int shoes) {

        itemsOrdered = new Object[]{product.pickShirt(shirt),product.pickPants(pants), product.pickShoes(shoes)};

        return itemsOrdered;
    }


    public static void main(String[] args) {
        Object[] Outfit = clothesSelected(1,2,3);
        System.out.println(Arrays.toString(Outfit));
    }
}
