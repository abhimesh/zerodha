import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class userManager {
    static int userId = 0;
    private static userManager obj = null;

    //userId,user
    private Map<Integer, user> userMap;

    private userManager() {
        userMap = new HashMap<>();

    }

    static ReentrantLock lock=new ReentrantLock();

    public static userManager getInstance() {
        if (obj == null) {
            lock.lock();
            if (obj == null) {
                obj = new userManager();
            }
            lock.unlock();

        }
        return obj;
    }

    void addUser(user user)
    {
        userId++;
        userMap.put(userId,user);
    }

    public user getUser(int userId)
    {
        return userMap.get(userId);
    }
    public void putUser(int userId,user user)
    {
        userMap.replace(userId,user);
    }
}
