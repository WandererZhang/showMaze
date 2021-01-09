package service;

import org.junit.Test;
import pojo.Maze;

import java.io.*;

public class TestInputMaze {
    @Test
    public void testCreatMaze() throws IOException {
        InputMaze inputMaze = new InputMaze();
        File file = new File("src\\JUnit.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String strLine = null;
        String strFirstLine = "";
        String strNextLine = "";
        int lineCount = 0;
        while (null != (strLine = bufferedReader.readLine()) || lineCount % 2 == 1) {
            strLine = strLine == null ? "" : strLine;
            lineCount++;
            System.out.println("第[" + lineCount + "]行数据:[" + strLine + "]");
            if (lineCount % 2 == 1) {
                strFirstLine = strLine;
            } else if (lineCount % 2 == 0) {
                strNextLine = strLine;
                Maze maze = inputMaze.creatMaze(strFirstLine, strNextLine, "[R]", "[W]");
                if (maze != null) {
                    PrintMaze printMaze = new PrintMaze();
                    printMaze.printMaze(maze);
                }
            }
        }
    }
}
