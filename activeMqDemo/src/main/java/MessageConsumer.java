import com.activemq.demo.Comsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessageConsumer {
    //消费者消费消息
    public static void main(String[] args) throws Exception{
        Comsumer comsumer = new Comsumer();
        comsumer.init();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 2; i++) {
            executorService.execute(()->{
                try {
                    comsumer.receiveMessage("zhanght");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
