import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        DbConnection dbConnection =new DbConnection();

        dbConnection.connection();
    }
}
