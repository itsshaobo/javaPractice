/**
 * 首先运行该main函数，产生20,000,000个打乱的数据
 *
 * */
package DiskSort;

import java.io.*;
import java.util.*;

public class Utils {

    public static void quickSort(int [] nums) {
        //内排序，用快排，闭区间
        if(nums==null || nums.length<2) return;
        quickHelper(nums, 0, nums.length-1);
    }

    public static void quickHelper(int [] nums, int left, int right) {
        int i = left, j = right;
        while(i<j){
            while(i<j &&nums[i]<=nums[j]){
                j--;
            }
            if(i!=j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
            while(i<j && nums[i]<=nums[j]){
                i++;
            }
            if(i!=j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        int mid = i;
        if(left<i-1) quickHelper(nums, left, i-1);
        if(mid+1<right) quickHelper(nums, i+1, right);
    }

    public static boolean deleteFile(String path) {
        //删除文件或者文件夹
        File file = new File(path);
        if(!file.exists()) {
            return false;
        }
        if(file.isFile()) {
            file.delete();
        }else{
            String [] subFiles = file.list();
            for(String f:subFiles) {
                deleteFile(path+"/"+f);
            }
            file.delete();
        }
        return true;
    }

    public static void createDir(String fPath){
        //给定一个路径，创建名叫tmp的文件夹
        File file = new File(fPath);
        if(file.exists()){
            deleteFile(fPath);
        }
        file.mkdir();
    }

    public static void createData(String dir) throws IOException {
        //创建实验用的数据
        //每行10个数字，用制表符隔开
        // test.txt文件有170.9MB大小
        int TOTAL_NUMBER = 20000000;
        List<Integer> nums = new ArrayList<>();
        for(int i=0;i<TOTAL_NUMBER;i++){
            nums.add(i);
        }
        Collections.shuffle(nums);

        File file = new File(dir+"/test.txt");
        FileWriter fout = new FileWriter(file);
        for(int i=0;10*i<TOTAL_NUMBER;i++){
            for(int j=0;j<10;j++){
                fout.write(nums.get(10*i+j)+"\t");
            }
            fout.write("\n");
        }
        fout.close();
    }

    public static void writeFile(int [] num, int left, int right, String fileName)
            throws IOException{
        //将缓冲区的指定区间内的数字写入文件，左闭右开
        FileWriter fw = new FileWriter(new File(fileName));
        for(int i=left;10*i<right;i++){
            for(int j=0;j<10;j++){
               fw.write(num[10*i+j]+"\t");
            }
            fw.write("\n");
        }
        fw.close();
    }

    public static Queue<String> readIter(int iter, String tmpDir) {
        //读取第iter轮次的迭代，构建队列
        File file = new File(tmpDir);
        String filter = ".?iter"+iter+".+";
        String[] fileList = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {

                return name.matches(filter);
            }
        });
        Queue<String> queue = new LinkedList<String>();
        for(String elem:fileList) {
            queue.add(tmpDir + "/" + elem);
        }
        return queue;
    }

    public static int readBuffer(BufferedReader br, int [] nums)
            throws IOException {
        //给定一个数据流， 从文件中读取数据，返回的是读取的数字个数，如果文件中没有数据，返回0
        int n = nums.length;
        String tmp;
        String [] numList;
        int count = 0;
        while((tmp = br.readLine())!=null) {
            numList = tmp.split("\t");
            for(int i=0;i<10;i++){
                nums[count*10+i] = Integer.valueOf(numList[i]);
            }
            count++;
            if(count*10==n) return count*10;
        }
        return count*10;
    }

    public static void writePart(FileWriter fw, int [] num, int left, int right)
            throws IOException{
        //左闭右开区间
        int count = 0;
        for(int i=left;i<right;i++) {
            fw.write(num[i]+"\t");
            count++;
            if(count==10){
                fw.write("\n");
                count=0;
            }

        }
    }

    public static void main(String [] args)throws IOException {
        String dir = "/Users/shaobo/Desktop/tmp";
        createData(dir);
    }
}
