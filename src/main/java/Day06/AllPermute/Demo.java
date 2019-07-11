package Day06.AllPermute;


import org.junit.Test;

import java.util.*;

/**
 * @author MyuTang
 * @title
 * @package Day06.AllPermute
 * @date 2019/7/10 19:55
 */
public class Demo {
    public static void main(String[] args) {
        int[] num = new int[]{1,2,3,4};
        Demo demo  = new Demo();
        List<List<Integer>> permute = demo.permute(num);

        System.out.println();
    }
    public List<List<Integer>> permute(int[] num){
        List<List<Integer>> list = new ArrayList<>();
        if(num.length==0) return list;
        List<Integer> arr = new ArrayList<>();
        boolean[] used = new boolean[num.length];
        permuteCore(list,arr,0,num,used);
        return list;
    }
    public void permuteCore(List<List<Integer>> list ,List<Integer> arr,int start,int[] nums,boolean[] used){
        if(start==nums.length){
            list.add(new ArrayList<>(arr));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]==false) {
                arr.add(nums[i]);
                used[i]=true;
                permuteCore(list,arr,start+1,nums,used);
                arr.remove(arr.size()-1);
                used[i]=false;
            }
        }
    }

    //给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合
    @Test public void test(){
        int k = 5;
        int n = 10;
        System.out.println(combine(k,n));
    }
    public List<List<Integer>> combine(int k ,int n){
        List<List<Integer>> list = new ArrayList<>();
        if(n==0) return  list;
        Stack<Integer> stack = new Stack<>();
        combineCore(list,stack,1,k,n);

        return list;
    }
    public void combineCore(List<List<Integer>> list,Stack<Integer> stack,int start,int k,int n ){
        if(stack.size()==k){
            list.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i <= n-(k-stack.size())+1; i++) {
            stack.push(i);
            combineCore(list,stack,i+1,k,n);
            stack.pop();
        }
    }
    @Test
    public void test2(){
        int k = 3;
        int n = 7;

    }
    public List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDup(ans,arr,nums,0);
        return ans;
    }
    public void subsetsWithDup(List<List<Integer>> list,List<Integer> arr,int[] nums,int start){
        list.add(new ArrayList<>(arr));
        for(int i =start ;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]){
                continue;
            }
            arr.add(nums[i]);
            subsetsWithDup(list,arr,nums,i+1);
            arr.remove(arr.size()-1);
        }
    }

}
