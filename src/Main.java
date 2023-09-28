import java.util.List;

public class Main {
    public static void main(String[] args) {
        user user1=new user("Abhimesh");
        user1.addBalance(2000);
        user user2=new user("Rachana");
        user2.addBalance(3000);
        userManager usermanager= userManager.getInstance();
        usermanager.addUser(user1);
        usermanager.addUser(user2);

        Stock stock1=new Stock("ITC",225);
        Stock stock2=new Stock("TCS",2250);
        stockManager stockmanager= stockManager.getInstance();

        stockmanager.addStack(stock1);
        stockmanager.addStack(stock2);

        order order1=new order(ordertype.BUY,stock1,225,1,2);
        order order2=new order(ordertype.BUY,stock1,225,1,10);

        orderManager ordermanager= orderManager.getInstance();
        ordermanager.executeOrder(order1);
        ordermanager.executeOrder(order2);

        List<Stock> portfolio=usermanager.getUser(1).getPortfolio();
        for(int i=0;i<portfolio.size();i++)
        {
            System.out.println(portfolio.get(i).stockName);
            System.out.println(portfolio.get(i).getPrice());

        }

    }
}