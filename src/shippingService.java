import java.util.List;

public class shippingService extends Product {
    public void shipItems(List<Product> items, double totalWeight) {

            System.out.println("** Shipment notice **");
            for (Product p : items) {
                if (p.shipable &&!p.expirable||(p.expirable && !p.expired)&& p.getQuantity() > 0) {
                    System.out.println(p.getQuantity() + "x " + p.getName() + "    " + p.getWeight() + "g");
                }
            }
            System.out.println("Total package weight " + (totalWeight/1000) + "kg\n");
        }


    }

