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
    Scanner scan = new Scanner(System.in);
    Command(Board inputBoard)
    {
        this.board = inputBoard;
        this.CommandFunction();
    }

    public Boolean CommandFunction()
    {
        String[] commands = board.GetCommandsRectangle();
        Boolean judgeCommands = (commands.length == 0);
        if(judgeCommands == true)
        {
            return false;
        }
        try{
            while(true)
            {   
                    String command;
                    int commandNumber;
                    //機能の表示
                    PrintBoardFunction(commands);
                    command = scan.nextLine();
                    commandNumber = ChangeInputToNumber(commands,command);
                    //機能実行
                    if(commandNumber==0)
                    {
                        //exit入力時
                        System.out.println("exitが入力されました");
                        System.out.println("入力を終了します");
                        break;
                    }else if(commandNumber==-1){
                        //機能外の入力時
                        System.out.println("これは機能外の入力です");
                    }else{
                        //機能実行時
                        Boolean functionCheck=true;
                        if(functionCheck==false)
                        {
                            System.out.println("実行できませんでした");
                        }else{
                            System.out.println("実行できました");
                        }
                    }
            }   
            }catch(InputMismatchException e){
                System.out.println("入力ミスです、数字を入力してください");
                scan.next();
            }
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
            if(cmd.equals(command))
            {
                aryNum = i;
                String exitName;
                exitName=board.ExitName();
                if(command.equals(exitName))
                {
                    aryNum = 0;
                }
                break;
            }
            i+=1;
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
        Boolean cmdJudje = false;
        Scanner scanfunc = new Scanner(System.in);
        System.out.println(aryNum);
        switch (aryNum)
        {
            case 0://exit
                cmdJudje = board.Exit();
                break;
            case 1://CreateRectangle
                int x,y,width,height;
                int color;
                System.out.println("左上のx座標");
                x = scanfunc.nextInt();
                System.out.println("左上のy座標");
                y = scanfunc.nextInt();
                System.out.println("幅");
                width = scanfunc.nextInt();
                System.out.println("高さ");
                height = scanfunc.nextInt();
                cmdJudje = board.CreateRectangle(x,y,width,height);
                if(cmdJudje == false)System.out.println("作成できませんでした");
                //色を番号で渡す
                //System.out.println("色");
                //color = scanfunc.nextInt();
                //colorJudje = board.SetColorRectangle();
                this.DisplayBoard();
                break;
            case 2://move
                int mov,mx,my;
                System.out.println("移動する長方形の番号を入力");
                this.DisplayBoard();
                mov = scanfunc.nextInt();
                System.out.println("x座標の移動距離を入力");
                mx = scanfunc.nextInt();
                System.out.println("y座標の移動距離を入力");
                my = scanfunc.nextInt();
                cmdJudje = board.MoveRectangle();
                break;
            case 3://expand_shrink
                int del;
                double ex,ey;
                System.out.println("拡張/縮小する長方形を入力");
                this.DisplayBoard();
                del = scanfunc.nextInt();
                System.out.println("拡張/縮小するxの倍率");
                ex = scanfunc.nextFloat();
                System.out.println("拡張/縮小するyの倍率");
                ey = scanfunc.nextFloat();
                cmdJudje = board.ExpandShrinkRectangle();
                break;
            case 4://delete いらない
                int delNum;
                System.out.println("削除する長方形を選択");
                this.DisplayBoard();
                delNum = scanfunc.nextInt();
                cmdJudje = board.DeleteRectangle();
                break;
            case 5://deleteAll いらない
                System.out.println("すべての長方形を初期化");
                cmdJudje=board.DeleteAllRectangle();
                break;
            case 6://intersect
                int sx,sy;
                System.out.println("一つ目の長方形の番号をを入力");
                sx = scanfunc.nextInt();
                System.out.println("二つ目の長方形の番号をを入力");
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
        scanfunc.close();
        return cmdJudje;
    }
    void DisplayBoard()//7
    {
        ArrayList<Rectangle> listRectangle = board.GetListRectangle();
        int i=0;
		for(Rectangle r:listRectangle)
		{
            i+=1;
            String output = r.toStringRectangle();
			System.out.println(i+":"+output);
		}
    }
}