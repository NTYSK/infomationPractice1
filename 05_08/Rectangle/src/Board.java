import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;
import javax.swing.*;//windowモジュール
import java.awt.event.*;//GUIの明示的終了に用いる
//GUI
public class Board extends JFrame
{
	ArrayList<Rectangle> rectangleList;
    int board_width ,board_height;
	int Rectangle_List_Max = 10;

    Board(int board_width, int board_height)
    {
        this.board_width = board_width;
        this.board_height = board_height;
        //上部フレームのサイズを考慮する
        this.setSize(board_width+this.getBounds().x,board_height);
    }

	//長方形Listに対する追加
	int RectangleAdd(int x, int y, int width, int height);
	{
		Rectangle rect = new Rectangle();
		rect.Create(x, y, width, height);
		//ボードとリストと比較
		if(Rect_Cmp(rect)==true)
		{
			//リストサイズの確認
			if(rectangleList.size()<Rectangle_List_Max)
			{
				//リストに追加
				rectangleList.add(rect);
				retrun 0;
			}else{
				return 1;
			}
		}else{
			retrun 1;
		} 
	}

	//長方形Listに対する移動
	int RectangleMove(int num,int x, int y)
	{
		try{
			//RectList作成上限の確認
			if(num>Rectangle_List_Max) retrun 1;
			Rectangle rect = rectangleList(num-1);
			rect.Move(x,y);
			//ボードとリストと比較
			if(Rect_Cmp(rect)==true)
			{
				return 0;
			}else{
				//だめなら戻してエラー
				rect.Move(-x,-y);
				return 1;
			}
		}catch(IndexOutOfBoundsException e) {
            return 1;
        }
				
	}

	//長方形Listに対する拡大縮小
	int RectangleExpandshrink(int num, double ex, double ey)
	{
		try{
			//RectList作成上限の確認
			if(num>Rectangle_List_Max) retrun 1;
			Rectangle rect = rectangleList(num-1);
			Rectangle rect_clone = rectangleList(num-1).clone;
			if(0==rect_clone.Expand_shrink(ex,ey))
			{
				//ボードとリストと比較
				if(Rect_Cmp(rect)==true)
				{
					rect.Expand_shrink(ex,ey);
					return 0;
				}else{
					//だめならエラー
					//作成したrect_cloneインスタンスの破棄をしたい
					return 1;
				}	
			}else{
				return 1;
			}
		}catch(IndexOutOfBoundsException e) {
            return 1;
        }

	//長方形Listに対する削除
	int RectangleDelete(int num)
	{
		try{
			//RectList作成上限の確認
			if(num>Rectangle_List_Max) retrun 1;
            rectangleList.remove(num-1);
			return 0;
        }catch(IndexOutOfBoundsException e) {
            return 1;
        }
	}

	//長方形Listに対するすべての削除
	void RectangleDeleteAll()
	{
		rectangleList.clear();
	}

	//長方形リストに対する公差の追加
	int RectangleIntersect(num1,num2)
	{
		try{
			//RectList作成上限の確認
			if(num1>Rectangle_List_Max) retrun 1;
			if(num2>Rectangle_List_Max) retrun 1;
			Rectangle rect1,rect2;
			rect1 = rectangleList(num1-1);
			rect2 = rectangleList(num2-1);
		}catch(IndexOutOfBoundsException e) {
            return 1;
        }
	}
	String RectanglesString()
	{
		ArrayList<String> rect = new ArrayList<String>();
		for(Rectangle r:rectangleList)
		{
			rect.add(r.toString());
			retrun rect;
		}
	}

	//長方形リストの返却
	ArrayList<Rectangle> RectangleList()
	{
		return rectangleList;
	}

	boolean Rect_Cmp(Rectangle rect)
	{
		if(true==Rect_Cmp_bord(rect))&&(true==Rect_Cmp_list(rect)) return true;
		else retrun false;
	}

	boolean Rect_Cmp_bord(Rectangle rect)
	{
		int x,y;
		x=rect.Getx();
		y=rect.Gety()
		//bord範囲内にあることの確認
		if((0<x)&&(x<board_width)&&(0<y)&&(y<board_height)) return true;
		else return false;
	}
	boolean Rect_Cmp_list(Rectangle rect)
	{
		boolean bool;
		for(Rectangle r:rectangleList)
        {
			if((r.Getx==rect.Getx)&&(r.Gety==rect.Gety)&&(r.Getwidth==rect.Getwidth)&&(r.Getheight==rect.Getheight) retrun false;
		}
		retun true;
	}
}