package com.plugin.deliverdd.bezorgerapp.plugin.LocationDb;

import java.util.Date;

/**
 * Created by Jan-WillemW on 6/25/2016.
 */
public class Position {
    public int Id;
    public int StartMessageId;

    public Date PositionDate;

    public long Latitude;
    public long Longitude;
    public long Accuracy;
    public long Altitude;
    public long Heading;
    public long Speed;
}
