import java.util.ArrayList;
import java.util.List;
import java.awt.Rectangle;
import java.awt.Shape;
import java.lang.Object;
import java.lang.Math;
import figure.*;

public class Source
{
    ArrayList<Object> List_object;
    Rectangles rectangles;
    int board_width, board_height;
    //付随するボードのサイズが必要
    Source(int board_width,int board_height)
    {
        this.board_width=board_width;
        this.board_height=board_height;
        List_object = new ArrayList<Object>();
        rectangles = new Rectangles(board_width,board_height);
    }
    ArrayList<Object> Update_list()
    {
        List_object.clear();
        //objectに対してListの追加
        for(Rectangle rect:rectangles.List_rectangle)
        {
            List_object.add(rect);
        }
        return List_object;
    }
    //長方形をリソースに追加する -1失敗 listsize成功
    //objでの変更を容易にしたいがobj要素からRectを取り出せない(ダウンキャストができない)
    int Create(Rectangle rect)
    {
        return rectangles.Add_rectangle(rect);
    }
    int Color(int rect,int color)
    {
        return rectangles.Color(rect,color);
    }

    //2:長方形を移動する
    int Move(int mov,int mx,int my)
    {
        
        return rectangles.Move(mov,mx,my);
    }
    public int Expand_shrink(int del, double ex, double ey)
    {
        return rectangles.Expand_shrink(del,ex,ey);
    }

    int Delete(int del)//4
    {
        try{
            rectangles.List_rectangle.remove(del-1);
        }catch(IndexOutOfBoundsException e) {
            return -1;
        }
        return 0;
    }
    int DeleteAll()//5
    {
        List_object.clear();
        rectangles.List_rectangle.clear();
        return 0;
    }

    public int Intersect(int num1,int num2)
    {
        return rectangles.Intersect(num1,num2);
    }
}