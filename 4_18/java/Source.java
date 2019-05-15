import java.util.ArrayList;
import java.util.List;
import java.awt.Rectangle;
import java.awt.Shape;
import java.lang.Object;

public class Source
{
    ArrayList<Object> List_object;
    Source()
    {
        List_object = new ArrayList<Object>();
    }

    int Add_rectangle(int x,int y,int width,int height)
    {
        List_object.add(new Rectangle(x,y,width,height));
        return List_object.size();
    }
    int Delete(int del)//4
    {
        try{
            List_object.remove(del);
        }catch(IndexOutOfBoundsException e) {
            return 1;
        }
        return 0;
    }
    int DeleteAll()//5
    {
        List_object.clear();
        return 0;
    }
    ArrayList<Object> Object_call(Object object)
    {
        ArrayList<Object> List_class = new ArrayList<Object>();
        List_class.clear();
        for(Object o:List_object)
        {
            if(o.getClass()==object.getClass());
                List_class.add(o);
        }
        return List_class;
    }
}