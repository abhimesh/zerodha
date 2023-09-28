public class Validate_Order {
    order order;

    Validate_Order(order order)
    {
        this.order=order;
    }
    boolean validity(order order)
    {
        user user=userManager.getInstance().getUser(order.userId);
        double priceTobuysell=order.priceToBuy;
        double stockPrice=order.stock.getPrice();
        if(priceTobuysell!=stockPrice)
        {
            System.out.println("stockprice and your price to BUY/SELL is not matching");
            return false;
        }
        if(order.ordertype.equals(ordertype.BUY))
        {
            if(order.quantity*stockPrice<=user.getBalance())
            {
                return true;
            }
            else {System.out.println("you current balance is low");
                return false;}
        }
        else {
            return true;
        }
    }
}
