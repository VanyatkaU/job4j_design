package ru.job4j.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private final Properties properties;
    private static Connection connection;

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws ClassNotFoundException, SQLException {
        Class.forName(properties.getProperty("hibernate.connection.driver_class"));
        String url = properties.getProperty("hibernate.connection.url");
        String login = properties.getProperty("hibernate.connection.username");
        String password = properties.getProperty("hibernate.connection.password");
        connection = DriverManager.getConnection(url, login, password);
    }

    public void createTable(String tableName) throws Exception {
        statement(String.format("create table if not exists %s ();",
                tableName));
    }

    public void dropTable(String tableName) throws Exception {
        statement(String.format("drop table drop %s;",
                tableName));
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        statement(String.format("alter table %s add %s %s;",
                tableName, columnName, type));
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        statement(String.format("alter table %s drop %s;",
                tableName, columnName));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        statement(String.format("alter table %s rename %s to %s;",
                tableName, columnName, newColumnName));
    }

    public void statement(String sql) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
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

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
            properties.load(in);
            try (TableEditor tableEditor = new TableEditor(properties)) {
                tableEditor.createTable("date");
                System.out.println(getTableScheme(connection, "date"));
                tableEditor.addColumn("date", "columnName", "text");
                System.out.println(getTableScheme(connection, "date"));
                tableEditor.renameColumn("date", "columnName", "newColumnName");
                System.out.println(getTableScheme(connection, "date"));
                tableEditor.dropColumn("date", "newColumnName");
                System.out.println(getTableScheme(connection, "date"));
                tableEditor.dropTable("date");
            }
        }
    }
}