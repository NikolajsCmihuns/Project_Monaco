package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Viktor on 01/07/2014.
 */
public class DatabaseCleaner {

    private final DAO dao = new DAOImpl();

    private List<String> getTableNames() {
        List<String> tableNames = new ArrayList<String>();
        tableNames.add("USER");
        tableNames.add("PLACE");
        return tableNames;
    }

    public void cleanDatabase() throws DBException {
        for(String tableName : getTableNames()) {
            Connection connection = getConnection();
            try {
                connection = getConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement("delete from " + tableName);
                preparedStatement.executeUpdate();
            } catch (Throwable e) {
                System.out.println("Exception while execute cleanDatabase() for table " + tableName);
                e.printStackTrace();
                throw new DBException(e);
            } finally {
                closeConnection(connection);
            }
        }
    }

    public Connection getConnection() throws DBException {
        return dao.getConnection();
    }

    public void closeConnection(Connection connection) throws DBException {
        dao.closeConnection(connection);
    }
}
