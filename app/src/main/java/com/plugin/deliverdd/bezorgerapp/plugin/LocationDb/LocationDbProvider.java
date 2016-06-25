package com.plugin.deliverdd.bezorgerapp.plugin.LocationDb;

import android.location.Location;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

/**
 * Created by Jan-WillemW on 6/25/2016.
 */
public class LocationDbProvider {

    private Connection _conn = null;

    public LocationDbProvider() throws Exception
    {
        Initialize();
    }

    // initialize the connection, (moet in een trycatch:(
    private Connection GetConnection(){
        try {
            if(_conn != null && _conn.isClosed() == false) return _conn;

            _conn = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // get the connection
    // create the position table when it doesnt exist
    // create the startmessage table when it doesnt exist
    private void Initialize() throws Exception{
        Connection connection = GetConnection();
        if(connection == null) throw new Exception("dbConnection not found");

        CreatePositionTable(connection);
        CreateRouteTable(connection);

        connection.close();
    }

    private void CreatePositionTable(Connection connection) throws Exception
    {
        Statement stm = connection.createStatement();
        String sql = "create table if not exists Position (" +
                "Id INT PRIMARY KEY     NOT NULL," +
                "StartMessageId INT     NOT NULL," +
                "PositionDate DATETIME  NOT NULL," +
                "Latitude REAL          NULL," +
                "Longitude REAL         NULL," +
                "Accuracy REAL          NULL," +
                "Altitude REAL          NULL," +
                "Heading REAL           NULL," +
                "Speed REAL             NULL)";
        stm.executeUpdate(sql);
        stm.close();
    }

    private void CreateRouteTable(Connection connection) throws Exception{
        Statement stm = connection.createStatement();
        String sql = "create table if not exists Routes (" +
                 "Id INT PRIMARY KEY     NOT NULL," +
                 "StartMessage INT       NOT NULL," +
                 "StartTime DATETIME     NULL," +
                 "EndTime DATETIME       NULL)";
        stm.executeUpdate(sql);
        stm.close();
    }

    public void StartRoute(int startMessageId, Date startTime)
    {

    }

    public void StopRoute(int startMessageId, Date stopTime)
    {

    }

    public void AddPosition(int startMessageId, Location location){

    }

    public List<Position> GetPositions(int startMessageId){
        // get the route

        // get the positions between two dates

        return null;
    }
}
