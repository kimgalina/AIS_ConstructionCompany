import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Marketer extends AutomaticSystem {


    void startMarketer() throws Exception{
        // если авторизация прошла успешно показывает меню для маркетолога , если нет возвращает в главное меню
        if(isAuthorizationSuccessful("marketer")) {
            Show_menu("Marketer_menu");
            boolean noOptionSelected = true;
            while (noOptionSelected) {
                // выбор опции
                int option = console.nextInt();
                switch (option) {
                    case 1://Show a list of all customer coverage areas by region


                        noOptionSelected = false;
                        break;
                    case 2:// Show a list of categories for marketing


                        noOptionSelected = false;
                        break;
                    case 3://Show the allocated budget for a certain category of places for marketing


                        noOptionSelected = false;
                        break;
                    case 4://Show total budget for marketing


                        noOptionSelected = false;
                        break;
                    case 5:// Spend a budget on promotion...


                        noOptionSelected = false;
                        break;
                    case 6://exit to main menu
                        start();
                        break;
                    default:
                        System.out.println("Sorry, but we didn't find this type of option , please try again.");
                }

            }
        }else{
            System.err.println("Incorrect login or password !");
            start();
        }
    }
}
