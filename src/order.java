enum ordertype{
    BUY,SELL;
}


public class order {
    ordertype ordertype;
    Stock stock;
    int quantity;
    double priceToBuy;
    int userId;
    order(ordertype ordertype,Stock stock,double priceToBuy, int userId,int quantity)
    {
        this.ordertype=ordertype;
        this.stock=stock;
        this.priceToBuy=priceToBuy;
        this.userId=userId;
        this.quantity=quantity;
    }



}
