import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC_stable {

    @Test
    public void db_Connection() throws Exception{

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
        /*String query = "select upper(first_name) as worker_name from worker;";*/
        String query = "select worker_id, first_name, last_name, salary, department from worker;";

        //3 & 4
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()){

            int id = resultSet.getInt("worker_id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            int salary = resultSet.getInt("SALARY");
            String dept = resultSet.getString("DEPARTMENT");

            System.out.println(id+" "+ firstName+" "+ lastName+" "+ salary+" "+ dept);
        }


        //5
        con.close();

        System.out.println("\nQuery Executed...!");
    }
}
