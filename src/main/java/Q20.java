public class Q20 {

    public boolean isNumeric(String str) {
        if(str==null || str.length()==0) return false;
        int [] pos = new int[]{0}; //用数组保存遍历的下标，因为在传递到函数的时候可以改变他的值
        boolean isNum = isSignedNum(str, pos); //开头是有符号数
        if(pos[0] < str.length() && str.charAt(pos[0])=='.'){ // 如果有'.' 后面需要接无符号数
            pos[0]++;
            isNum = isNum && isUnsignedNum(str, pos);
        }
        if(pos[0] < str.length() && (str.charAt(pos[0])=='e' || str.charAt(pos[0])=='E')){ // 'e'后面跟有符号数
            pos[0]++;
            isNum = isNum && isSignedNum(str, pos);
        }
        if(pos[0] == str.length()) {
            return isNum;
        }else{
            return false;
        }
    }

    public boolean isUnsignedNum(String str, int[] pos) {
        //无符号整数
        int tmp = pos[0];
        while(tmp<str.length() && str.charAt(tmp)>='0' && str.charAt(tmp)<='9'){
            tmp++;
        }
        if(tmp==pos[0]){
            return false;
        }else{
            pos[0] = tmp;
            return true;
        }
    }

    public boolean isSignedNum(String str, int[] pos) {
        //有没有符号都可以
        if(str.charAt(pos[0])=='+' || str.charAt(pos[0])=='-'){
            pos[0]++;
        }
        return isUnsignedNum(str, pos);
    }

    public static void main(String [] args) {
        Q20 test = new Q20();
        System.out.println(test.isNumeric("-1E-16"));
    }
}
