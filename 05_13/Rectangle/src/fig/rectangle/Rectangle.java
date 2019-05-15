package fig.rectangle;
import java.util.ArrayList;
import java.util.List;
import java.lang.Object;
import java.lang.Math;

public class Rectangle
{
    int x,y,width,height;

    //長方形の初期化
    public Rectangle()
    {
        x = 0;
        y = 0;
        width = 0;
        height = 0;
    }

    //複製したRectangleインスタンスを返す
    Rectangle Clone(Rectangle rect)
    {
        int x,y,width,height;
        x = rect.x;
        y = rect.y;
        width = rect.width;
        height = rect.height;
        Rectangle rect_clone = new Rectangle();
        rect_clone.Create(x,y,width,height);
        return rect_clone;
    }

    //長方形を作る
    public int Create(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
        //長方形の条件判定
        if(this.CheckRectangle()==false)return 1;
        return 0;
    }

    //2:長方形を移動する
    void Move(int x, int y)
    {
        this.x += x;
        this.y += y;
        this.width += x;
        this.height += y;
    }

    //拡大縮小 ex:拡大/縮小倍率 ey:拡大/縮小倍率 
    int Expand_shrink(double ex, double ey)
    {
        if((ex==0)||(ey==0)) return 1;
        this.width *= ex;
        this.height *= ey;
        return 0;
    }

    //長方形の条件を満たすかチェック
    Boolean CheckRectangle()
    {
        return true;
    }

    //要素を含んだ文字配列を返す
    public String toStringRectangle()
    {
        String stringRectangle;
        stringRectangle = "Rectangle:"+this.x+","+this.y+","+this.width+","+this.height;
        return stringRectangle;
    }

    //x,y,width,heightを返す
    int Getx()
    {
        return this.x;
    }
    int Gety()
    {
        return this.y;
    }
    int Getwidth()
    {
        return this.width;
    }
    int Getheight()
    {
        return this.height;
    }
}