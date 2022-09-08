package JMX;

import lombok.Data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import Data.Dot;
@Data
@SessionScoped
@ManagedBean(name = "lab4")
public class Repeat extends NotificationBroadcasterSupport implements RepeatMBean {
    private ArrayList<Dot> all_dots = new ArrayList<>();
    private ArrayList<Dot> three_dot = new ArrayList<>();
    private ArrayList<Dot> not_in_range = new ArrayList<>();
    private Dot d = new Dot();
    private int nums_total = all_dots.size();
    private int nums_not_hit = not_in_range.size();
    public boolean repeated = false;
    private int sequenceNumber = 0;

    private static final Repeat RB = new Repeat();
    public static Repeat getInstance() {
        return RB;
    }

    @Override
    public void checkRepeat() {
        setRepeated(true);
        if(three_dot.size() < 3){
            setRepeated(false);
            return;
        }
        for(Dot d : three_dot){
            if(d.isHit()){
                setRepeated(false);
            }
        }
        if(this.repeated){
            RB.sendMessage();
        }
        RB.setRepeated(repeated);
    }

    public void sendMessage(){
        sendNotification(new Notification("Repeat", this, sequenceNumber++,
                System.currentTimeMillis(), "Enter three dots not in range"));
    }
    public boolean isRepeated() {
        return repeated;
    }

    public void setRepeated(boolean repeated) {
        this.repeated = repeated;
    }

    public void addDot(){
        this.d = new Dot(d.getX(),d.getY(),d.getR());
        all_dots.add(d);
        if(!d.isHit()){
            not_in_range.add(d);
        }
        if(three_dot.size()==3){
            three_dot.remove(0);
            three_dot.add(d);
        }else {
            three_dot.add(d);
        }
        checkRepeat();
        nums_total = all_dots.size();
        nums_not_hit = not_in_range.size();
    }
}
