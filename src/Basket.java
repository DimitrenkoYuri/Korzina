import java.io.*;
import java.util.Arrays;

public class Basket implements Serializable {
    private static final long serialVersionUID = 1l;
    private String[] goods;
    private int[] prices;
    private int[] quantities;

    public Basket() {

    }

    public Basket(String[] goods, int[] prices) {
        this.goods = goods;
        this.prices = prices;
        this.quantities = new int[goods.length];

    }

    public void addToCart(int productNum, int amount) {
        quantities[productNum] += amount;
    }

    public void printCart() {
        int totalPrice = 0;
        System.out.println("Список покупок:");
        for (int i = 0; i < goods.length; i++) {
            if (quantities[i] > 0) {
                int currentPrice = prices[i] * quantities[i];
                totalPrice += currentPrice;
                System.out.printf("%15s%4d p/шт%4d шт%6d p%n", goods[i], prices[i], quantities[i], currentPrice);
            }
        }
        System.out.printf("Итого: %dp", totalPrice);
    }

    public void saveTxt(File textFile) throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(textFile)) {
            out.println(String.join(" ", goods));
            out.println(String.join(" ", Arrays.stream(prices)
                    .mapToObj(String::valueOf)
                    .toArray(String[]::new)));
            out.println(String.join(" ", Arrays.stream(quantities)
                    .mapToObj(String::valueOf)
                    .toArray(String[]::new)));
        }
    }


    public static Basket loadFromTxtFile(File file) {
        Basket basket = new Basket();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String goodsStr = bufferedReader.readLine();
            String pricesStr = bufferedReader.readLine();
            String quantitiesStr = bufferedReader.readLine();

            basket.goods = goodsStr.split("");
            basket.prices = Arrays.stream(pricesStr.split(" "))
                    .map(Integer::parseInt)
                    .mapToInt(Integer::intValue)
                    .toArray();
            basket.quantities = Arrays.stream(pricesStr.split(" "))
                    .map(Integer::parseInt)
                    .mapToInt(Integer::intValue)
                    .toArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return basket;
    }
}

//    public void save(File file) {
//        try (ObjectOutputStream ignored = new ObjectOutputStream(new FileOutputStream())) {
//        }
//    }
//}



//    public static Basket loadFromTxtFile(File textFile) {
//        String[] productsLoad;
//        int[] pricesLoad;
//        int[] amountsLoad;
//        int summaryLoad;
//        try (BufferedReader br = new BufferedReader(new FileReader(textFile))) {
//
//            productsLoad = (br.readLine()).split(" ");
//            out.println(Arrays.toString(productsLoad));
//
//            String[] interim2 = (br.readLine()).split(" ");
//            pricesLoad = new int[productsLoad.length];
//            for (int i = 0; i < interim2.length; i++) {
//                pricesLoad[i] = Integer.parseInt(interim2[i]);
//
//            }
//
//            out.println(Arrays.toString(pricesLoad));
//
//            String[] interim3 = (br.readLine()).split(" ");
//            amountsLoad = new int[interim3.length];
//            for (int i = 0; i < interim3.length; i++) {
//                amountsLoad[i] = Integer.parseInt(interim3[i]);
//
//            }
//            out.println(Arrays.toString(amountsLoad));
//
//            summaryLoad = Integer.parseInt(br.readLine());
//            out.println(summaryLoad);
//            Basket basket= new Basket(productsLoad, pricesLoad);
//            return new Basket(productsLoad, pricesLoad);
//
//        } catch (IOException ex) {
//            out.println(ex.getMessage());
//        }
//        if (textFile.exists())
//            out.println("Корзина уже существуеи и будет использована:");
//        return null;
//    }
//}
//
//public class Basket {
//    public int[] addToCart;
//    private static final long serialVersionUID = 1L;
//    private String[] goods;
//    private int[] prices;
//    private int[] quantities;
//
//    public Basket() {
//    }
//
//    public Basket(String[] goods, int[] prices) {
//        this.goods = goods;
//        this.prices = prices;
//        this.quantities = new int[goods.length];
//    }
//
//    public void addToCart(int productNum, int amount) {
//        quantities[productNum] += amount;
//    }
//
//    public void printCart() {
//        int totalPrice = 0;
//        System.out.println("Список покупок:");
//        for (int i = 0; i < goods.length; i++) {
//            if (quantities[i] > 0) {
//                int currentPrice = prices[i] * quantities[i];
//                totalPrice += currentPrice;
//                System.out.printf("%15s%4d p/шт%4d шт%6d p%n", goods[i], prices[i], quantities[i], currentPrice);
//            }
//        }
//        System.out.printf("Итого: %dp", totalPrice);
//    }
//
//}