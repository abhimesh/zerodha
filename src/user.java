import java.util.ArrayList;
import java.util.List;

public class user {
    private String Name;
    private double currentBalance;
    private List<Stock> portfolio;

    user(String Name)
    {
        this.Name=Name;
        currentBalance=0;
        portfolio=new ArrayList<>();
    }
    public void addBalance(int a)
    {
        currentBalance+=a;
    }
    public double getBalance()
    {
        return currentBalance;
    }
    public  void addStock(Stock stock)
    {
        portfolio.add(stock);
    }
    public void removeStock(Stock stock)
    {
        portfolio.remove(stock);
    }
    public List<Stock> getPortfolio()
    {
        return portfolio;
    }

}
