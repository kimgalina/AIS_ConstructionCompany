import java.sql.Connection;
import java.sql.ResultSet;

public class CorpWorker extends AutomaticSystem{

    boolean isAuthorizationSuccessful()throws Exception{
        // подсоеденияемся к БД
        Connection connection = connectToDB();
        String SQL_GET_LOGIN_PASSWORD = "SELECT login , password FROM workers WHERE worker_id = ?";
        ResultSet result;

        // приготаливаем заранее запрос заранее не зная у кого будем брать логин и пароль
        var  preparedStatement = connection.prepareStatement(SQL_GET_LOGIN_PASSWORD);

        int id;
        String login,password , SQL_login = "" , SQL_password = "";
        System.out.print("Enter your login >>> ");
        login = console.nextLine();
        System.out.print("\nEnter your password >>> ");
        password = console.nextLine();
        System.out.print("Enter your id >>> ");
        id = console.nextInt();
        // вставляем в запрос id сотрудника
        preparedStatement.setInt(1,id);
        // получаем данные из базы
        result = preparedStatement.executeQuery();

        while(result.next())
        {
            SQL_login = result.getString("login");
            SQL_password = result.getString("password");

        }
        return (password.equals(SQL_password) && login.equals(SQL_login));

    }

    void startWorker()throws Exception{
        // если авторизация прошла успешно показывает меню для сотрудника , если нет возвращает в главное меню
        if(isAuthorizationSuccessful()){
            Show_menu("Worker_menu");



        }else{
            System.err.println("Incorrect login or password !");
            start();
        }
    }
}
