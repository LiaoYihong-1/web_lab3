import JMX.Percentage;
import JMX.Repeat;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class Main {
    private static String repeatBean =  "MyBean:type=mbean,name=repeat";
    private static String percentageBean =  "MyBean:type=mbean,name=percentage";
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        System.out.println("Trying to Read beans.\n");
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName pName = new ObjectName(repeatBean);
        ObjectName rName = new ObjectName(percentageBean);
        server.registerMBean(new Repeat(), rName);
        server.registerMBean(new Percentage(), pName);
        while(true){

        }
    }
}
