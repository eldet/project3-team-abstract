package W20Project3GIVETOSTUDENTS;

import org.junit.FixMethodOrder;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class
CampSite implements Serializable {
    /**
     * used to make sure loaded class corresponds to a serialized object
     */
    private static final long serialVersionUID = 1L;

    /**
     * protected means that these can be used in this class or any class in the package
     */
    protected String guestName;
    protected GregorianCalendar checkIn;
    protected GregorianCalendar estimatedCheckOut;
    protected GregorianCalendar actualCheckOut;

    public CampSite() {
    }

    public abstract double getCost(GregorianCalendar checkOut);

    public CampSite(String guestName,
                    GregorianCalendar checkIn,
                    GregorianCalendar estimatedCheckOut,
                    GregorianCalendar actualCheckOut) {
        this.guestName = guestName;
        this.checkIn = checkIn;
        this.estimatedCheckOut = estimatedCheckOut;
        this.actualCheckOut = actualCheckOut;
    }

    public int getDays(GregorianCalendar checkIn,GregorianCalendar checkOut){
       int days = 0;
       Date d1 = checkOut.getTime();
        Date d2 = checkIn.getTime();

        long diff = d2.getTime() - d1.getTime();
        days = (int)diff;
        System.out.println("TESTING: "+days);
        return days;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public GregorianCalendar getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(GregorianCalendar checkIn) {
        this.checkIn = checkIn;
    }

    public GregorianCalendar getEstimatedCheckOut() {
        return estimatedCheckOut;
    }

    public void setEstimatedCheckOut(GregorianCalendar estimatedCheckOut) {
        this.estimatedCheckOut = estimatedCheckOut;
    }

    public GregorianCalendar getActualCheckOut() {
        return actualCheckOut;
    }

    public void setActualCheckOut(GregorianCalendar actualCheckOut) {
        this.actualCheckOut = actualCheckOut;
    }

    // following code used for debugging only
    // IntelliJ using the toString for displaying in debugger.
    @Override
    public String toString() {
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

        String checkInOnDateStr;
        if (getCheckIn() == null)
            checkInOnDateStr = "";
        else
            checkInOnDateStr = formatter.format(getCheckIn().getTime());

        String  estCheckOutStr;
        if (getEstimatedCheckOut() == null)
            estCheckOutStr = "";
        else
            estCheckOutStr = formatter.format(getEstimatedCheckOut().getTime());

        String checkOutStr;
        if (getActualCheckOut() == null)
            checkOutStr = "";
        else
            checkOutStr = formatter.format(getActualCheckOut().getTime());

        return "CampSite{" +
                "guestName='" + guestName + '\'' +
                ", checkIn=" + checkInOnDateStr +
                ", estimatedCheckOut=" + estCheckOutStr +
                ", actualCheckOut=" + checkOutStr +
                '}';
    }

}