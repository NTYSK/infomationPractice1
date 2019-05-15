import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;///windowモジュール
import java.lang.Object;
import java.util.InputMismatchException;
import fig.rectangle.*;
//CUI
public class Command
{  
    Board board;
    Command(Board inputBoard)
    {
        this.board = inputBoard;
        this.CommandFunction();
    }

    public Boolean CommandFunction()
    {
        String[] commands = board.GetCommandsRectangle();
        Boolean judgeCommands = (commands.length == 0);
        Scanner scan = new Scanner(System.in);
        if(judgeCommands == true)
        {
            scan.close();
            return false;
        }
        while(true)
        {   
            try{
                String command;
                int commandNumber;
                //機能の表示
                PrintBoardFunction(commands);
                command = scan.next();
                //機能と比較して数字に変換
                commandNumber = ChangeInputToNumber(commands,command);
                //機能実行
                if(commandNumber==0)
                {
                    //exit入力時
                    System.out.println("exitが入力されました");
                    CallFunction(commandNumber);
                    System.out.println("入力を終了します");
                    break;
                }else if(commandNumber==-1){
                    //機能外の入力時
                    System.out.println("これは機能外の入力です");
                }else{
                    //機能実行時
                    Boolean functionCheck=true;
                    functionCheck = CallFunction(commandNumber);
                    if(functionCheck==false)
                    {
                        System.out.println("実行できませんでした");
                    }else{
                        System.out.println("実行できました");
                    }
                }
            }catch(InputMismatchException e){
                System.out.println("入力ミスです、数字を入力してください");
                scan.next();
            }
        }
        scan.close();
        return true;
    }
    

    //機能が存在することが保証されている 表示のみの関数 返り値無し
    void PrintBoardFunction(String[] inputCommands)
    {
        String[] commands = inputCommands;
        int i=0;
        String bar = "================================";
        System.out.println(bar);
        System.out.println("select function");
        for(String cmd:commands)
        {
            i+=1;
            System.out.println(i+":"+cmd);
        }
    }

    //commandsを元に返り値を決める 返り値(範囲外なら-1,exitなら０,それ以外ならコマンドの配列番号)
    int ChangeInputToNumber(String[] inputCommands,String inputCommand)
    {
        String[] commands = inputCommands;
        String command = inputCommand;
        int i=0,aryNum=-1;
        for(String cmd:commands)
        {
            i+=1;
            if(cmd==command)
            {
                String exitName;
                exitName=board.ExitName();
                if(cmd==exitName)
                {
                    aryNum = 0;
                    break; 
                }
                aryNum = i;
                break;
            }
        }
        return aryNum;
    }

    //機能の呼び出し(機能コマンド,コマンド変換番号)
    //機能番号としてexitと範囲外は来ないことが保証されている
    Boolean CallFunction(int commandNumber)
    {
        Boolean commandJudje = true;
        int num;
        num = commandNumber;
        commandJudje = this.CallBoardFunction(num);
        return commandJudje;
    }

    Boolean CallBoardFunction(int aryNum)
    {
        String[] commands = board.GetCommandsRectangle();
        Boolean cmdJudje = false,colorJudje = false;
        Scanner scan = new Scanner(System.in);
        switch (aryNum)
        {
            case 0://exit
                cmdJudje = board.Exit();
                break;
            case 1://CreateRectangle
                int x,y,width,height;
                int color;
                System.out.println("左上のx座標");
                x = scan.nextInt();
                System.out.println("左上のy座標");
                y = scan.nextInt();
                System.out.println("幅");
                width = scan.nextInt();
                System.out.println("高さ");
                height = scan.nextInt();
                cmdJudje = board.CreateRectangle(x,y,width,height);
                System.out.println("作成できませんでした");
                //色を番号で渡す
                System.out.println("色");
                color = scan.nextInt();
                colorJudje = board.SetColorRectangle();//
                System.out.println("作成できませんでした");
                this.DisplayBoard();
                break;
            case 2://move
                int mov,mx,my;
                System.out.println("移動する長方形の番号を入力");
                this.DisplayBoard();
                mov = scan.nextInt();
                System.out.println("x座標の移動距離を入力");
                mx = scan.nextInt();
                System.out.println("y座標の移動距離を入力");
                my = scan.nextInt();
                System.out.println("作成に失敗しました");
                this.DisplayBoard();
                cmdJudje = board.MoveRectangle();
                break;
            case 3://expand_shrink
                int del;
                double ex,ey;
                System.out.println("拡張/縮小する長方形を入力");
                this.DisplayBoard();
                del = scan.nextInt();
                System.out.println("拡張/縮小するxの倍率");
                ex = scan.nextFloat();
                System.out.println("拡張/縮小するyの倍率");
                ey = scan.nextFloat();
                System.out.println("拡張/縮小できませんでした");
                this.DisplayBoard();
                cmdJudje = board.ExpandShrinkRectangle();
                break;
            case 4://delete いらない
                int delNum;
                System.out.println("削除する長方形を選択");
                this.DisplayBoard();
                delNum = scan.nextInt();
                System.out.println("削除できませんでした");
                this.DisplayBoard();
                cmdJudje = board.DeleteRectangle();
                break;
            case 5://deleteAll いらない
                System.out.println("すべての長方形を初期化");
                cmdJudje=board.DeleteAllRectangle();
                break;
            case 6://intersect
                int sx,sy;
                System.out.println("一つ目の長方形の番号をを入力");
                sx = scan.nextInt();
                System.out.println("二つ目の長方形の番号をを入力");
                sy = scan.nextInt();
                //公差する長方形
                //
                System.out.println("作成できませんでした");
                this.DisplayBoard();
                cmdJudje = board.IntersectRectangle();
                break;
            case 8://displayBoard いらない
                //現在は長方形のみの出力
                System.out.println(this.board);
                this.DisplayBoard();
                break;
            default:
                break;
        }
        scan.close();
        return cmdJudje;
    }
    void DisplayBoard()//7
    {
        ArrayList<Rectangle> listRectangle = board.GetListRectangle();
        int i=0;
		for(Rectangle r:listRectangle)
		{
            i+=0;
            String output = r.toStringRectangle();
			System.out.println(output);
		}
    }
}