import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;///windowモジュール
import java.lang.Object;
import java.util.InputMismatchException;
//CUI
public class Command
{   
    Board board;
    Scanner scan = new Scanner(System.in);
    Command(Board board)
    {
        this.board=board;
    }
    public void start()
    {
        for(String s="";!(s.equals("9"));)
        {
            try{
                System.out.println("==========================");
                System.out.println("select number");
                System.out.println("1:create");
                System.out.println("2:setcolor");
                System.out.println("3:move");
                System.out.println("4:expand/shrink");
                System.out.println("5:delete");
                System.out.println("6:deleteAll");
                System.out.println("7:intersect");
                System.out.println("8:displayBoard");
                System.out.println("9:exit");
                System.out.println("==========================");
                s = scan.next();
                s=s.toUpperCase();
                int m = 0;
                String[] commands={"create","setcolor","move","expand/shrink","deletedeleteAll","intersect","exit"};
                //comandsを小文字に変換し番号に対応
                for(String cm:commands)
                {
                    m++;
                    if(s.equalsIgnoreCase(cm))
                    {
                        s=Integer.toString(m);
                        break;
                    }
                }
                switch (s)
                {
                    case "1"://create
                        this.Create();
                        break;
                    case "2"://setcolor
                        this.Color();
                        break;
                    case "3"://move
                        this.Move();
                        break;
                    case "4"://expand_shrink
                        this.Expand_shrink();
                        break;
                    case "5"://delete いらない
                        this.Delete();
                        break;
                    case "6"://deleteAll いらない
                        this.DeleteAll();
                        break;
                    case "7"://intersect 
                        this.Intersect();
                        break;
                    case "8"://displayBoard いらない
                        this.DisplayBoard();
                        break;
                    case "9"://exit いらない
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
        }
    }
        void Create()//1
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
            if(this.board.RectangleAdd(x,y,width,height)==1)
            {
                System.out.println("作成できませんでした");
            }
            this.DisplayBoard();
        }
        void Color()
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
        void Move()//2
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
            num = board.source.Move(mov,mx,my);
            if(num==-1)System.out.println("作成に失敗しました");
            else
            {
                this.DisplayBoard();
            }
        }
        void Expand_shrink()//3
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
            num = board.source.Expand_shrink(del,ex,ey);
            if(num==-1)System.out.println("拡張/縮小できませんでした");
            else
            {
                this.DisplayBoard();
            }
        }

        void Delete()//4
        {
            int del;
            int num;
            System.out.println("削除する長方形を選択");
            this.DisplayBoard();
            del = scan.nextInt();
            num = board.source.Delete(del);
            if(num==-1)System.out.println("削除できませんでした");
            else
            {
                this.DisplayBoard();
            }
        }
        void DeleteAll()//5
        {
            System.out.println("すべての長方形を初期化");
            board.source.DeleteAll();
        }
        public int Intersect()//6
        {
            int sx,sy;
            int num=0;
            System.out.println("一つ目の長方形の番号をを入力");
            sx = scan.nextInt();
            System.out.println("二つ目の長方形の番号をを入力");
            sy = scan.nextInt();
            num=board.source.Intersect(sx,sy);
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
            System.out.println(this.board.RectanglesString())
        }
        void Exit()//8
        {
            System.out.println("入力を終了します");
        }