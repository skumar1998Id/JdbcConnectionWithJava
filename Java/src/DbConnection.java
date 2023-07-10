import java.sql.*;

public class DbConnection {
    public void connection(){

        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "test";
        String userName = "root";
        String password = "@Dmin2089!";

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url,userName,password);

            if (connection != null){

                System.out.println("Connected to Database");

                Statement statement = connection.createStatement();

                ExecuteCrudOperations(dbName, connection, statement);

            }else {

                System.out.println("Database connection failed");
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void ExecuteCrudOperations(String dbName, Connection connection, Statement statement) throws SQLException {

        CrudOperations crudOperations = new CrudOperations();

        crudOperations.CreateDatabase(dbName, statement);

        crudOperations.CreateTableAndInsertData(connection, statement);

        crudOperations.GetDataFromTable(statement);
    }


}
