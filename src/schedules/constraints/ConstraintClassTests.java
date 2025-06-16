package schedules.constraints;

import schedules.activities.Activity;
import schedules.constraints.*;

import schedulestests.constraints.AbstractionTests;
import schedulestests.constraints.MaxSpanConstraintTests;
import schedulestests.constraints.MeetConstraintTests;
import schedulestests.constraints.PrecedenceConstraintTests;
import schedulestests.constraints.PrecedenceConstraintWithGapTests;
import schedulestests.constraints.UnaryConstraintTests;

public class ConstraintClassTests{
    
    public static void main(String[] args){
        
	boolean ok = true;
	//Precedence constraints
	PrecedenceConstraintTests precedenceConstraintTester = new PrecedenceConstraintTests();
	ok = ok && precedenceConstraintTester.testGetFirst();
	ok = ok && precedenceConstraintTester.testGetSecond();
	ok = ok && precedenceConstraintTester.testExtends();
	ok = ok && precedenceConstraintTester.testIsSatisfied();
	
	//Meet constraints
	MeetConstraintTests meetConstraintTester = new MeetConstraintTests();
	ok = ok && meetConstraintTester.testGetFirst();
	ok = ok && meetConstraintTester.testGetSecond();
	ok = ok && meetConstraintTester.testExtends();
	ok = ok && meetConstraintTester.testIsSatisfied();
	
	//Precedence constraints with gap
	PrecedenceConstraintWithGapTests precedenceConstraintWithGapTester = new PrecedenceConstraintWithGapTests();
	ok = ok && precedenceConstraintWithGapTester.testExtends();
	ok = ok && precedenceConstraintWithGapTester.testGetFirst();
	ok = ok && precedenceConstraintWithGapTester.testGetSecond();
	ok = ok && precedenceConstraintWithGapTester.testIsSatisfied();

	//Abstract class
	AbstractionTests abstractionTester = new AbstractionTests();
	ok = ok && abstractionTester.testImplements();
	ok = ok && abstractionTester.testGetActivities();
	ok = ok && abstractionTester.testIsSatisfied();

	//Unary constraints
	UnaryConstraintTests unaryConstraintTester = new UnaryConstraintTests();
	ok = ok && unaryConstraintTester.testImplements();
	ok = ok && unaryConstraintTester.testGetActivities();
	ok = ok && unaryConstraintTester.testIsSatisfied();
	
	//Max span constraints
	MaxSpanConstraintTests maxSpanConstraintTester = new MaxSpanConstraintTests();
	ok = ok && maxSpanConstraintTester.testImplements();
	ok = ok && maxSpanConstraintTester.testGetActivities();
	ok = ok && maxSpanConstraintTester.testIsSatisfied();

	System.out.println(ok ? "All tests passed" : "At least one test failed");
	
	}
	
}
