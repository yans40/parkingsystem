package com.parkit.parkingsystem.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public
class DataBaseConfig {

    private static final Logger logger = LogManager.getLogger("DataBaseConfig");


    public
    Connection getConnection() throws ClassNotFoundException, SQLException {


        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("conf.properties")) {
            props.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        logger.info("Create DB connection");
        Class.forName(props.getProperty("jdbc.driver.class"));


        String url = props.getProperty("jdbc.url");
        String user = props.getProperty("jdbc.login");
        String password = props.getProperty("jdbc.password");

        return DriverManager.getConnection(url, user, password);
    }


    public
    void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
                logger.info("Closing DB connection");
            } catch (SQLException e) {
                logger.error("Error while closing connection", e);
            }
        }
    }

    public
    void closePreparedStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
                logger.info("Closing Prepared Statement");
            } catch (SQLException e) {
                logger.error("Error while closing prepared statement", e);
            }
        }
    }

    public
    void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
                logger.info("Closing Result Set");
            } catch (SQLException e) {
                logger.error("Error while closing result set", e);
            }
        }
    }
}
