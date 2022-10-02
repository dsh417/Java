package nk0930;

import java.util.*;
import java.util.concurrent.DelayQueue;


class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = new int[]{2,2,5};
        int target = 8;
        List<List<Integer>> res = solution.combinationSum(candidates, target);
        System.out.println("输出 => " + res);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(target<1)return new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        Deque<Integer> path=new ArrayDeque<>();
        int len=candidates.length;
        dfs(candidates,0,len,target,path,res);
        return res;
    }

    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        if(target<0){
            return;
        }
        if (target==0){
            res.add(new ArrayList<>(path));
        }

        for (int i = begin; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));

            dfs(candidates, i, len, target - candidates[i], path, res);

            path.removeLast();
            System.out.println("递归之后 => " + path);
        }
    }

}