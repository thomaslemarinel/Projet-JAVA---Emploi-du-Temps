package schedules.activities;

import schedulestests.activities.ActivityTests;
import schedules.activities.Activity;

public class ActivityClassTests{
    
    public static void main(String[] args){
        
	boolean ok = true;
	ActivityTests activityTester = new ActivityTests();
	ok = ok && activityTester.testGetDescription();
	ok = ok && activityTester.testGetDuration();
	System.out.println(ok ? "All tests passed" : "At least one test failed");
        
    }
}
