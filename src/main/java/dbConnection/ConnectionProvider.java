package dbConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public enum ConnectionProvider {
    INSTANCE;

    private static DataSource dataSource;

    public Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }


    public static DataSource getDataSource(){
        if(dataSource == null){
            try {
                Context initialContext = new InitialContext();
                Context envContext = (Context) initialContext.lookup("java:comp/env");
                DataSource ds = (DataSource) envContext.lookup("jdbc/hackaton");
                dataSource = ds;
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        System.out.println("CONNECTED TO DATABASE-db Connection");
        return dataSource;
    }

}
