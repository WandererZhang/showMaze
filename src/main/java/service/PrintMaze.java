package service;

import pojo.Maze;

/**
 * 实现打印迷宫
 *
 * @author zhang
 */
public class PrintMaze {
    public static void printMaze(Maze maze) {
        String[][] array = maze.getArray();
        for (int i = 0; i < maze.getLine(); i++) {
            for (int j = 0; j < maze.getRow(); j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
