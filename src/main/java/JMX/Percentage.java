package JMX;

import lombok.Data;
import Data.Dot;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.management.NotificationBroadcasterSupport;
@Data
@SessionScoped
@ManagedBean(name = "percentage")
public class Percentage extends NotificationBroadcasterSupport implements PercentageMBean {
    private int all_nums = 0;
    private int hit = 0;
    private double percentage = 0;
    private Dot dot = new Dot();

    private static final Percentage PB = new Percentage();

    public static Percentage getInstance(){
        return PB;
    }

    @Override
    public void percentageGet() {
        update();
        if(all_nums!=0){
            this.percentage = (double) Math.round(hit*100/all_nums)/100;
        }
    }

    public void update(){
        dot = new Dot(dot.getX(),dot.getY(),dot.getR());
        if(dot.isHit()){
            hit = hit+1;
        }
        all_nums = all_nums + 1;
    }
}
