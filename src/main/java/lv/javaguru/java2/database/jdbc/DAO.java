package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;

import java.sql.Connection;

/**
 * Created by maksimspuskels on 30/10/15.
 */

public interface DAO {
    Connection getConnection() throws DBException;

    void closeConnection(Connection connection) throws DBException;
}
