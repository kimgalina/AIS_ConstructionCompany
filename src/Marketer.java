import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Marketer extends AutomaticSystem {

    boolean isAuthorizationSuccessful()throws Exception{
        // подсоеденияемся к БД
        Connection connection = connectToDB();
        Statement statement = connection.createStatement();
        ResultSet result;

        String SQL_GET_LOGIN_PASSWORD = "SELECT login , password FROM employees WHERE post = 'marketer'";

        String login,password , SQL_login = "" , SQL_password = "";
        System.out.print("Enter your login >>> ");
        login = console.nextLine();
        System.out.print("\nEnter your password >>> ");
        password = console.nextLine();
        // получаем данные из базы
        result = statement.executeQuery(SQL_GET_LOGIN_PASSWORD);
        while(result.next())
        {
            SQL_login = result.getString("login");
            SQL_password = result.getString("password");

        }
        return (password.equals(SQL_password) && login.equals(SQL_login));

    }
    public void startMarketer()
    {

    }
}
