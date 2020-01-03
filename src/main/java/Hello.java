public class Hello {

    public static void testIntern() {
        String a = new String("myString"); // myString在编译时被放入常量池, a 对象放在堆中
        String b = "myString";
        String d = "my" + "String";
        String c = "hello world"; // c 代表常量池中myString的对象
        System.out.println(a.intern()==a); //false , a.intern() 返回代表常量池中myString的对象， a代表堆中的对象
        System.out.println(a.intern()==b); //true
        System.out.println(b==d);

    }

    public static int md1() {
        try{
            return 1;

        }finally{
            System.out.println("good");
            return 0;
        }
    }

    public static void main(String [] args) {
        //testIntern();
    }
}
