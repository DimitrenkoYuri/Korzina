import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String[] products = {"Хлеб", "Арбуз", "Молоко"};
    static int[] prices = {100, 200, 300};
    static File saveFile = new File("basket.bin");

    public static void main(String[] args) throws FileNotFoundException {
        Basket basket = null;
        if (saveFile.exists()) {
            basket = Basket.loadFromTxtFile(saveFile);
        } else {
            basket = new Basket(products, prices);
        }
        while (true) {
//            showPrice();
            System.out.println("Выберите товар и количество или в конце покупки введите end");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
        }
    }
}

//                                int[] basket = new int[3];
//       Basket basket=null;
//        if (saveFile.exists()) {
//            basket = Basket.loadFromBinFile(saveFile);
//        }
//            System.out.println("Список возможных товаров для покупки:" + System.lineSeparator() +
//                    "Выберите товар и количество или в конце покупки введите end");
//        }
//
//        for (int i = 0; i < products.length; i++) {
//            System.out.println("Товар:" + " " + products[i] + " " + prices[i] + " " + "руб/шт");
//        }
//
//        int sumProducts = 0;
//        while (true) {
//            String input = scanner.nextLine();
//            int productNumber = 0;
//            int productCount = 0;
//            if ("end".equals(input)) {
//                break;
//            }
//            String[] parts = input.split(" ");
//            productNumber = Integer.parseInt(parts[0]) - 1;
//            productCount = Integer.parseInt(parts[1]);
//            basket[productNumber] += productCount;
//            sumProducts += productCount * prices[productNumber];
//        }
//
//        System.out.println("Ваша корзина: " + sumProducts + " " + "руб");
//
//    }
//}
