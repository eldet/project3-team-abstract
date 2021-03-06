package W20Project3GIVETOSTUDENTS;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class RV extends CampSite {

private int power;

    public RV() {
    }

    public RV(String guestName, GregorianCalendar checkIn, GregorianCalendar estimatedCheckOut, GregorianCalendar actualCheckOut, int power) {
        super(guestName, checkIn, estimatedCheckOut, actualCheckOut);
        this.power = power;
        }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public double getCost(GregorianCalendar checkOut) {
       double cost = 0.0;
        if(power>1000){
cost = 10+(30*getDays(checkIn, checkOut));
        }else{
            cost = 10+(20*getDays(checkIn, checkOut));
        }

        return cost;
    }

    @Override
    public String toString() {
        return "RV{" +
                "power=" + power +
                super.toString() +
                '}';
    }
}