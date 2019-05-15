package figure;

import java.util.ArrayList;
import java.util.List;
import java.awt.Rectangle;
import java.awt.Shape;
import java.lang.Object;
import java.lang.Math;

public class Rectangles extends Rectangle
{
    public ArrayList<Rectangle> List_rectangle;
    int board_width,board_height;
    Rectangle board_rect;
    int color;
    //インスタンスを立てる
    public Rectangles(int board_width,int board_height)
    {
        this.board_width = board_width;
        this.board_height = board_height;
        color=0;
        board_rect = new Rectangle(0,0,board_width,board_height);
        List_rectangle = new ArrayList<Rectangle>();
         
    }

    //1:長方形をリソースに追加する 失敗時 -1 成功時 listのサイズ　返却 
    public int Add_rectangle(Rectangle rect)
    {
        boolean board_contain = true;
        Rectangle new_rect = this.Resize_rectangle(rect);
        //Listが含んでいるか否かの判定,追加したい長方形を作り追加
        if(this.Judge_rectangle(new_rect) == false)return -1;
        List_rectangle.add(new_rect);
        return List_rectangle.size();
    }

    public int Color(int num,int color)
    {
        //numがList範囲内にあることの確認
        if((num > 0) && (num <= List_rectangle.size()))
        {
            //Listから指定の長方形を取ってきて変形し、範囲判定後指定場所に代入
            Rectangle rect = List_rectangle.get(num-1);
            if((color>0)&&(color<4))//1:red,2:blue,3:green
            {
                this.color=color;
                return 0;
            }else return -1;
        }
        return -1;
    }
    //長方形が指定Boardの範囲内かの判定とListない要素との重複の判定 成功時 true 失敗時 false
    boolean Judge_rectangle(Rectangle rect)
    {
        //width,heightが0出ないことの判定
        if((rect.width == 0)||(rect.height == 0)) return false;
        //ボード内にあることと重複していないことの判定
        if((board_rect.contains(rect)))
        {
            for(Rectangle rectangle:List_rectangle)
            {
                if((rect.x==rectangle.x)&&(rect.y==rectangle.y)&&(rect.width==rectangle.width)&&(rect.height==rectangle.height))
                {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    //長方形(-の値を含む)を+に変形して返す 返却値　Rectangle
    Rectangle Resize_rectangle(Rectangle rect)
    {
        Rectangle new_rect = rect;
        int rwidth,rheight;
        //width,heightが0以下の場合で+に変形して返す
        if(rect.width<0&&rect.height<0)
        {
            rwidth=Math.abs(rect.width);
            rheight=Math.abs(rect.height);
            new_rect = new Rectangle(rect.x-rwidth,rect.y-rheight,rwidth,rheight);
        }else if(rect.width<0){
            rwidth=Math.abs(rect.width);
            new_rect = new Rectangle(rect.x-rwidth,rect.y,rwidth,rect.height);
        }else if(rect.height<0){
            rheight=Math.abs(rect.height);
            new_rect = new Rectangle(rect.x,rect.y-rheight,rect.width,rheight);
        }
        return new_rect;
    }

    //2:指定した番号の長方形をmx,my分移動する 成功時 0 失敗時 -1を返す
    public int Move(int num,int mx,int my)
    {
        //numがList範囲内にあることの確認
        if((num > 0) && (num <= List_rectangle.size()))
        {
            //Listから指定の長方形を取ってきて変形し、範囲判定後指定場所に代入
            Rectangle rect = new Rectangle(List_rectangle.get(num-1).x,List_rectangle.get(num-1).y,List_rectangle.get(num-1).width,List_rectangle.get(num-1).height);
            rect.translate(mx,my);
            if(this.Judge_rectangle(rect)==true)
            {
                List_rectangle.set(num-1,rect);
                return 0;
            }else {
                return -1;
            }
        }else{
            return -1;
        }
    }

    //3:指定した番号の長方形をex,eyを元に変形する 成功時 0 失敗時 -1を返す
    public int Expand_shrink(int num, double ex, double ey)
    {
        //numがList範囲内にあることの確認
        if((num > 0) && (num <= List_rectangle.size()))
        {
            //Listから指定の長方形を取ってきて変形し、範囲判定後指定場所に代入
            Rectangle rect = new Rectangle(List_rectangle.get(num-1).x,List_rectangle.get(num-1).y,(int)(List_rectangle.get(num-1).width*ex),(int)(List_rectangle.get(num-1).height*ey));
            if(this.Judge_rectangle(rect)==true)
            {
                List_rectangle.set(num-1,rect);
                return 0;
            }else {
                return -1;
            }
        }
        return -1;
    }
    //6:2つの長方形を比較し和集合のRectangleを追加 失敗時 -1 成功時 0
    public int Intersect(int num1,int num2)
    {
        Rectangle rect1,rect2;
        Rectangle new_rect;
        //num1がList範囲内にあることの確認
        if((num1 > 0) && (num1 <= List_rectangle.size()))
        {
            //Listから指定の長方形を取ってきて格納
            rect1 = new Rectangle(List_rectangle.get(num1-1).x,List_rectangle.get(num1-1).y,List_rectangle.get(num1-1).width,List_rectangle.get(num1-1).height);
        }else return -1;
        //num2がList範囲内にあることの確認
        if((num2 > 0) && (num2 <= List_rectangle.size()))
        {
            //Listから指定の長方形を取ってきて格納
            rect2 = new Rectangle(List_rectangle.get(num2-1).x,List_rectangle.get(num2-1).y,List_rectangle.get(num2-1).width,List_rectangle.get(num2-1).height);
        }else return -1;
        //2つの長方形を比較し和集合のRectangleを追加
        new_rect = rect1.intersection(rect2);
        //注 isEmptyで空集合か否かを判定すること
        if(new_rect.isEmpty()==false)
        {
            if(this.Add_rectangle(new_rect)!=-1)return 0;
        }
        return -1;
    }
}