import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class orderManager {
    private static orderManager obj=null;
    static int orderId=0;

    //orderId,order
    private Map<Integer,order> orderMap;
    private orderManager(){
        orderMap=new HashMap<>();
    }



    static ReentrantLock lock=new ReentrantLock();
    public static orderManager getInstance()
    {
        if(obj==null)
        {
            lock.lock();
            if(obj==null)
            {
                obj=new orderManager();
            }
            lock.unlock();

        }
        return obj;
    }
     public void addOrders(order order)
     {
         orderId++;
         orderMap.put(orderId,order);
     }
     public order getorder(int orderId)
     {
         return orderMap.get(orderId);
     }

    void executeOrder(order order)
    {
        Validate_Order validateOrder=new Validate_Order(order);
        if(!validateOrder.validity(order))
        {
            System.out.println("order cannot be executed");
            return;
        }
        user user=userManager.getInstance().getUser(order.userId);
        if(order.ordertype.equals(ordertype.SELL))
        {
            user.addBalance((int) (order.quantity*order.priceToBuy));
            user.removeStock(order.stock);
            userManager.getInstance().putUser(order.userId, user);
            System.out.println("Your sell order is successfully executed");
        }
        else {
            user.addBalance((int) (-1*(order.quantity*order.priceToBuy)));
            user.addStock(order.stock);
            userManager.getInstance().putUser(order.userId, user);
            System.out.println("Your buy order is successfully executed");
        }

    }

}
