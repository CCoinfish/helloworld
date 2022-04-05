
import java.util.HashMap;
import java.util.Map;

public class Chess {
    Map<Map<Integer, Integer>, Integer> map = new HashMap<Map<Integer, Integer>, Integer>();
    Boolean isBegin=false;
    public Chess() {
    }

    public Integer NowColor(Integer x, Integer y) {
        HashMap<Integer, Integer> now = new HashMap();
        now.put(x, y);
        Integer NowColor = map.get(now);
        if(NowColor==null){
            NowColor=0;
        }
        return NowColor;
    }
  public Integer X_Count(Integer x,Integer y,Integer key){
        Integer count=0;
        Integer NOw=x;
        while(NOw>=40&&NowColor(NOw, y)==key){
           NOw-=40;
           count++;
        }
        NOw=x;
        while (NOw<=800&&NowColor(NOw, y)==key){
            NOw+=40;
            count++;
        }
        return count-1;
  }
    public Integer Y_Count(Integer x,Integer y,Integer key){
        Integer count=0;
        Integer NOw=y;
        while(NowColor(x, NOw)==key&&NOw>=40){
            NOw-=40;
            count++;
        }
        NOw=y;
        while (NowColor(x, NOw)==key&&NOw<=800){
            NOw+=40;
            count++;
        }
        return count-1;
    }
    public Integer XAndY_Count(Integer x,Integer y,Integer key){
        Integer count=0;
        Integer NOw1=x;
        Integer NOw2=y;
        while(NowColor(NOw1, NOw2)==key&&NOw1>=40&&NOw2>=40) {
            NOw1-=40;
            NOw2-=40;
            count++;
        }
        NOw1=x;
        NOw2=y;
        while (NowColor(NOw1, NOw2)==key&&NOw1<=800&&NOw2<=800){
            NOw1+=40;
            NOw2-=40;
            count++;
        }

        return count-1;
    }
    public Integer YAndX_Count(Integer x,Integer y,Integer key){
        Integer count=0;
        Integer NOw1=x;
        Integer NOw2=y;
        while(NowColor(NOw1, NOw2)==key&NOw1>=40&NOw2<=800) {
            NOw1-=40;
            NOw2+=40;
            count++;
        }
        NOw1=x;
        NOw2=y;
        while (NowColor(NOw1, NOw2)==key&NOw1<=800&NOw2>=40){
            NOw1+=40;
            NOw2-=40;
            count++;
        }

        return count-1;
    }

   public Boolean isWin(Integer x,Integer y,Integer key){

        if(X_Count(x,y,key)>=5){
          return true;
        }
       if(Y_Count(x,y,key)>=5){
           return true;
       }
       if(XAndY_Count(x, y,key)>=5){
           return true;
       }
       if(YAndX_Count(x, y,key)>=5){
           return true;
       }
        return false;
   }

}