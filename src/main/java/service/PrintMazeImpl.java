package service;

import pojo.Maze;

/**
 * 打印迷宫
 *
 * @author zhang
 */
public interface PrintMazeImpl {
    /**
     * @param maze 迷宫实体对象
     * @return void
     * @author zhang
     * @description 用于打印迷宫图案
     * @date 3:27 2021/1/9
     **/
    void printMaze(Maze maze);
}
