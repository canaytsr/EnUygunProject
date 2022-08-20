package model;

import lombok.Data;
import java.util.Date;
@Data
public class FlightTicket {

    String origin;
    String destination;
    Date departureDay;
    Date returnDay;
    boolean isDirect;
    String provider;

}