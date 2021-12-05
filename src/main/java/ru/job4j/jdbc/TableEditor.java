package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public final Statement statement = connection.createStatement();

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    private Connection initConnection() throws ClassNotFoundException, SQLException {
        Config config = new Config("app.properties");
        config.load();
        Class.forName(properties.getProperty(config.value("hibernate"
                + ".connection.driver_class")));
        String url = properties.getProperty(config.value("hibernate.connection.url"));
        String login = properties.getProperty(config.value("hibernate"
                + ".connection.username"));
        String password = properties.getProperty(config.value("hibernate"
                + ".connection.password"));
        connection =  DriverManager.getConnection(url, login, password);
        DatabaseMetaData metaData = connection.getMetaData();
        System.out.println(metaData.getUserName());
        System.out.println(metaData.getURL());
        return connection;
    }

    public void createTable(String tableName) throws Exception {
            try (statement) {
                String sql = String.format(
                        "create table " + tableName + ";");
                statement.execute(sql);
            }
        System.out.println(getTableScheme(connection, tableName));
    }

    public void dropTable(String tableName) throws Exception {
            try (statement) {
                String sql = String.format(
                        "drop table " + tableName + ";");
                statement.execute(sql);
            }
        System.out.println(getTableScheme(connection, tableName));
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
            try (statement) {
                String sql = String.format(
                        "alter table " + tableName + " add " + columnName
                                + " " + type + ";");
                statement.execute(sql);
            }
        System.out.println(getTableScheme(connection, tableName));
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
            try (statement) {
                String sql = String.format(
                        "alter table " + tableName + " drop column " + columnName + ";");
                statement.execute(sql);
            }
        System.out.println(getTableScheme(connection, tableName));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
            try (statement) {
                String sql = String.format(
                        "alter table " + tableName + " rename column " + columnName + " to " + newColumnName + ";");
                statement.execute(sql);
            }
        System.out.println(getTableScheme(connection, tableName));
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
