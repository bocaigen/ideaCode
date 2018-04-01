import java.util.Scanner;
import java.util.Timer;

/**
 * Created by Administrator on 2017/9/2.
 */
public class TimerTest2 {

    public static void main(String[] args){
        timerTest2();
    }
//    @Test
    public static void timerTest2(){
        Timer timer = new Timer();
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.HOUR_OF_DAY,11);
//        calendar.set(Calendar.MINUTE,55);
//        calendar.set(Calendar.SECOND,5);
//        Date time = calendar.getTime();
        timer.schedule(new MyTask2(), 1000,2000);

        while (true){
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            if(s=="s"){
                timer.cancel();
                break;
            }
        }
    }
}
