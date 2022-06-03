import java.util.LinkedList;

public class BFS {
    public static void main(String[] args) {
        int[][] map = {
                {0, 1, 1, 1, 1},
                {0, 0, 1, 1, 1},
                {1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
        };
        new BFS().findNode(map);
    }

    class Node {
        int x;
        int y;
        int dis;
        Node pre;

        public Node(int x1, int y1, int dis1, Node pre1) {
            this.x = x1;
            this.y = y1;
            this.dis = dis1;
            this.pre = pre1;
        }
    }

    public void findNode(int[][] map) {
        int[][] dir = {
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };
        LinkedList<Node> queue = new LinkedList<Node>();
        Node node = new Node(0, 0, 0, null);
        queue.add(node);
        map[0][0] = 1;

        Node temp = null;

        while (!queue.isEmpty()) {
            temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = dir[i][0] + temp.x;
                int newY = dir[i][1] + temp.y;
                if (newX < 0 || newX > 3 || newY < 0 || newY > 4) {
                    continue;
                }
                if(map[newX][newY]==1){
                    continue;
                }

                Node node1 = new Node(newX, newY, temp.dis + 1, temp);

                if (newX == 3 && newY == 4) {
                    queue.clear();
                    queue.offer(node1);
                    Node node2 = node1.pre;
                    while (node2 != null) {
                        queue.offer(node2);
                        node2 = node2.pre;
                    }
                    int len = queue.size();
                    System.out.print("长度：" + (len-1));
                    while (!queue.isEmpty()) {
                        Node node3 = queue.poll();
                        System.out.print("(" + node3.x + "," + node3.y + ")");
                    }
                    break;
                }
                map[newX][newY] = 1;
                queue.add(node1);
            }
        }
    }
}
