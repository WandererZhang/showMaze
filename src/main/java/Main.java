import pojo.Maze;
import service.InputMaze;
import service.PrintMaze;

import java.util.Scanner;

/**
 * 渲染迷宫程序的入口
 *
 * @author zhang
 */
public class Main {
    /**
     * @param args String[] args
     * @author zhang
     * @description //TODO
     * @date 23:57 2021/1/8
     **/
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            InputMaze inputMaze = new InputMaze();
            Maze maze = inputMaze.creatMaze(str1, str2, "[R]", "[W]");
            if (maze != null) {
                PrintMaze printMaze = new PrintMaze();
                printMaze.printMaze(maze);
            }
        }
    }
}
