package schedules.factoredtopologicalsort;

import schedules.activities.Activity;
import schedules.factoredconstraints.*;

import schedulestests.factoredtopologicalsort.TopologicalSorterTests;

//Classe executable permettant de realiser les tests concernant la classe TopologicalSorter
public class TopologicalSorterClassTests{
    
    public static void main(String[] args){
        
	boolean ok = true;
	TopologicalSorterTests tester = new TopologicalSorterTests();
	ok = ok && tester.testBruteForceSort();
	ok = ok && tester.testSchedule();
	ok = ok && tester.testLinearTimeSort();
	
	System.out.println(ok ? "All tests passed" : "At least one test failed");
        
    }
}
