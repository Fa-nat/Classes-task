package app.data;

import java.util.Locale;
import java.util.Scanner;
import app.data.Product;

public class DataProvider {

    public Product getData() {
        Product product = new Product();
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        System.out.print("Enter product name: ");
        product.setName(scanner.nextLine());
        System.out.print("Enter product quota: ");
        product.setQuota(scanner.nextInt());
        System.out.print("Enter product price: ");
        product.setPrice(scanner.nextDouble());
        return product;
    }
}
