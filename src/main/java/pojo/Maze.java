package pojo;

import lombok.Data;

/**
 * @author zhang
 * @description 迷宫的实体类
 * @date 0:00 2021/1/9
 **/
@Data
public class Maze {
    private Integer line;
    private Integer row;
    private String strRoad;
    private String strWall;
    private String[][] array;

    public Maze(Integer line, Integer row,String strRoad,String strWall) {
        this.strRoad = strRoad;
        this.strWall = strWall;
        this.line = 2 * line + 1;
        this.row = 2 * row + 1;
        this.array = new String[2 * line + 1][2 * row + 1];
    }
}
