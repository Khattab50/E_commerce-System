import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class customer {

    private String name;
    private double balance;
    customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
    private List<Product> cart = new ArrayList<>();
    public List<Product> addToCart(Product p, int quantity) {
        if (p.getQuantity() >= quantity) {
            Product cartProduct = new Product(p.getName(), p.getPrice(), p.getQuantity(),p.getWeight() ,p.shipable, p.expirable, p.expired);
            cartProduct.setQuantity(quantity);
            cart.add(cartProduct);
            p.setQuantity(p.getQuantity() - quantity);
        } else {
            System.out.println("Sorry mr."+this.name+" there is No enough stock for " + p.getName() + ". Available: " + p.getQuantity());
        }
        return cart;
    }

    private List<Product> shippableItems = new ArrayList<>();
    public void checkout(customer c,List<Product> products){
        if (products.isEmpty()) {
            System.out.println("mr."+c.getName()+" Your cart is empty.");
            return;
        }

        double totalWeight = 0;
        double subtotal = 0;
        for (Product p : products) {
            if(!p.expirable||p.expirable && !p.expired) {
                subtotal += p.getPrice() * p.getQuantity();
                if (p.shipable) {
                    totalWeight += p.getWeight() * p.getQuantity();
                    shippableItems.add(p);
                }
                continue;
            }
            else if (p.expirable && p.expired) {
                System.out.println("Sorry mr."+c.getName()+" Product " + p.getName() + " is expired.");

            }
        }
        if (subtotal > c.balance) {
            System.out.println("Insufficient balance mr."+c.getName()+" Total price: " + subtotal + ", Your balance: " + balance);
            return;
        }

        new shippingService().shipItems(shippableItems, totalWeight);

        System.out.println("** Checkout receipt **");
        for (Product p : products) {
            if (!p.expirable||(p.expirable&&!p.expired)) {
                System.out.println(p.getQuantity() + "x " + p.getName() + "    " + (p.getPrice() * p.getQuantity()));
            }
        }

        double shippingCost = (totalWeight/1000) * 5;
        double totalCost = subtotal + shippingCost;
        System.out.println("---");
        System.out.println("Subtotal    " + subtotal);
        System.out.println("Shipping    " + shippingCost);
        System.out.println("Amount    " + totalCost);

        // Deduct from balance
        balance -= totalCost;

        products.clear();
        shippableItems.clear();
    }
    public List<Product> getcart() {
        return cart;
    }
    public String getName() {
        return name;
    }
}
