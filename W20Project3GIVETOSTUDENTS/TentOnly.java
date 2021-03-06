package W20Project3GIVETOSTUDENTS;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TentOnly extends CampSite {

    /**
     * the amount of tents rented
     */
    private int numberOfTenters;

    public TentOnly() {
    }

    public TentOnly(String guestName,
                    GregorianCalendar checkIn,
                    GregorianCalendar estimatedCheckOut,
                    GregorianCalendar actualCheckOut,
                    int numberOfTenters) {
        super(guestName, checkIn, estimatedCheckOut, actualCheckOut);
        this.numberOfTenters = numberOfTenters;
    }

    public int getNumberOfTenters() {
        return numberOfTenters;
    }

    public void setNumberOfTenters(int numberOfTenters) {
        this.numberOfTenters = numberOfTenters;
    }

    @Override
    public double getCost(GregorianCalendar checkOut) {
        double cost = 0.0;
        if(numberOfTenters>10){
            cost = 20*getDays(checkIn, checkOut);
        }else {
            cost = 10 * getDays(checkIn, checkOut);
        }
        return cost;
    }

    @Override
    public String toString() {
        return "TentOnly{" +
                "numberOfTenters=" + numberOfTenters +
                super.toString() +
                '}';
    }

}
