import java.sql.*;
import static utils.Constant.*;

public class DbConnection {
    public void connection(){

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url,userName,password);

            if (connection != null){

                System.out.println("Connected to Database");

                Statement statement = connection.createStatement();

                ExecuteCrudOperations(connection, statement);

            }else {

                System.out.println("Database connection failed");
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void ExecuteCrudOperations(Connection connection, Statement statement) throws SQLException {

        CrudOperations crudOperations = new CrudOperations();

        crudOperations.CreateDatabase(utils.Constant.dbName, statement);

        crudOperations.CreateTableAndInsertData(connection, statement);

        crudOperations.GetDataFromTable(statement);
    }


}
