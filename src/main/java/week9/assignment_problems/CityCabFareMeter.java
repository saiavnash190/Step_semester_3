import java.util.*;

abstract class Cab {
    static final double MIN_FARE = 100.0;

    abstract double getRate();

    boolean hasNightService() {
        return false;
    }

    double calculateFare(double km, boolean night) {
        double fare = Math.max(MIN_FARE, km * getRate());

        if (night)
            fare = fare * 1.20;

        return fare;
    }
}

class Mini extends Cab {
    double getRate() {
        return 10;
    }
}

class Sedan extends Cab {
    double getRate() {
        return 14;
    }

    boolean hasNightService() {
        return true;
    }
}

class SUV extends Cab {
    double getRate() {
        return 18;
    }

    boolean hasNightService() {
        return true;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            if (type.equals("MINI"))
                cab = new Mini();
            else if (type.equals("SEDAN"))
                cab = new Sedan();
            else
                cab = new SUV();

            boolean night = time.equals("NIGHT");

            if (night && !cab.hasNightService()) {
                System.out.println(type + ": night service not available");
            } else {
                double fare = cab.calculateFare(km, night);
                total += fare;

                System.out.printf("%s: %.2f%n", type, fare);
            }
        }

        System.out.printf("Total: %.2f%n", total);
    }
}