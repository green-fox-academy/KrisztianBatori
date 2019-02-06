package reservation;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("Booking# " + new Reservation().getCodeBooking() + " for " + new Reservation().getDowBooking());
        }
    }
}
