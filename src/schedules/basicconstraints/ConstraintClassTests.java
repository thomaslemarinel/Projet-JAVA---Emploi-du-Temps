package schedules.basicconstraints;

import schedules.activities.Activity;
import schedules.basicconstraints.*;

import schedulestests.basicconstraints.PrecedenceConstraintTests;
import schedulestests.basicconstraints.MeetConstraintTests;
import schedulestests.basicconstraints.PrecedenceConstraintWithGapTests;

public class ConstraintClassTests{
    
    public static void main(String[] args){
        
	boolean ok = true;
	//Tests pour la classe PrecedenceConstraint
	PrecedenceConstraintTests precedenceTester = new PrecedenceConstraintTests();
	ok = ok && precedenceTester.testGetFirst();
	ok = ok && precedenceTester.testGetSecond();
	ok = ok && precedenceTester.testIsSatisfiedBy();
	
	//Tests pour la classe MeetConstraint
	MeetConstraintTests meetTester = new MeetConstraintTests();
	ok = ok && meetTester.testGetFirst();
	ok = ok && meetTester.testGetSecond();
	ok = ok && meetTester.testIsSatisfiedBy();

	//Tests pour la classe PrecedenceConstraintWithGap
	PrecedenceConstraintWithGapTests precedenceConstraintWithGapTester = new PrecedenceConstraintWithGapTests();
	ok = ok && precedenceConstraintWithGapTester.testExtends();
	ok = ok && precedenceConstraintWithGapTester.testGetFirst();
	ok = ok && precedenceConstraintWithGapTester.testGetSecond();
	ok = ok && precedenceConstraintWithGapTester.testIsSatisfiedBy();
	
	System.out.println(ok ? "All tests passed" : "At least one test failed");
        
    }
}
