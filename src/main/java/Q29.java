public class Q29 {

    public void printMatClockWise(int [][] mat) {
        int m = mat.length, n = mat[0].length;
        int [] start = {0,0}, end = {m-1,n-1};
        while(start[0]<=end[0] && start[1]<=end[1]){
            printRound(mat, start[0], start[1], end[0], end[1]);
            start[0]++;
            start[1]++;
            end[0]--;
            end[1]--;
        }
    }

    public void printRound(int [][] nums, int startR, int startC, int endR, int endC) {
        //都是闭区间
       // System.out.println("test");
        for(int i=startC;i<=endC;i++) System.out.printf("%d\t",nums[startR][i]);
        //System.out.println("1");
        for(int i=startR+1;i<=endR;i++) System.out.printf("%d\t",nums[i][endC]);
        //System.out.println("2");
        if(startR!=endR){
            for(int i=endC-1;i>=startC;i--) System.out.printf("%d\t",nums[endR][i]);
        }
        if(startC!=endC){
            for(int i=endR-1;i>startR;i--) System.out.printf("%d\t",nums[i][startC]);
        }
    }

    public static void main(String [] args) {
        Q29 test = new Q29();
        test.printMatClockWise(new int[][]{{1}});
    }

}
