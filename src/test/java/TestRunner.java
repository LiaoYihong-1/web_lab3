import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
public class TestRunner {
    public static void main(String[] args) {
        Result result_1 = JUnitCore.runClasses(JunitTestValidator.class);
        System.out.print("Result of testing Validator:\n");
        for(Failure failure:result_1.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println(result_1.wasSuccessful());
    }
}
