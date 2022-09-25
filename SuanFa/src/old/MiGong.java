package old;

import java.util.LinkedList;

public class MiGong {
    public static void main(String[] args) {
        int[][] array = {
                {0,0,0,0,1,1,0,0},
                {0,1,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0},
                {0,1,0,0,1,1,0,0}
        };
        new MiGong().findMinRold(array);
    }

    //定义图的节点信息
    class Node {
        //定义坐标和距离第一个节点的距离
        int x;
        int y;
        int dis;
        //定义节点的前缀，用于绘制整个最短路径的  线路图
        Node pre;

        public Node(int x, int y, int dis, Node pre) {
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.pre = pre;
        }
    }

    public void findMinRold(int[][] arr) {
        //定义  上下左右四个方向
        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        //创建队列
        LinkedList<Node> queue = new LinkedList<Node>();
        //创建开始节点
        Node start = new Node(0, 0, 0, null);
        //把开始节点放入队列中，并做下标记，在原来数组中做标记
        queue.offer(start);
        arr[0][0] = 1;//修改位置，标识已经遍历设置为1
        //循环操作队列，进行广度遍历
        Node temp = null;
        ok:
        while (!queue.isEmpty()) {
            temp = queue.poll();//移除头部元素
            //依次遍历这个节点的四个方向，查找还没有遍历的相连节点
            for (int i = 0; i < 4; i++) {
                int newX = temp.x + direction[i][0];//标识x坐标移动 direction[i][0]
                int newY = temp.y + direction[i][1];//标识x坐标移动 direction[i][1]
                //此时表示  arr[temp.x][temp.y ]移动到了arr[newX][newY]
                //是否越界，坐标
                if (newX < 0 || newX >= 4 || newY < 0 || newY >= 8) {
                    continue;
                }
                //判断是否该节点可以通过，即为0
                if (arr[newX][newY] == 1) {
                    continue;
                }
                //构造节点
                Node next = new Node(newX, newY, temp.dis + 1, temp);
                //该节点可以通过，判断该节点是否是最终节点

                if (newX == 3 && newY == 7) {
                    queue.clear();
                    //相当于头插法，转置
                    queue.offerFirst(next);
                    Node preNode = next.pre;
                    while (preNode != null) {
                        queue.offerFirst(preNode);
                        preNode = preNode.pre;
                    }
                    int len = queue.size();
                    System.out.println("最短路径长度为：" + (len - 1));
                    for (Node it : queue) {
                        System.out.println("(" + it.x + "," + it.y + ") ");
                    }
                    break ok;
                }
                arr[newX][newY] = 1;
                queue.offer(next);//队尾插入
            }//for

        }//while

    }

}
