package schedules.factoredconstraints;

import schedules.activities.Activity;
import schedules.factoredconstraints.*;

import schedulestests.factoredconstraints.AbstractionTests;
import schedulestests.factoredconstraints.MeetConstraintTests;
import schedulestests.factoredconstraints.PrecedenceConstraintTests;
import schedulestests.factoredconstraints.PrecedenceConstraintWithGapTests;

public class ConstraintClassTests{
    
    public static void main(String[] args){
        
	boolean ok = true;
	//Precedence constraints
	PrecedenceConstraintTests precedenceConstraintTester = new PrecedenceConstraintTests();
	ok = ok && precedenceConstraintTester.testGetFirst();
	ok = ok && precedenceConstraintTester.testGetSecond();
	ok = ok && precedenceConstraintTester.testExtends();
	ok = ok && precedenceConstraintTester.testIsSatisfiedBy();
	
	//Meet constraints
	MeetConstraintTests meetConstraintTester = new MeetConstraintTests();
	ok = ok && meetConstraintTester.testGetFirst();
	ok = ok && meetConstraintTester.testGetSecond();
	ok = ok && meetConstraintTester.testExtends();
	ok = ok && meetConstraintTester.testIsSatisfiedBy();
	
	//Precedence constraints with gap
	PrecedenceConstraintWithGapTests precedenceConstraintWithGapTester = new PrecedenceConstraintWithGapTests();
	ok = ok && precedenceConstraintWithGapTester.testExtends();
	ok = ok && precedenceConstraintWithGapTester.testGetFirst();
	ok = ok && precedenceConstraintWithGapTester.testGetSecond();
	ok = ok && precedenceConstraintWithGapTester.testIsSatisfiedBy();
	
	//Abstract class
	AbstractionTests abstractionTester = new AbstractionTests();
	ok = ok && abstractionTester.test();
	
	System.out.println(ok ? "All tests passed" : "At least one test failed");
        
    }
}
