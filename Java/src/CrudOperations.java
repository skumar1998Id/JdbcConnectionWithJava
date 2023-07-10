import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudOperations {

    public void CreateDatabase(String dbName, Statement statement) throws SQLException {

        String createDbQuery = "CREATE DATABASE IF NOT EXISTS " + dbName;

        statement.executeUpdate(createDbQuery);

        System.out.println("Database created or already exists");

        String useDb = "USE " + dbName;

        statement.executeUpdate(useDb);
    }

    public void CreateTableAndInsertData(Connection connection, Statement statement) throws SQLException {

        ResultSet resultSet = connection.getMetaData().getTables(null,null,"Persons",null);

        String createTable = "Create table Persons (PersonID int, LastName varchar(255), FirstName varchar(255))";

        String insertData = "INSERT INTO Persons (PersonID, LastName, FirstName) VALUES (1, 'Kumar', 'Santosh')";

        if (resultSet.next()){ // Checking Table is exists or not
            System.out.println("Table Already exists");

            statement.execute(insertData);

            System.out.println("Data Inserted ");
        }else {
            statement.executeUpdate(createTable);

            System.out.println("Table created");

            System.out.println("Data Inserted ");
        }
    }

    public void GetDataFromTable(Statement statement) throws SQLException {

        String query = "select * from Persons";

        ResultSet resultSet1 = statement.executeQuery(query);

        System.out.println("Query executed! Getting the data..........");

        while (resultSet1.next()){ //Getting Table data
            System.out.println(
                    resultSet1.getInt(1) + "  " + resultSet1.getString(2) +"  "+ resultSet1.getString(3) );
        }

    }

}
