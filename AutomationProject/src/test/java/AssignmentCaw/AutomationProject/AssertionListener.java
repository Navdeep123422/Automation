package AssignmentCaw.AutomationProject;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class AssertionListener implements ITestListener {

	// onTestSuccess is called when a test method passes.
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Method Passed: " + result.getName());
	}

    //onTestFailure is called when a test method fails due to an assertion failure.
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Method Failed: " + result.getName());
		System.out.println("Assertion Error Message: " + result.getThrowable().getMessage());
	}

}
