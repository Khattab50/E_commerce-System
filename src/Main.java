import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        customer customer1 = new customer("khattab", 10000.0);
        customer customer2 = new customer("Ahmed", 5000.0);
        customer customer3 = new customer("Ali", 100.0);
        Product cheese = new Product("cheese", 100.0, 5,500,true,true,false );
        Product milk = new Product("milk", 50.0, 4,1000,true, true,true);
        Product scratchCard = new Product("scratchCard", 20.0,4, 10, false, true,false);
        Product biscuits = new Product("Biscuits", 10.0, 20,700, true, true,false);
        Product gum = new Product("gum", 2.0, 1, 5, false, true,false);
        Product tv = new Product("TV", 5000.0, 1, 5000, true, false, true);

        customer1.addToCart(cheese, 2);
        customer1.addToCart(biscuits, 1);
        customer1.addToCart(milk, 2);
        customer1.addToCart(scratchCard, 3);
        customer1.addToCart(gum, 3);
        customer1.addToCart(tv, 1);
        customer1.checkout(customer1,customer1.getcart());

        customer2.checkout(customer2,customer2.getcart());

        customer3.addToCart(cheese, 2);
        customer3.checkout(customer3, customer3.getcart());
    }
}