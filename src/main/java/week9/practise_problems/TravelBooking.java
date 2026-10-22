import java.util.*;

abstract class Travel {
    static final double BOOKING_FEE = 50;

    double distance;

    Travel(double distance) {
        this.distance = distance;
    }

    abstract double getFare();

    double getTotal() {
        return getFare() + BOOKING_FEE;
    }
}

class Bus extends Travel {
    Bus(double distance) {
        super(distance);
    }

    double getFare() {
        return 2 * distance;
    }
}

class Train extends Travel {
    Train(double distance) {
        super(distance);
    }

    double getFare() {
        return 1.5 * distance;
    }
}

class Flight extends Travel {
    Flight(double distance) {
        super(distance);
    }

    double getFare() {
        return 2500 + 4 * distance;
    }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            Travel travel;

            if (mode.equals("BUS"))
                travel = new Bus(distance);
            else if (mode.equals("TRAIN"))
                travel = new Train(distance);
            else
                travel = new Flight(distance);

            System.out.printf("%s: %.2f%n",
                    mode, travel.getTotal());
        }
    }
}