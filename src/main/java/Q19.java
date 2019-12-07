public class Q19 {
    // 正则表达式 实现 * 和 . 的匹配 . 代表任意一个字符 * 代表前面的字符出现任意次

    public boolean regMatch(String pattern, String target) {
        return backTrack(pattern, target, 0 ,0);
    }

    public boolean backTrack(String pattern, String target, int pos1, int pos2){
        // 退出条件
        if(pos1 == pattern.length() && pos2 == target.length()) {
            return  true;
        }
        if(pos1 == pattern.length() && pos2 < target.length()){
            return false;
        }

        if(pos1<pattern.length()-1 && pattern.charAt(pos1+1) == '*'){
            // 匹配0个，匹配1个， 匹配多个
            //当target达到最后， pattern没有达到最后时，匹配成功的情况只能是pattern后面有足够的*
            if(pos2<target.length()
                    && (pattern.charAt(pos1)=='.' || pattern.charAt(pos1)==target.charAt(pos2))){
                if(backTrack(pattern, target, pos1+2, pos2+1) //匹配1个
                        || backTrack(pattern, target, pos1+2, pos2) //匹配0个
                        || backTrack(pattern, target, pos1, pos2+1)){ //匹配多个
                    return true;
                }
            }else{
                if(backTrack(pattern, target, pos1+2, pos2)){ //匹配0个
                    return true;
                }
            }
        }else{
            if(pos2<target.length()
                    && (pattern.charAt(pos1)=='.' || pattern.charAt(pos1)==target.charAt(pos2))){
                if(backTrack(pattern, target, pos1+1, pos2+1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String [] args) {
        Q19 test = new Q19();
        System.out.println(test.regMatch(".*","aaa"));
    }
}