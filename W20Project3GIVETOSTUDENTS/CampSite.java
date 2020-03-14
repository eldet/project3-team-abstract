package W20Project3GIVETOSTUDENTS;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.GregorianCalendar;

public abstract class CampSite implements Serializable {
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
        return (int) ChronoUnit.DAYS.between(checkIn.toInstant(), checkOut.toInstant());
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

//    public static CampSite parseCampsite(String is) {
//        try {
//            String parsable = is.substring(is.indexOf("{") + 1, is.length() - 1);
//            String[] vals = parsable.split(", ");
//
//            String gn = vals[0].substring(vals[0].indexOf("\'") + 1, vals[0].length() - 1);
//
//            Date tempdate = DateFormat.getDateInstance(DateFormat.SHORT).parse(vals[1].substring(vals[1].indexOf("=")+1));
//            GregorianCalendar ci = new GregorianCalendar();
//            ci.setTime(tempdate);
//
//            tempdate = DateFormat.getDateInstance(DateFormat.SHORT).parse(vals[2].substring(vals[2].indexOf("=")+1));
//            GregorianCalendar eco = new GregorianCalendar();
//            eco.setTime(tempdate);
//
//            tempdate = DateFormat.getDateInstance(DateFormat.SHORT).parse(vals[2].substring(vals[2].indexOf("=")+1));
//            GregorianCalendar aco = new GregorianCalendar();
//            aco.setTime(tempdate);
//
//            return new CampSite(gn, ci, eco, aco);
//        } catch (Exception ex) {
//            return new CampSite();
//        }
//    }
}