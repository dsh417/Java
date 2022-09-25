package old;

import java.util.LinkedList;

public class Test016 {

    static class Node {
        int x;
        int y;
        int num;

        Node(int xtmep, int ytemp, int numtemp) {
            x = xtmep;
            y = ytemp;
            num = numtemp;
        }
    }

    public static int bfs(int map[][], int max) {
        //
        int [][]fx= {
                {0,1},
                {1,0}};
        LinkedList<Node> queue = new LinkedList<>();
        Node node_go = new Node(0, 0, 0);
        queue.add(node_go);
        map[0][0] = 0;
        while (!queue.isEmpty()) {
            Node popNode = queue.pop();
            for (int i = 0; i < 2; i++) {
                Node Newpop = popNode;
                popNode.x += fx[i][0];
                popNode.y += fx[i][1];
                if (popNode.x > 9 || popNode.y > 9) continue;
                if (map[popNode.x][popNode.y] == -1) continue;
                popNode.num += map[popNode.x][popNode.y];
                if (popNode.x == 9 && popNode.y == 9) {
                    if(popNode.num>max)max=popNode.num;
                }
                map[popNode.x][popNode.y] = -1;
                queue.add(popNode);
            }
        }
        return max  ;
    }

    public static void main(String[] args) {
        //  int mg[][]=new int [10][10];
        String mg =
                        "1235442432" +
                        "9235442432" +
                        "9235442432" +
                        "9235442432" +
                        "9235442432" +
                        "9235442432" +
                        "9235442432" +
                        "9235442432" +
                        "9235442432" +
                        "9235442431";

        System.out.println(mg);
        int map[][] = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                map[i][j] = mg.charAt(i * 10 + j);
            }
        }

        System.out.println(bfs(map,0));
    }
}
