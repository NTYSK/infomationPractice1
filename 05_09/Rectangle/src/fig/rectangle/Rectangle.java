import java.util.ArrayList;
import java.util.List;
import java.lang.Object;
import java.lang.Math;
import figure.*;

public class Rectangle
{
    int x,y,width,height;

    //長方形の初期化
    Rectangle()
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
        Rectangle rect_clone = new Rectangle(x,y,widt,height);
        return rect_clone;
    }

    //長方形を作る
    int Create(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
        //長方形の条件判定
        if(this.rectagle_state()==1)retun 1;
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
    int　Rect_check();

    //要素を含んだ文字配列を返す
    Stirng toString()
    {
        Stirng s = ("Rectangle:%d,%d,%f,%f")
        return s;
    }

    //x,y,width,heightを返す
    int Getx()
    {
        return this.X;
    }
    int Gety()
    {
        return this.Y;
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