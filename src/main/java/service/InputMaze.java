package service;

import pojo.Maze;

import java.util.regex.Pattern;

/**
 * 实现输入并生成迷宫
 *
 * @author zhang
 */
public class InputMaze {

    static final int LINE_AND_ROW_LENGTH = 2;
    //第一行应该有两个数据分别为行和列

    /**
     * @param str1 输入行和列
     * @param str2 输入连通性
     * @param strRoad 用于表示道路的字符
     * @param strWall 用于表示墙壁的字符
     * @return pojo.Maze 若创建Maze对象失败则返回null
     * @author zhang
     * @description 用于创建Maze对象
     * @date 23:52 2021/1/8
     **/
    public static Maze creatMaze(String str1, String str2, String strRoad, String strWall) {
        String[] lineAndRow = str1.split(" ");
        String[] connect = str2.split(";");
        if ((!judgeLineAndRow(lineAndRow)) || (!judgeConnect(connect))) {
            return null;
        }
        Maze maze = new Maze(Integer.valueOf(lineAndRow[0]), Integer.valueOf(lineAndRow[1]), strRoad, strWall);
        addPoint(maze);
        return CreatConnect.creatConnect(maze, connect);
    }

    /**
     * @param lineAndRow 经过切分的行与列的String数组
     * @return boolean true为合法,false非法
     * @author zhang
     * @description 判断行和列输入是否合法
     * @date 23:47 2021/1/8
     **/
    private static boolean judgeLineAndRow(String[] lineAndRow) {
        if (lineAndRow.length != LINE_AND_ROW_LENGTH) {
            System.err.println("Incorrect command format");
            return false;
        }
        String regex = "^[0-9]*[1-9][0-9]*$";
        //用于匹配输入的数字是否为正整数的正则表达式
        Pattern pattern = Pattern.compile(regex);
        for (String s : lineAndRow) {
            if (!pattern.matcher(s).find()) {
                System.err.println("Invalidnumber format");
                return false;
            }
        }
        return true;
    }

    /**
     * @param connect 经过切分的连通性的String数组
     * @return boolean true为合法,false非法
     * @author zhang
     * @description 判断连通性输入是否合法
     * @date 0:40 2021/1/9
     **/
    private static boolean judgeConnect(String[] connect) {
        if (connect.length == 0) {
            //连通性数组不存在时返回false
            System.err.println("Incorrect command format");
            return false;
        }
        String regex = "\\d+,\\d+ \\d+,\\d+";
        //用于匹配输入是否为有效格式的数字的正则表达式
        Pattern pattern = Pattern.compile(regex);
        for (String s : connect) {
            if (!pattern.matcher(s).find() || "".equals(s)) {
                System.err.println("Invalidnumber format");
                return false;
            }
        }
        return true;
    }

    /**
     * @param maze 迷宫的对象实体
     * @return void
     * @author zhang
     * @description 初始化渲染迷宫
     * @date 3:22 2021/1/9
     **/
    private static void addPoint(Maze maze) {
        String[][] array = maze.getArray();
        for (int i = 0; i < maze.getLine(); i++) {
            for (int j = 0; j < maze.getRow(); j++) {
                if (i % 2 == 1 && j % 2 == 1) {
                    array[i][j] = maze.getStrRoad();
                } else {
                    array[i][j] = maze.getStrWall();
                }
            }
        }
        maze.setArray(array);
    }
}
