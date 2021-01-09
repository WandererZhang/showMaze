package service;

import pojo.Maze;

/**
 * 添加迷宫的连通性
 *
 * @author zhang
 */
public interface CreatConnectImpl {
    /**
     * @param maze    迷宫的实体对象
     * @param connect 连通性数组
     * @return pojo.Maze
     * @author zhang
     * @description 添加迷宫的连通性, 返回渲染结果
     * @date 14:21 2021/1/9
     **/
    Maze creatConnect(Maze maze, String[] connect);
}
