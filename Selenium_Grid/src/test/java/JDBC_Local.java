import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC_Local {
    public static void main(String[] args) throws Exception{
        /*
        * For insert, update, delete
        * 1. create a connection
        * 2. create our statement | query
        * 3. execute the statement | query
        * 4. close connection
        *
        * For Select command -          as Select cmd return data for us, so we need to store them.
        * 1. create a connection
         * 2. create our statement | query
         * 3. execute the statement | query
         * 4. Store result in Result Set
         * 5. close connection
         * */

        //1
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ORG","root","Java1010010[]");             // connection string

        //2
        Statement statement = con.createStatement();
        String query = "insert into student values(103,'SMITH');";

        //3
        statement.executeQuery(query);

        //4
        con.close();


        System.out.println("Query Executed...!");

    }
}
