import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/9/2.
 */
public class TimerTest {

    public static void main(String[] args) {
        Timer timer = new Timer();
        //这个是用来停止此任务的，否则就一直执行这个循环

        //在1秒后执行此任务，每间隔2秒执行一次
        //如果传递一个固定的Data参数，就可以在某个固定时间执行这个任务
        timer.schedule(new MyTask(), 1000, 2000);
        while (true) {
            try {


                int in = System.in.read();
                if (in=='s') {
                    //退出任务方法
                    timer.cancel();
                    break;//跳出循环s
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class MyTask extends TimerTask {
        public void run() {
            System.out.println("我的定时任务！！！");
        }
    }

}
