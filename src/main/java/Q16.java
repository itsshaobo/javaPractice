import com.sun.deploy.util.StringUtils;
import com.sun.tools.javac.util.ArrayUtils;

public class Q16 {

    public double power(double base, int e) {
        if(e<0){
            return power(1/base, -e);
        }
        if(e == 0) return base == 0?0:1;
        if(e == 1) return base;
        double tmp = power(base, e>>2);
        if((e&1)==1){
            return  tmp * tmp * base;
        }else{
            return tmp * tmp;
        }
    }

    public static void main(String [] args) {
        //Q16 test = new Q16();
        //System.out.println(test.power(0, 0));
        System.out.print('s'-'a');
    }
}
