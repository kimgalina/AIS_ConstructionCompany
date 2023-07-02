import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Manager extends AutomaticSystem{

    void startManager() throws Exception{
        // если авторизация прошла успешно показывает меню для менеджера  , если нет возвращает в главное меню
        if(isAuthorizationSuccessful("manager")){
            Show_menu("Manager_menu");



        }else{
            System.err.println("Incorrect login or password !");
            start();
        }
    }
}
