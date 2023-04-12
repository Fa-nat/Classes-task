package app.services;

import app.data.DataProvider;
import app.data.Product;
import app.utils.Rounder;

public class DataService {

    String name;
    int quota;
    double price;
    DataProvider provider;

    public String handleData() {
        provider = new DataProvider();
        Product product = provider.getData();
        getData(product);
        return filterPurchase(calcPurchase(quota, price));
    }

    private void getData(Product product) {
        name = product.getName();
        quota = product.getQuota();
        price = product.getPrice();
    }

    private double calcPurchase(int quota, double price) {
        return quota * price;
    }

    private String filterPurchase(double purchase) {
        String purchaseRounded;
        int discount;
        if (purchase <= 0) {
            return "\nSomething is wrong.";
        } else if (purchase < 1000) {
            purchaseRounded = Rounder.roundValue(purchase);
            return "\n" + name + " costs USD " + purchaseRounded +
                    "\nThank you.";
        } else if (purchase >= 1000 && purchase <= 5000) {
            purchaseRounded = Rounder.roundValue(purchase);
            discount = 5;
            return "\n" + name + " costs USD " + purchaseRounded +
                    "\nYour next discount is " + discount + " %" +
                    "\nThank you.";
        } else {
            purchaseRounded = Rounder.roundValue(purchase);
            discount = 10;
            return "\n" + name + " costs USD " + purchaseRounded +
                    "\nYour next discount is " + discount + " %" +
                    "\nThank you.";
        }
    }
}
