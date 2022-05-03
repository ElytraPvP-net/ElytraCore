package net.elytrapvp.elytracore;

import java.sql.Connection;

public class ElytraCoreAPI {
    private static ElytraCore plugin = null;

    public ElytraCoreAPI(ElytraCore pl) {
        plugin = pl;
    }

    public static Connection getDatabase() {
        return plugin.getMySQL().getConnection();
    }
}