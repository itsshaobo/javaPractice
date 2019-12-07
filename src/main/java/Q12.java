public class Q12 {

    int [][] directions = new int[][]{{-1, 0},{1, 0},{0, -1},{0, 1}};
    public boolean pathInMat(char [][] mat, String target) {
        int [][] used = new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] == target.charAt(0)){
                    if(backTrack(mat, target ,used, i ,j, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean backTrack(char[][] mat, String target, int[][] used, int i, int j, int pos){
        if(pos >= target.length()){
            return true;
        }
        int [] tmp = new int[]{0,0};
        for(int [] dir:directions){
            tmp[0] = i + dir[0];
            tmp[1] = j + dir[1];
            if(tmp[0]>=0 && tmp[0]<mat.length && tmp[1]>=0 && tmp[1]<mat[0].length
                    && used[tmp[0]][tmp[1]]==0 && mat[tmp[0]][tmp[1]]==target.charAt(pos+1)){
                used[tmp[0]][tmp[1]] = 1;
                if(backTrack(mat, target, used, tmp[0], tmp[1], pos+1)){
                    return true;
                }
                used[tmp[0]][tmp[1]] = 0;
            }
        }
        return false;
    }
}
