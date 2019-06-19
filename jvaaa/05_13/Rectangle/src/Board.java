import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JFrame;///windowモジュール
import java.lang.Object;
import java.util.InputMismatchException;
import fig.rectangle.*;

public class Board
{
    public static final int MAX_Rectangle = 10;
    //exitは一番目で固定すること
    public String[] functionCommands = {"exit","create","move","expand/shink","delete","deleteAll","intersect","displayBoard"};
    int boardWidth = 0;
    int boardHeight = 0;
    ArrayList<Rectangle> listRectangle = new ArrayList<Rectangle>(MAX_Rectangle);
    
    Board(int inputBoardWidth,int inputBoardHeight)
    {
        this.boardWidth = inputBoardWidth;
        this.boardHeight = inputBoardHeight;
    }

    ArrayList<Rectangle> GetListRectangle()
    {
        return listRectangle;
    }
	String ExitName()
	{
        String exitName;
		exitName = this.functionCommands[0];
		return exitName;
	}

	String[] GetCommandsRectangle()
	{
        String[] cmds;
		cmds = this.functionCommands;
		return cmds;
	}

    Boolean Exit()//8
    {
        return true;
    }

	Boolean CreateRectangle(int inputX,int inputY,int inputWidth,int inputHeight)//1
    {
        int x,y,height,width;
        x=inputX;
        y=inputY;
        height = inputHeight;
        width = inputWidth;
        Rectangle rect = new Rectangle();
        rect.Create(x,y,height,width);
        System.out.println(listRectangle.size());
        if (listRectangle.size()>=MAX_Rectangle)return false;
        listRectangle.add(rect);
        return true;
    }
    Boolean SetColorRectangle()
    {
        return true;
    }
    Boolean MoveRectangle()//2
    {
        return true;
    }
    Boolean ExpandShrinkRectangle()//3
    {
        return true;
    }
    Boolean DeleteRectangle()//4
    {
        return true;
    }
    Boolean DeleteAllRectangle()//5
    {
        return true;
    }
    public Boolean IntersectRectangle()//6
    {
        return true;
    }
}