package service;


import pojo.Maze;

/**
 * 输入并生成迷宫
 *
 * @author zhang
 */
public interface InputMazeImpl {
    /**
     * @param str1    输入行和列
     * @param str2    输入连通性
     * @param roadStr 道路所使用的字符
     * @param wallStr 墙壁所使用的字符
     * @return pojo.Maze
     * @author zhang
     * @description 用于创建Maze对象
     * @date 2:08 2021/1/9
     **/
    Maze creatMaze(String str1, String str2, String roadStr, String wallStr);
}
