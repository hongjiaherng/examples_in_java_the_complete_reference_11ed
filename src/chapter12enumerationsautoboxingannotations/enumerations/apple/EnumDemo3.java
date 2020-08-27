package chapter12enumerationsautoboxingannotations.enumerations.apple;

enum Apple {
    Jonathan(10), GoldenDel(9), RedDel, Winesap(15), Cortland(8);

    private int price;

    Apple(int price) {
        this.price = price;
    }

    Apple() {
        price = -1;
    }

    int getPrice() {
        return price;
    }
}

public class EnumDemo3 {
    public static void main(String[] args) {
        Apple ap;

        System.out.println("Winesap costs " + Apple.Winesap.getPrice() + " cents. \n");

        System.out.println("All apples prices: ");
        for (Apple a : Apple.values()) {
            System.out.println(a + " costs " + a.getPrice() + " cents.");
        }
    }
}
