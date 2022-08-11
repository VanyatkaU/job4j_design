package ru.job4j.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private final Properties properties;
    private Connection connection;

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = properties.getProperty("hibernate.connection.url");
        String login = properties.getProperty("hibernate.connection.username");
        String password = properties.getProperty("hibernate.connection.password");
        connection = DriverManager.getConnection(url, login, password);
    }

    public void createTable(String tableName) throws Exception {
        Statement statement = connection.createStatement();
        String sql = String.format("create table if not exists demo_table %s;",
                tableName);
        statement.execute(sql);
        System.out.println(getTableScheme(connection, tableName));
    }

    public void dropTable(String tableName) throws Exception {
        Statement statement = connection.createStatement();
        String sql = String.format("drop table %s;",
                tableName);
        statement.execute(sql);
        statement.executeUpdate(sql);
        System.out.println(getTableScheme(connection, tableName));
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        Statement statement = connection.createStatement();
        String sql = String.format("to table %s add %s type %s;",
                tableName, columnName, type);
        statement.execute(sql);
        System.out.println(getTableScheme(connection, tableName));
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        Statement statement = connection.createStatement();
        String sql = String.format("from table %s drop %s;",
                tableName, columnName);
        statement.execute(sql);
        System.out.println(getTableScheme(connection, tableName));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        Statement statement = connection.createStatement();
        String sql = String.format("to table %s rename %s to new name %s;",
                tableName, columnName, newColumnName);
        statement.execute(sql);
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

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("src/main/resources/app.properties")) {
            properties.load(in);
            try (TableEditor tableEditor = new TableEditor(properties)) {
                String tableName = "demo_table";
                tableEditor.createTable(tableName);
                tableEditor.dropTable(tableName);
                tableEditor.addColumn(tableName, "name", "varchar(255)");
                tableEditor.dropColumn(tableName, "name");
                tableEditor.renameColumn(tableName, "name", "newName");
            }
        }
    }
}