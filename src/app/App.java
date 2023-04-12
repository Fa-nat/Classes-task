package app;

import app.services.DataService;

public class App {

    public static void main(String[] args) {
        DataService service = new DataService();
        System.out.println(service.handleData());
    }
}
