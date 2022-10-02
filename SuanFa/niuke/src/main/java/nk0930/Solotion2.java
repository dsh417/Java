package nk0930;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solotion2 {
    public static void main(String[] args) {
        long be=System.currentTimeMillis();

        Solotion2 solution = new Solotion2();
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        List<List<Integer>> res = solution.combinationSum(candidates, target);
        System.out.println("输出 => " + res+"\nsize："+res.size());

        long ed=System.currentTimeMillis();
        System.out.println("非剪枝算法耗时："+(ed-be));

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len=candidates.length;
        Deque<Integer> path=new ArrayDeque<>();
        List<List<Integer>> res=new ArrayList<>();
        dfs(candidates,0,len,target,path,res);
        return res;
    }

    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        if(target<0)return;
        if(target==0)res.add(new ArrayList<>(path));


        for (int i = begin; i < len; i++) {
            System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));
            path.addLast(candidates[i]);
//            begin在循环到len，调i
            dfs(candidates,i,len,target-candidates[i],path,res);
            path.removeLast();
            System.out.println("递归之后 => " + path);
        }

    }
}
