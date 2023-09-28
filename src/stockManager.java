import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class stockManager {

    private static stockManager obj=null;
    private Map<Integer,Stock> stockMap;
    static ReentrantLock lock=new ReentrantLock();
    static private int stockId=0;
    private stockManager(){
        stockMap=new HashMap<>();

    }

    public static stockManager getInstance() {
        if(obj==null)
        {
            lock.lock();
            if(obj==null)
            {
                obj=new stockManager();
            }
            lock.unlock();
        }
        return obj;

    }
    
    public void addStack(Stock stock)
    {
        stockId++;
        stockMap.put(stockId,stock);
    }

    public Stock getStock(int id)
    {
        return stockMap.get(id);
    }




}
