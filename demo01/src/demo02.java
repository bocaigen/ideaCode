import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/20.
 */
public class demo02 {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("++++++++="+date);
        String format = df.format(date);
        System.out.println("========+"+format);
        Date date1 = df.parse(format);
        System.out.println("--------="+date1);
        int i = 100;
        i+=200;
        System.out.println(i);

    }
}
