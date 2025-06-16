package schedules.solvers;

import schedules.activities.Activity;
import schedules.constraints.*;

import schedulestests.solvers.TopologicalSorterTests;
import schedulestests.solvers.VerifierTests;

//Classe executable permettant de realiser les tests concernant la classe TopologicalSorter
public class TopologicalSorterClassTests{
    
    public static void main(String[] args){
        
	boolean ok = true;
	TopologicalSorterTests tester = new TopologicalSorterTests();
	ok = ok && tester.testBruteForceSort();
	ok = ok && tester.testSchedule();
	ok = ok && tester.testLinearTimeSort();

	VerifierTests verifierTester = new VerifierTests();
	ok = ok && verifierTester.testUnsatisfied();
	
	System.out.println(ok ? "All tests passed" : "At least one test failed");
        
    }
}
