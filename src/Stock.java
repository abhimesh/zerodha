public class Stock {
    String stockName;
    private int price;
    Stock(String stockName,int price)
    {
        this.stockName=stockName;
        this.price=price;
    }

    public int getPrice() {
        return price;
    }
}
