public class SaleManager extends AutomaticSystem{
    void startSaleManager() throws Exception{
        // если авторизация прошла успешно показывает меню для sale_manager, если нет возвращает в главное меню
        if(isAuthorizationSuccessful("sale - manager")){
            Show_menu("Sale_manager_menu");



        }else{
            System.err.println("Incorrect login or password !");
            start();
        }
    }
}
