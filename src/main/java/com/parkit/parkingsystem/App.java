package com.parkit.parkingsystem;

import com.parkit.parkingsystem.config.DataBaseConfig;
import com.parkit.parkingsystem.service.InteractiveShell;
import com.parkit.parkingsystem.service.ParkingService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

import static com.parkit.parkingsystem.service.InteractiveShell.*;

public class App {
    private static final Logger logger = LogManager.getLogger("App");
    public static void main(String[] args){
        logger.info("Initializing Parking System");
        InteractiveShell.loadInterface();



        try (Connection dbSqlCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/prod?serverTimezone=UTC","root","ROOTROOT")) {


        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
