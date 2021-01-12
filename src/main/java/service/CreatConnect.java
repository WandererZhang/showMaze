package service;

import lombok.AllArgsConstructor;
import lombok.Data;
import pojo.Maze;

/**
 * 实现添加迷宫的连通性
 *
 * @author zhang
 */
public class CreatConnect{
    @Data
    @AllArgsConstructor
    static class ConnectPair {
        Pair first;
        Pair last;
    }

    @Data
    @AllArgsConstructor
    static class Pair {
        int line;
        int row;
    }

    /**
     * @param maze    初始化好的maze实体对象
     * @param connect 连通性数组
     * @return pojo.Maze 若添加连通性不成功则返回null
     * @author zhang
     * @description 为初始化后的maze添加连通性
     * @date 1:47 2021/1/10
     **/
    public static Maze creatConnect(Maze maze, String[] connect) {
        for (String s : connect) {
            ConnectPair connectPair = creatConnectPair(s);
            if (!judgeConnectPair(connectPair, maze)) {
                return null;
            }
            int connectLine = connectPair.first.getLine() + connectPair.last.getLine() + 1;
            int connectRow = connectPair.first.getRow() + connectPair.last.getRow() + 1;
            String[][] curMaze = maze.getArray();
            curMaze[connectLine][connectRow] = maze.getStrRoad();
            maze.setArray(curMaze);
        }
        return maze;
    }

    /**
     * @param connectStr 连通性数组元素
     * @return service.CreatConnect.ConnectPair 自定义的连通性坐标对象
     * @author zhang
     * @description 通过连通性数组创建自定义的连通性坐标对象
     * @date 1:48 2021/1/10
     **/
    private static ConnectPair creatConnectPair(String connectStr) {
        String[] str = connectStr.split(" ");
        String[] firstStr = str[0].split(",");
        String[] lastStr = str[1].split(",");
        Pair first = new Pair(Integer.parseInt(firstStr[0]), Integer.parseInt(firstStr[1]));
        Pair last = new Pair(Integer.parseInt(lastStr[0]), Integer.parseInt(lastStr[1]));
        return new ConnectPair(first, last);
    }

    /**
     * @param connectPair 连通性坐标对象
     * @param maze        迷宫对象实体
     * @return boolean true合法,false非法
     * @author zhang
     * @description 判断连通性坐标对象是否合法
     * @date 1:50 2021/1/10
     **/
    private static boolean judgeConnectPair(ConnectPair connectPair, Maze maze) {
        int line = (maze.getLine() - 1) / 2;
        int row = (maze.getRow() - 1) / 2;
        int firstLine = connectPair.first.getLine();
        int firstRow = connectPair.first.getRow();
        int lastLine = connectPair.last.getLine();
        int lastRow = connectPair.last.getRow();
        if (firstLine >= line || lastLine >= line || firstRow >= row || lastRow >= row) {
            //连通性输入超过数组范围
            System.err.println("Number out of range");
            return false;
        }
        if ((Math.abs(firstLine - lastLine) + Math.abs(firstRow - lastRow)) != 1) {
            //连通性的路径长度大于1,不成立
            System.err.println("Maze format error");
            return false;
        }
        return true;
    }
}
