package MB;

import lombok.Data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import Data.Dot;
@Data
@SessionScoped
@ManagedBean(name = "lab4")
public class RepeatChecker implements Repeat{
    public ArrayList<Dot> all_dots;
    private ArrayList<Dot> three_dot;
    public ArrayList<Dot> not_in_range;
    public Dot d = new Dot();
    public boolean repeated = true;
    @Override
    public void checkRepeat() {
        repeated = true;
        if(three_dot.size() < 3){
            repeated = false;
            return;
        }
        for(Dot d : three_dot){
            if(d.isHit()){
                repeated = false;
            }
        }
    }
    public void addDot(){
        all_dots.add(d);
        if(!d.isHit()){
            not_in_range.add(d);
        }
        if(three_dot.size()==3){
            three_dot.remove(three_dot.size()-1);
            three_dot.add(d);
        }else {
            three_dot.add(d);
        }
        checkRepeat();
    }
}
