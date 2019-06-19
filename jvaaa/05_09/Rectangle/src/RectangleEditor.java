import java.util.Scanner;
import javax.swing.JFrame;//windowモジュール
//javac -encoding UTF-8 sample.java
class RectangleEditor
{  
    public static void main(String[] args) {
        int board_width =500,board_height=400;
        System.out.println("ボードを作成します defaltsize(500,400)");
        Board board = new Board(board_width,board_height);
        System.out.println("コマンドを入力");
        Command command = new Command(board);
        command.start();
    }
}
