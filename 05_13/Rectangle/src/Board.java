import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;///windowモジュール
import java.lang.Object;
import java.util.InputMismatchException;
public class Board
{  
    Board()
    {
    }
	//exitの名前
	String exit="exit";
	String[] functionCommands ={"","exit"}

	String ExitName()
	{
		exitName = this.exit;
		return exitName
	}

	String[] GetCommandsName()
	{
		cmds = this.functionCommands;
		return cmd;
	}

	boolean BoardFunction(String[] inputCommands,int inputNumber)
	{
		String[] commands = inputCommands;
		String[] funCmd = functionCommands[1]
		//配列はinput-1
		num = inputNumber-1;
		//以下でコマンドの実行
		//numは配列の番号,1から始まりexitは0と範囲外を含まないことを保証
    	switch (commands[num])
            {
                case funCmd[1]://CreateRectangle
                    this.CreateRectangle();
                    break;
                case funCmd[2]://setcolor
                    this.SetColorRectangle();
                    break;
                case funCmd[3]://move
                    this.MoveRectangle();
                    break;
                case funCmd[4]://expand_shrink
                    this.ExpandShrinkRectangle();
                    break;
                case funCmd[5]://delete いらない
                    this.DeleteRectangle();
                    break;
                case funCmd[6]://deleteAll いらない
                    this.DeleteAllRectangle();
                    break;
                case funCmd[7]://intersect 
                    this.IntersectRectangle();
                    break;
                case funCmd[8]://displayBoard いらない
                    this.DisplayBoard();
                    break;
                case funCmd[9]://exit いらない
                    this.Exit();
                    break;
                default:
                    System.out.println("入力ミスです、1~8までのの番号を入力してください");
                    break;
            }
            //予想外の入力に対する例外処理
            }catch(InputMismatchException e){
                    System.out.println("入力ミスです、数字を入力してください");
                    //バッファのクリア
                    scan.nextLine();
            }
	void CreateRectangle()//1
    {
        int x,y,height,width;
        String color;
        int num=0;
        //現時点では長方形ここに分岐を入れる
        System.out.println("左上のx座標");
        x = scan.nextInt();
        System.out.println("左上のy座標");
        y = scan.nextInt();
        System.out.println("幅");
        width = scan.nextInt();
        System.out.println("高さ");
        height = scan.nextInt();
        //色を番号で渡す
        System.out.println("色");
        color = scan.nextInt();
        if(board.==1)
        {
            System.out.println("作成できませんでした");
        }
        this.DisplayBoard();
    }
    void SetColorRectangle()
    {
        int rec;
        int color=0;
        int num=0;
        System.out.println("色をセットする長方形を入力");
        this.DisplayBoard();
        rec = scan.nextInt();
        System.out.println("色番の選択");
        System.out.println("1:Red,2:Blue,3:Green");
        color = scan.nextInt();
        //これの追加から
        num = board.source.Color(rec,color);
        if(num==-1)System.out.println("色を付与できませんでした");
        else
        {
            this.DisplayBoard();
        }
    }
    void MoveRectangle()//2
    {
        int num=0;
        int mov,mx,my;
        System.out.println("移動する長方形の番号を入力");
        this.DisplayBoard();
        mov = scan.nextInt();
        System.out.println("x座標の移動距離を入力");
        mx = scan.nextInt();
        System.out.println("y座標の移動距離を入力");
        my = scan.nextInt();
        num = board.;
        if(num==-1)System.out.println("作成に失敗しました");
        else
        {
            this.DisplayBoard();
        }
    }
    void ExpandShrinkRectangle()//3
    {
        int del;
        double ex,ey;
        int num=0;
        System.out.println("拡張/縮小する長方形を入力");
        this.DisplayBoard();
        del = scan.nextInt();
        System.out.println("拡張/縮小するxの倍率");
        ex = scan.nextFloat();
        System.out.println("拡張/縮小するyの倍率");
        ey = scan.nextFloat();
        //これの追加から
        num = board.;
        if(num==-1)System.out.println("拡張/縮小できませんでした");
        else
        {
            this.DisplayBoard();
        }
    }
    void DeleteRectangle()//4
    {
        int del;
        int num;
        System.out.println("削除する長方形を選択");
        this.DisplayBoard();
        del = scan.nextInt();
        num = board.;
        if(num==-1)System.out.println("削除できませんでした");
        else
        {
            this.DisplayBoard();
        }
    }
    void DeleteAll()//5
    {
        System.out.println("すべての長方形を初期化");
        board.;
    }
    public int IntersectRectangle()//6
    {
        int sx,sy;
        int num=0;
        System.out.println("一つ目の長方形の番号をを入力");
        sx = scan.nextInt();
        System.out.println("二つ目の長方形の番号をを入力");
        sy = scan.nextInt();
        //公差する長方形
        num=board.;
        //
        if(num==-1)System.out.println("作成できませんでした");
        else
        {
            this.DisplayBoard();
        }
        return 0;
    }
    void DisplayBoard()//7
    {
        //現在は長方形のみの出力
        System.out.println(this.board.)
    }
    void Exit()//8
    {
        System.out.println("入力を終了します");
    }
}