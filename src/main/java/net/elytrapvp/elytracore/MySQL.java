package net.elytrapvp.elytracore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL
{
    private static final ElytraSettings settings = ElytraSettings.getInstance();

    private static Connection connection;
    private static final String host = settings.getConfig().getString("MySQL.host");
    private static final String database = settings.getConfig().getString("MySQL.database");
    private static final String username = settings.getConfig().getString("MySQL.username");
    private static final String password = settings.getConfig().getString("MySQL.password");
    private static final int port = settings.getConfig().getInt("MySQL.port");

    /**
     * Close an active connection.
     */
    public static void closeConnection()
    {
        if(isConnected())
        {
            try
            {
                connection.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * Get the current connection.
     * @return Connection
     */
    public static Connection getConnection()
    {
        return connection;
    }

    /**
     * Check if there is currently a connection.
     * @return Connection
     */
    public static boolean isConnected()
    {
        return connection != null;
    }

    /**
     * Open a MySQL Connection
     */
    public static void openConnection()
    {
        try
        {
            if (connection != null && !connection.isClosed())
            {
                return;
            }

            synchronized(ElytraCore.class)
            {
                if (connection != null && !connection.isClosed())
                {
                    return;
                }

                String str = "";

                if(settings.getConfig().getBoolean("MySQL.useSSL"))
                {
                    str += "?autoReconnect=true&useSSL=false";
                }

                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + str, username, password);
            }
        }
        catch(SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }

    }
}
