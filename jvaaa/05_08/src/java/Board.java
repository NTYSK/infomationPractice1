import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Scanner;
import javax.swing.*;//windowモジュール
import java.awt.event.*;//GUIの明示的終了に用いる
//GUI
public class Board extends JFrame
{
    int board_width ,board_height;
    Source source;
    Board(int board_width,int board_height)
    {
        this.board_width = board_width;
        this.board_height = board_height;
        //上部フレームのサイズを考慮する
        this.setSize(board_width+this.getBounds().x,board_height);        
        this.source=new Source(board_width,board_height);
    }
}