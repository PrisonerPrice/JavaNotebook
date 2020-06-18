package SomeProblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Question3 {

    /*
    Question:
    Start from map[0][0]
    map[x][y] == 1 --> can walk
    map[x][y] == 0 --> cannot walk
    map[x][y] == 9 --> destination
    find min steps, if does not exist, return -1;
     */

    public static int findMinPath(int[][] map) {
        if(map == null || map.length == 0 || map[0].length == 0) return -1;

        boolean[][] visited = new boolean[map.length][map[0].length];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0));

        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            int row = curr.row;
            int col = curr.col;
            int steps = curr.steps;
            visited[row][col] = true;

            if(map[row][col] == 9) return curr.steps;

            if(row - 1 >= 0 && !visited[row - 1][col] && map[row - 1][col] != 0)
                queue.offer(new Node(row - 1, col, steps + 1));
            if(row + 1 < map.length && !visited[row + 1][col] && map[row + 1][col] != 0)
                queue.offer(new Node(row + 1, col, steps + 1));
            if(col - 1 >= 0 && !visited[row][col - 1] && map[row][col - 1] != 0)
                queue.offer(new Node(row, col - 1, steps + 1));
            if(col + 1 < map[0].length && !visited[row][col + 1] && map[row][col + 1] != 0)
                queue.offer(new Node(row, col + 1, steps + 1));

        }

        return -1;
    }

    public static class Node{
        int row;
        int col;
        int steps;

        public Node(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }

    public static void main(String[] args) {
        int[][] test1 = new int[][]{{1, 0, 0}, {1, 1, 0}, {1, 9, 0}};
        int[][] test2 = new int[][]{{1, 1, 1, 1}, {0, 0, 1, 1}, {1, 1, 0, 1}, {9, 1, 1, 1}};
        int[][] test3 = new int[][]{{}, {}};
        int[][] test4 = new int[][]{{1, 1, 1, 1}, {0, 0, 0, 0}, {1, 1, 1, 9}};
        test(test1);
        test(test2);
        test(test3);
        test(test4);
    }

    public static void test(int[][] input) {
        for(int[] line : input) {
            String s = "[";
            for(int i : line) {
                s += i;
            }
            s += "]";
            System.out.println(s);
        }
        System.out.println(findMinPath(input));
    }
}
