import Data.Validator;
import Data.Dot;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class JunitTestValidator {
    Dot dot1 = new Dot(1.0,"2.0",3.0);
    Dot dot2 = new Dot(21.0,"32",40.0);
    Dot dot3 = new Dot(1.1,"2.1",2.3);
    public JunitTestValidator(){

    }
    @BeforeClass
    public static void go(){
        System.out.print("JunitTestValidator started\n");
    }
    @Test
    public void test_validate_value(){
        System.out.print("Testing test_validate_value...\n");
        assertEquals(Validator.validateValues(dot1),true);
        assertEquals(Validator.validateValues(dot2), false);
        assertEquals(Validator.validateValues(dot3), true);
    }
    @Test
    public void test_validate_range(){
        System.out.print("Testing test_validate_range...\n");
        assertEquals(Validator.validateRange(dot1.getX(),Double.parseDouble(dot1.getY()),dot1.getR()),false);
        assertEquals(Validator.validateRange(dot2.getX(),Double.parseDouble(dot2.getY()),dot2.getR()),false);
        assertEquals(Validator.validateRange(dot3.getX(),Double.parseDouble(dot3.getY()),dot3.getR()),false);
    }
    @AfterClass
    public static void start(){
        System.out.print("JunitTestValidator ended\n");
    }
}
