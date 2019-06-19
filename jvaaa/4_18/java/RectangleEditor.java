import java.util.Scanner;
import javax.swing.JFrame;//windowモジュール
//javac -encoding UTF-8 sample.java
class RectangleEditor
{  
    public static void main(String[] args) {
        Source source = new Source();
        System.out.println("ボードを作成します");
        Board board = new Board(source);
        System.out.println("コマンドを入力");
        Command command = new Command(source,board);
        command.start();
    }
}
