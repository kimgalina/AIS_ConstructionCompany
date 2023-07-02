public class Director extends AutomaticSystem{
    void startDirector()throws Exception{
        // если авторизация прошла успешно показывает меню для director, если нет возвращает в главное меню
        if(isAuthorizationSuccessful("director")){
            Show_menu("Director_menu");



        }else{
            System.err.println("Incorrect login or password !");
            start();
        }
    }
}
