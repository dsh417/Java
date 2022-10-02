package nk0930;

import java.util.*;

public class Solotion3 {
//    带剪枝算法的动态规划
    public static void main(String[] args) {
        long be=System.currentTimeMillis();

        Solotion3 solution = new Solotion3();
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        List<List<Integer>> res = solution.combinationSum(candidates, target);
        System.out.println("输出 => " + res+"\nsize："+res.size());

        long ed=System.currentTimeMillis();
        System.out.println("剪枝算法耗时："+(ed-be));

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len=candidates.length;
        Arrays.sort(candidates);
        Deque<Integer> path=new ArrayDeque<>();
        List<List<Integer>> res=new ArrayList<>();
        dfs(candidates,0,len,target,path,res);
        return res;
    }

    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
//        剪纸在后面，这里不需要小于0判
        if(target==0)res.add(new ArrayList<>(path));


        for (int i = begin; i < len; i++) {
//            剪枝算法
            if(target-candidates[i]<0)break;

            System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));
            path.addLast(candidates[i]);
//            begin在循环到len，调i
            dfs(candidates,i,len,target-candidates[i],path,res);
            path.removeLast();
            System.out.println("递归之后 => " + path);
        }

    }
}
