import com.activemq.demo.Producter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MessageProducer {

    //生产者生产消息
    public static void main(String[] args) throws Exception {
        Producter producter = new Producter();
        producter.init();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 2; i++) {
            executorService.execute(()->{
                try {
                    producter.sendMessage("zhanght");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            Thread.sleep(1000);
        }
        executorService.shutdown();
    }
}
