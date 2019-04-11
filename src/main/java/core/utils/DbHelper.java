package core.utils;

import core.fe.dto.ProductDetailsDto;

import java.sql.*;

public class DbHelper {

    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    private DbHelper() {
    }

    public static void connectToDb(final String userName, final String password, final String connectionString) throws SQLException {
        connection = DriverManager.getConnection(connectionString, userName, password);
    }

    public static void executeQuery(String sqlQuery) throws SQLException {
        if (!connection.isClosed()) {
            preparedStatement = connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
        }
    }

    public static ProductDetailsDto mapDbData() throws SQLException {
        final ProductDetailsDto detailsDto = new ProductDetailsDto();
        ResultSetMetaData resultSetMetaData = preparedStatement.getMetaData();
        for (int columnIndex = 0; columnIndex < resultSetMetaData.getColumnCount(); columnIndex++) {
            resultSet.getString(columnIndex);
        }
        return detailsDto;
    }

}
