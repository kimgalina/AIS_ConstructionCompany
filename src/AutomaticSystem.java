import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class AutomaticSystem {
    private  final String DB_USERNAME = "postgres";
    private  final String DB_PASSWORD= "vyhuhol05.kg";
    private  final String DB_URL= "jdbc:postgresql://localhost:5433/ais_construction_company";
    Scanner console = new Scanner(System.in);


    // метод для подключения к базе данных
    protected  Connection connectToDB() throws Exception{
        Connection connection0 = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
        return connection0;
    }
    public  void start() throws Exception{
        // устанавливаем соединение с DB
        Connection connection = connectToDB();
        // запрос чтобы увидеть главное меню id = 1

        String SQL_Show_Menu = "SELECT content FROM Menu WHERE id = 1";
        // обьект который может отправлять и получать запросы
        Statement statement = connection.createStatement();

        boolean noOptionSelected = true;
        while(noOptionSelected)
        {
            // отправляет запрос и получает результат
            ResultSet result = statement.executeQuery(SQL_Show_Menu);
            // вывод главного меню
            while(result.next())
            {
                System.out.println(result.getString("content"));
            }
            // выбор опции
            int option = console.nextInt();
            switch(option)
            {
                case 0:
                    Director director = new Director();
                   

                    noOptionSelected = false;
                    break;
                case 1:
                    Marketer marketer = new Marketer();




                    noOptionSelected = false;
                    break;
                case 2:
                    Manager manager = new Manager();


                    noOptionSelected = false;
                    break;
                case 3:
                    CorpWorker worker = new CorpWorker();




                    noOptionSelected = false;
                    break;
                case 4:
                    SaleManager saleManager = new SaleManager();



                    noOptionSelected = false;
                    break;
                case 5://exit
                    System.out.println("The program is over, we look forward to your return!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Sorry, but we didn't find this type of account, please try again.");
            }

        }

    }
    boolean isAuthorizationSuccessful(String post)throws Exception{
        // подсоеденияемся к БД
        Connection connection = connectToDB();
        String SQL_GET_LOGIN_PASSWORD = "SELECT login , password FROM employees WHERE post = ?";
        ResultSet result;

        // приготаливаем заранее запрос заранее не зная у кого будем брать логин и пароль
        var  preparedStatement = connection.prepareStatement(SQL_GET_LOGIN_PASSWORD);
        // вставляем в запрос должность
        preparedStatement.setString(1,post);

        String login,password , SQL_login = "" , SQL_password = "";
        System.out.print("Enter your login >>> ");
        login = console.nextLine();
        System.out.print("\nEnter your password >>> ");
        password = console.nextLine();
        // получаем данные из базы
        result = preparedStatement.executeQuery();

        while(result.next())
        {
            SQL_login = result.getString("login");
            SQL_password = result.getString("password");

        }
        return (password.equals(SQL_password) && login.equals(SQL_login));

    }

}
