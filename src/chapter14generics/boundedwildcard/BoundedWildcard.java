package chapter14generics.boundedwildcard;

class TwoD {
    int x, y;

    TwoD(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class ThreeD extends TwoD {
    int z;

    ThreeD(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
}

class FourD extends ThreeD {
    int t;

    FourD(int x, int y, int z, int t) {
        super(x, y, z);
        this.t = t;
    }
}

class Coordinate<T extends TwoD> {
    T[] coordinates;

    Coordinate(T[] o) {
        coordinates = o;
    }
}

class BoundedWildcard {

    static void showXY(Coordinate<?> c) {
        System.out.println("X Y Coordinates:");
        for (int i = 0; i < c.coordinates.length; i++) {
            System.out.println(c.coordinates[i].x + " " + c.coordinates[i].y);
        }
        System.out.println();
    }

    static void showXYZ(Coordinate<? extends ThreeD> c) {
        System.out.println("X Y Z Coordinates: ");
        for (int i = 0; i < c.coordinates.length; i++) {
            System.out.println(c.coordinates[i].x + " " +
                    c.coordinates[i].y + " " +
                    c.coordinates[i].z);
        }
        System.out.println();
    }

    static void showAll(Coordinate<? extends FourD> c) {
        System.out.println("X Y Z T Coordinates: ");
        for (int i = 0; i < c.coordinates.length; i++) {
            System.out.println(c.coordinates[i].x + " " +
                    c.coordinates[i].y + " " +
                    c.coordinates[i].z + " " +
                    c.coordinates[i].t);
        }
    }

    public static void main(String[] args) {

        TwoD[] td = {
                new TwoD(0, 0),
                new TwoD(7, 9),
                new TwoD(18, 4),
                new TwoD(-1, -23)
        };

        Coordinate<TwoD> tdLocations = new Coordinate<TwoD>(td);

        System.out.println("Contents of tdLocations.");
        showXY(tdLocations);
        // showXYZ(tdLocations);
        // showAll(tdLocations);

        FourD[] fd = {
                new FourD(1, 2, 3, 4),
                new FourD(6, 8, 14, 8),
                new FourD(22, 9, 4, 9),
                new FourD(3, -2, -23, 17)
        };

        Coordinate<FourD> fdLocations = new Coordinate<FourD>(fd);

        System.out.println("Contents of fdLocations.");
        showXY(fdLocations);
        showXYZ(fdLocations);
        showAll(fdLocations);

    }
}
