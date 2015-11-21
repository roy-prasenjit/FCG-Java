/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import Utility.GradeCalculator;

/**
 *
 * @author hp
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Start");
		try{
        GradeCalculator.calculate(args[0]);
        System.out.println("Respective Output and Log Files generated");
        System.out.println("End");
		}
		catch(Exception e){
			System.out.println("There seems to be an error in the file Name. Try again");
		}
    }
    
}
