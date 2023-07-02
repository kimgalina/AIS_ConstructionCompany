import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Marketer extends AutomaticSystem {


    void startMarketer() throws Exception{
        // если авторизация прошла успешно показывает меню для маркетолога , если нет возвращает в главное меню
        if(isAuthorizationSuccessful("marketer")){
            Show_menu("Marketer_menu");



        }else{
            System.err.println("Incorrect login or password !");
            start();
        }
    }
}
