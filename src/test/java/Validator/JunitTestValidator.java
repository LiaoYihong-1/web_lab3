package Validator;

import Data.Dot;
import Data.Validator;
import junit.framework.Assert;
import junit.framework.TestCase;

public class JunitTestValidator extends TestCase {
    Dot dot1 = new Dot(1.0,"2.0",3.0);
    Dot dot2 = new Dot(21.0,"32",40.0);
    Dot dot3 = new Dot(1.1,"2.1",2.3);
    public JunitTestValidator(){

    }
    public void testvalidatevalue(){
        System.out.print("Testing test_validate_value...\n");
        Assert.assertEquals(Validator.validateValues(dot1),true);
        Assert.assertEquals(Validator.validateValues(dot2), false);
        Assert.assertEquals(Validator.validateValues(dot3), true);
    }
    public void testvalidaterange(){
        System.out.print("Testing test_validate_range...\n");
        Assert.assertEquals(Validator.validateRange(dot1.getX(),Double.parseDouble(dot1.getY()),dot1.getR()),false);
        Assert.assertEquals(Validator.validateRange(dot2.getX(),Double.parseDouble(dot2.getY()),dot2.getR()),false);
        Assert.assertEquals(Validator.validateRange(dot3.getX(),Double.parseDouble(dot3.getY()),dot3.getR()),false);
    }
}
