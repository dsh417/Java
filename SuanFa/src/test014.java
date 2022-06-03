//import java.util.HashSet;
//import java.util.LinkedList;
////动态规划
//
////小蓝学习了最短路径之后特别高兴，他定义了一个特别的图，希望找到图 中的最短路径。
////
////小蓝的图由 2021 个结点组成，依次编号 1 至 2021。
////
////对于两个不同的结点 a, b，如果 a 和 b 的差的绝对值大于 21，则两个结点 之间没有边相连；如果 a 和 b 的差的绝对值小于等于 21，则两个点之间有一条 长度为 a 和 b 的最小公倍数的无向边相连。
////
////例如：结点 1 和结点 23 之间没有边相连；结点 3 和结点 24 之间有一条无 向边，长度为 24；结点 15 和结点 25 之间有一条无向边，长度为 75。
////
////请计算，结点 1 和结点 2021 之间的最短路径长度是多少。
////答案：10266837
//
//
////len(go,end)
////表示，两个节点间最小距离
////f(queue,value,go,end)=f(queue,value+len(go-end),go+，end=go+)
////函数保存一个栈。栈里保存路径
////value保存到当前点，最短路径长度
////go表示当前节点
////end表示下一个节点最大值
////
//public class test014 {
//
////    class Node{
////        int n=0;
////        Node last=null;
////
////
////    }
//
//    public int getGCD(int a,int b){
//        //获得最小公倍数
//    }
//
//    public void fun(LinkedList<Integer> queue,int value,int go,int end){
//        if(end>2021)return;
//        if(end>go+21)return;
//
//        for(int i=1;i<=21;i++){
//            fun(queue.add(new Integer(i)),value+=getGCD(go,go+i),go+i,end);
//        }
//    }
//    public static void main(String[] args) {
//
//        LinkedList<Integer> queue = new LinkedList<Integer>();
//
//
//
//
//
//    }
//
//
//}
