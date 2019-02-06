package reservation;

import java.util.ArrayList;

public class Reservation implements Reservationy {
    @Override
    public String getDowBooking() {

        //return new String[] {"MON", "TUE", "WED", "THU", "FRI", "SUN", "SAT"}[(int)(Math.random()) * 7];

        return new ArrayList<String>() {{ add("MON"); add("TUE"); add("WED"); add("THU"); add("FRI"); add("SUN"); add("SAT"); }}.get((int)(Math.random() * 7));
    }

    @Override
    public String getCodeBooking() {
        return String.format("%c%c%c%c%c%c%c%c", (int)(Math.random() * 2) == 0 ? 48 + (int)(Math.random() * 10) : 65 + (int)(Math.random() * 26),
                                                 (int)(Math.random() * 2) == 0 ? 48 + (int)(Math.random() * 10) : 65 + (int)(Math.random() * 26),
                                                 (int)(Math.random() * 2) == 0 ? 48 + (int)(Math.random() * 10) : 65 + (int)(Math.random() * 26),
                                                 (int)(Math.random() * 2) == 0 ? 48 + (int)(Math.random() * 10) : 65 + (int)(Math.random() * 26),
                                                 (int)(Math.random() * 2) == 0 ? 48 + (int)(Math.random() * 10) : 65 + (int)(Math.random() * 26),
                                                 (int)(Math.random() * 2) == 0 ? 48 + (int)(Math.random() * 10) : 65 + (int)(Math.random() * 26),
                                                 (int)(Math.random() * 2) == 0 ? 48 + (int)(Math.random() * 10) : 65 + (int)(Math.random() * 26),
                                                 (int)(Math.random() * 2) == 0 ? 48 + (int)(Math.random() * 10) : 65 + (int)(Math.random() * 26));
    }
}
