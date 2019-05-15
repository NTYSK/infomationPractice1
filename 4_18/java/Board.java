import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Scanner;
import javax.swing.*;//windowモジュール
import java.awt.event.*;//GUIの明示的終了に用いる
//GUI
public class Board extends JFrame
{
    Source source;
    Board(Source source)
    {
        this.source=source;
    }
}