
import java.util.Scanner;

public class Main {

    static final String[] LOCATIONS = {
        "Pune Station",
        "Shivajinagar",
        "Swargate",
        "Kothrud",
        "Hinjawadi",
        "Wakad"
    };

    // Approximate latitude and longitude of each location
    static final double[] LAT = {
        18.5286, 18.5308, 18.5018,
        18.5074, 18.5913, 18.5975
    };

    static final double[] LON = {
        73.8744, 73.8475, 73.8636,
        73.8077, 73.7389, 73.7638
    };

    // Calculate straight-line distance using Haversine formula
    static double calculateDistance(int pickup, int drop) {
        double lat1 = Math.toRadians(LAT[pickup]);
        double lat2 = Math.toRadians(LAT[drop]);
        double lon1 = Math.toRadians(LON[pickup]);
        double lon2 = Math.toRadians(LON[drop]);

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.pow(Math.sin(dLat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dLon / 2), 2);

        double c = 2 * Math.atan2(
                Math.sqrt(a), Math.sqrt(1 - a));

        return 6371 * c;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== CAB BOOKING CHATBOT =====");
            System.out.println("1. Book Ride");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter 1 or 2.");
                sc.next();
                continue;
            }

            int choice = sc.nextInt();

            if (choice == 2) {
                System.out.println("Have a good day!");
                System.out.println("Thank you for booking with us!");
                break;
            }

            if (choice != 1) {
                System.out.println("Invalid choice! Try again.");
                continue;
            }

            // Select cab type
            System.out.println("\nChoose Cab Type:");
            System.out.println("1. Auto - Rs.12/km");
            System.out.println("2. Sedan - Rs.18/km");
            System.out.println("3. SUV - Rs.25/km");
            System.out.print("Enter cab choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid cab choice!");
                sc.next();
                continue;
            }

            int cabChoice = sc.nextInt();
            String cabType;
            int rate;

            if (cabChoice == 1) {
                cabType = "Auto";
                rate = 12;
            } else if (cabChoice == 2) {
                cabType = "Sedan";
                rate = 18;
            } else if (cabChoice == 3) {
                cabType = "SUV";
                rate = 25;
            } else {
                System.out.println("Invalid cab choice!");
                continue;
            }

            // Select pickup location
            System.out.println("\nChoose Pickup Location:");

            for (int i = 0; i < LOCATIONS.length; i++) {
                System.out.println((i + 1) + ". " + LOCATIONS[i]);
            }

            System.out.print("Enter pickup choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid pickup choice!");
                sc.next();
                continue;
            }

            int pickup = sc.nextInt() - 1;

            if (pickup < 0 || pickup >= LOCATIONS.length) {
                System.out.println("Invalid pickup choice!");
                continue;
            }

            // Select drop location
            System.out.println("\nChoose Drop Location:");

            for (int i = 0; i < LOCATIONS.length; i++) {
                System.out.println((i + 1) + ". " + LOCATIONS[i]);
            }

            System.out.print("Enter drop choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid drop choice!");
                sc.next();
                continue;
            }

            int drop = sc.nextInt() - 1;

            if (drop < 0 || drop >= LOCATIONS.length) {
                System.out.println("Invalid drop choice!");
                continue;
            }

            if (pickup == drop) {
                System.out.println(
                    "Pickup and drop locations cannot be the same!"
                );
                continue;
            }

            // Automatically calculate distance
            double distance = calculateDistance(pickup, drop);

            // Calculate fare using the calculated distance
            double fare = distance * rate;

            System.out.println("\n===== FARE DETAILS =====");
            System.out.println("Cab Type: " + cabType);
            System.out.println("Pickup: " + LOCATIONS[pickup]);
            System.out.println("Drop: " + LOCATIONS[drop]);
            System.out.printf("Approx. Distance: %.2f km%n", distance);
            System.out.println("Rate: Rs." + rate + "/km");
            System.out.printf("Total Fare: Rs.%.2f%n", fare);

            // Confirm or cancel before OTP
            System.out.println("\n1. Confirm & Share OTP");
            System.out.println("2. Cancel Ride");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid choice! No OTP shared.");
                sc.next();
                continue;
            }

            int confirm = sc.nextInt();

            if (confirm == 2) {
                System.out.println("Ride cancelled successfully.");
                System.out.println("No OTP has been shared.");
                continue;
            }
            
      if (confirm != 1) {
      System.out.println("Invalid choice! No OTP shared.");
      continue;
            }
      int otp = 1234;
      System.out.println("\nYour OTP is: " + otp);
      System.out.println("Booking confirmed successfully!");
      System.out.println("Cancellation is not allowed after OTP sharing.");
        }
    }
}
