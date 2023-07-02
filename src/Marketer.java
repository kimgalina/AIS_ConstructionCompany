import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Marketer extends AutomaticSystem {
    static double totalBudget ;// чтобы его мог менять директор
    Marketer() throws Exception{
        Connection connection = connectToDB();
        var statement = connection.createStatement();
        String SQL_GET_TOTAL_BUDGET = "SELECT sum(investment)  as total_budget FROM marketing_budget";
        ResultSet result = statement.executeQuery(SQL_GET_TOTAL_BUDGET);
        while(result.next()){
            totalBudget = result.getDouble("total_budget");
        }
    }
    // метод статаический специально чтобы например класс директор мог этим пользоваться без создания обьектов
    static void ShowCustomerArea() throws Exception{
        Connection connection = connectToDB();
        var statement = connection.createStatement();
        String SQL_Show_Customer_Area = "SELECT region , info  FROM customer_coverage_area";
        ResultSet result = statement.executeQuery(SQL_Show_Customer_Area);
        while(result.next()){
            System.out.println(result.getString("region") + " " + result.getString("info"));
        }
    }
    private void ShowMarketingCategories() throws Exception{
        Connection connection = connectToDB();
        var statement = connection.createStatement();
        String SQL_Show_MARKETING_CATEGORIES = "SELECT category , users_number  FROM marketing_categories";
        ResultSet result = statement.executeQuery(SQL_Show_MARKETING_CATEGORIES);
        while(result.next()){
            System.out.println(result.getString("category") + " " + result.getString("users_number"));
        }
    }
    private void exitToMenu() throws Exception{
        String returnBack = "";
        System.out.println("\n \n To return PRESS 'q'");
        while(!(returnBack.equals("q")))
        {
            returnBack = console.nextLine();
        }
        startMarketer();
    }
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
                        ShowCustomerArea();
                        exitToMenu();
                        noOptionSelected = false;
                        break;
                    case 2:// Show a list of categories for marketing
                        ShowMarketingCategories();
                        exitToMenu();
                        noOptionSelected = false;
                        break;
                    case 3://Show the allocated budget for a certain category of places for marketing


                        noOptionSelected = false;
                        break;
                    case 4://Show total budget for marketing
                        System.out.println("Total budget for marketing >>> " + totalBudget);
                        exitToMenu();
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
