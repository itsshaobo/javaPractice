/**
 * 外部排序的二路归并实现
 * 数据格式为 每行10个数字，数字之间用制表符隔开
 *
 * 输出为保存在同级目录下 tmp文件夹中的文件
 * **/
package DiskSort;

import java.io.*;
import java.util.Queue;

public class DiskSort {

    public int BUFFER_SIZE = 1000000; //缓冲区大小
    public String tmpDir;
    public DiskSort(String dirName){
        tmpDir = dirName +"/tmp";
    }

    public void readSource(String dirName, String sourceName) throws Exception {
        //读取原始文件，每次读取1000000条数据，内排序后放入sourceFile同级目录的tmp文件夹下
        /**
         * 1. 创建目录
         * 2. 构建数据流，每读出1000,000个数字，就将其放入一个文件中
         * */
        Utils.createDir(tmpDir);
        BufferedReader br = new BufferedReader(new FileReader(dirName + "/" + sourceName));
        int [] nums = new int[BUFFER_SIZE];
        int count = 0;
        int FileNumber = 1;
        String tmp;
        String [] numStrings;
        while((tmp=br.readLine())!=null) {
            numStrings = tmp.split("[\t\n]+");
            for(int i=0;i<numStrings.length;i++){
                nums[count*10+i] = Integer.valueOf(numStrings[i]);
            }
            count++;
            if(count==BUFFER_SIZE/10) {
                //内部排序，这里用的是快排
                Utils.quickHelper(nums, 0, BUFFER_SIZE-1);
                //写入文件的格式为 iter1_1 表示第一轮的第1个文件
                String baseName = tmpDir + "/iter1_";
                Utils.writeFile(nums, 0, BUFFER_SIZE,baseName+FileNumber);
                count=0;
                FileNumber++;
            }
        }
        if(count!=0){
            //文件数据条目数不是10,0000的整数倍时
            //写入最后一个文件
            Utils.quickHelper(nums, 0, count*10-1);
            String baseName = tmpDir + "/iter1_";
            Utils.writeFile(nums, 0, count*10,baseName+FileNumber);
        }
    }


    public void oneIter(int iter) throws Exception {
        //一轮迭代，每次读取两个文件；iter表示要读取文件的迭代轮次
        /**
         * 1.读取文件列表，构建队列
         * 2.每次从队列中取两个文件处理啊，合并
         *          在这两个文件中，每次读出25,0000个数字   合并后的缓冲区大小为500,000
         *
         * 3.删除已经读取的文件
         * */
        Queue<String> queue = Utils.readIter(iter, tmpDir);
        int [] num1 = new int[BUFFER_SIZE/4];
        int [] num2 = new int[BUFFER_SIZE/4];
        int [] mergeNum = new int[BUFFER_SIZE/2];
        int curIter = iter+1;
        int fileNumber = 1;
        String file1;
        String file2;
        BufferedReader br1;
        BufferedReader br2;
        FileWriter fw;
        while(!queue.isEmpty() && queue.size()>1){
            file1 = queue.poll();
            file2 = queue.poll();
            br1 = new BufferedReader(new FileReader(file1));
            br2 = new BufferedReader(new FileReader(file2));
            fw = new FileWriter(tmpDir+"/iter"+curIter+"_"+ fileNumber);
            int i=0,j=0,k=0;
            int size1 = Utils.readBuffer(br1, num1);
            int size2 = Utils.readBuffer(br2, num2);
            while(size1!=0 && size2!=0){ //有一个文件写完就可以退出循环
                while(i<size1 && j<size2) {
                    if(num1[i]>num2[j]){
                        mergeNum[k] = num2[j];
                        j++;
                    }else{
                        mergeNum[k] = num1[i];
                        i++;
                    }
                    k++;
                    if(k == BUFFER_SIZE/2) {
                        // 将mergeNum中的文件写入fw中
                        Utils.writePart(fw, mergeNum, 0, k);
                        k=0;
                    }

                }
                //当缓冲区的数据用完后，从文件中读取数据
                if(i==size1) {
                    size1 = Utils.readBuffer(br1, num1);
                    i=0;
                }
                if(j==size2) {
                    size2 = Utils.readBuffer(br2, num2);
                    j=0;
                }
            }
            while(size1!=0) { //将file1中的内容复制
                while(i<size1) {
                    mergeNum[k] = num1[i];
                    i++;
                    k++;
                    if(k== BUFFER_SIZE/2) {
                        // 将mergeNum中的文件写入fw中
                        Utils.writePart(fw, mergeNum, 0, k);
                        k=0;
                    }
                }
                if(i==size1) {
                    size1 = Utils.readBuffer(br1, num1);
                    i=0;
                }
            }
            while(size2!=0) { //将file2中的内容复制
                while(j<size2) {
                    mergeNum[k] = num2[j];
                    j++;
                    k++;
                    if(k== BUFFER_SIZE/2) {
                        // 将mergeNum中的文件写入fw中
                        Utils.writePart(fw, mergeNum, 0, k);
                        k=0;
                    }
                }
                if(j==size2) {
                    size2 = Utils.readBuffer(br2, num2);
                    j=0;
                }
            }

            if(k!=0) {
                //如果有余数的情况下，还要将剩下的数写进文件中
                Utils.writePart(fw, mergeNum, 0, k);
                k=0;
            }
            //此时已经完成两个文件的合并
            //关闭流，并删除文件
            br1.close();
            br2.close();
            fw.close();
            System.out.printf("%s && %s ---> %d\n",file1, file2, fileNumber);
            //删除文件
            File f1 = new File(file1);
            f1.delete();
            f1 = new File(file2);
            f1.delete();
            fileNumber++;
        }
        //如果还剩下一个文件，需要改该文件的文件名，以便下次迭代
        if(queue.size()==1) {
            file1 = queue.poll();
            File f = new File(file1);
            String destName = tmpDir + "/iter"+curIter+"_"+fileNumber;
            f.renameTo(new File(destName));
        }
    }

    public void diskSort() throws Exception {
        //计算迭代次数
        File f = new File(tmpDir);
        int n = f.list().length;
        int count = 1;
        while(n>1) {
            oneIter(count);
            System.out.print(count);
            count++;
            n = (n+1) /2;
        }
    }

    public static void main(String [] args) throws Exception {
        DiskSort test = new DiskSort("/Users/shaobo/Desktop/tmp");
        test.readSource("/Users/shaobo/Desktop/tmp", "test.txt");
        test.diskSort();
    }

}
