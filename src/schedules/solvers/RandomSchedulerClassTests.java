package schedules.solvers;

import schedules.activities.Activity;
import schedules.constraints.*;
import java.util.Random;

import schedulestests.solvers.RandomSchedulerTests;

//Classe executable permettant de realiser les tests concernant la classe RandomScheduler
public class RandomSchedulerClassTests{
    
    public static void main(String[] args){
    
    boolean ok = true;
    Random random = new Random();
	RandomSchedulerTests randomSchedulerTester = new RandomSchedulerTests(random);
    ok = ok && randomSchedulerTester.testGenerateSchedule();
	
	System.out.println(ok ? "All tests passed" : "At least one test failed");
        
    }
}
