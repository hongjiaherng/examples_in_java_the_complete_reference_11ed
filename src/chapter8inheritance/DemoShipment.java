package chapter8inheritance;

class Box {
    private double width;
    private double height;
    private double depth;

    Box(Box obj) {
        width = obj.width;
        height = obj.height;
        depth = obj.depth;
    }

    Box(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    Box(double len) {
        width = height = depth = len;
    }

    Box() {
        width = -1;
        height = -1;
        depth = -1;
    }

    double volume() {
        return width * height * depth;
    }
}

class BoxWeight extends Box {
    double weight;

    BoxWeight(BoxWeight obj) {
        super(obj);
        weight = obj.weight;
    }

    BoxWeight(double w, double h, double d, double weight) {
        super(w, h, d);
        this.weight = weight;
    }

    BoxWeight(double len, double weight) {
        super(len);
        this.weight = weight;
    }

    BoxWeight() {
        super();
        weight = -1;
    }
}

class Shipment extends BoxWeight {
    double cost;

    Shipment(Shipment obj) {
        super(obj);
        cost = obj.cost;
    }

    Shipment(double w, double h, double d, double weight, double cost) {
        super(w, h, d, weight);
        this.cost = cost;
    }

    Shipment(double len, double weight, double cost) {
        super(len, weight);
        this.cost = cost;
    }

    Shipment() {
        super();
        cost = -1;
    }

}

public class DemoShipment {

    public static void main(String[] args) {
        Shipment shipment1 = new Shipment(10, 20, 15, 10, 3.41);
        Shipment shipment2 = new Shipment(2, 3, 4, 0.76, 1.28);

        double vol;

        vol = shipment1.volume();
        System.out.println("Volume of shipment1 is " + vol);
        System.out.println("Weight of shipment1 is " + shipment1.weight);
        System.out.println("Shipping cost: $" + shipment1.cost);
        System.out.println();

        vol = shipment2.volume();
        System.out.println("Volume of shipment2 is " + vol);
        System.out.println("Weight of shipment2 is " + shipment2.weight);
        System.out.println("Shipping cost: $" + shipment2.cost);
        System.out.println();
    }
}
