import java.util.*;

abstract class Appliance {
    protected double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    boolean supportsSaver() {
        return false;
    }

    double getUnits(boolean saver) {
        double units = getPower() * hours / 1000;

        if (saver)
            units *= 0.75;

        return units;
    }

    double getCost(boolean saver) {
        return getUnits(saver) * 8;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150;
    }
}

class AC extends Appliance {
    AC(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500;
    }

    boolean supportsSaver() {
        return true;
    }
}

class TV extends Appliance {
    TV(double hours) {
        super(hours);
    }

    double getPower() {
        return 100;
    }
}

class Washer extends Appliance {
    Washer(double hours) {
        super(hours);
    }

    double getPower() {
        return 500;
    }

    boolean supportsSaver() {
        return true;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();

            boolean saver = false;

            if (sc.hasNext()) {
                String next = sc.nextLine().trim();
                saver = next.equals("SAVER");
            }

            Appliance appliance;

            if (type.equals("FRIDGE"))
                appliance = new Fridge(hours);
            else if (type.equals("AC"))
                appliance = new AC(hours);
            else if (type.equals("TV"))
                appliance = new TV(hours);
            else
                appliance = new Washer(hours);

            if (saver && !appliance.supportsSaver()) {
                System.out.println(type + ": saver mode not supported");
            } else {
                double units = appliance.getUnits(saver);
                double cost = appliance.getCost(saver);

                totalCost += cost;

                System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    type, units, cost
                );
            }
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
    }
}