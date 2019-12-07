public class Q13 {

    int[][] directions = new int[][]{{-1, 0},{1, 0},{0, -1},{0, 1}};
    public int movCount(int threshold, int m ,int n) {
        //查看机器人能走到哪
        int [][] used = new int[m][n];
        used[0][0] = 1;
        return backTrack(used, 0, 0, m, n, threshold);

    }

    public int backTrack(int [][] used, int i, int j, int m, int n, int threshold){
        // 如果当前位置不可以， 返回0, 否则递归
        int count = 1;
        for(int [] dir:directions){
            int i1 = i+dir[0];
            int j1 = j+dir[1];
            if(checkpossible(used, i1, j1, m, n, threshold)){
                System.out.printf("%d\t%d\n",i,j);
                used[i1][j1] = 1;
                count += backTrack(used, i1, j1, m, n, threshold);
            }
        }
        return count;
    }

    public boolean checkpossible(int [][] used, int i, int j, int m, int n, int threshold){
        int base = 0;
        if(i<0 || i>= m || j<0 || j>= n) return false;
        if(used[i][j] == 1) return false;
        for(char elem:String.valueOf(i).toCharArray()){
            base += Integer.valueOf(""+elem);
        }
        for(char elem:String.valueOf(j).toCharArray()){
            base += Integer.valueOf(""+elem);
        }
        if(base > threshold){
            return false;
        }
        return true;
    }

    public static void main(String [] args) {
        Q13 test = new Q13();
        System.out.println(test.movCount(100, 6, 7));
    }
}
