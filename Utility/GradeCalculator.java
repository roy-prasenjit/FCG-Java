/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import Beans.Student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GradeCalculator {
    public static void calculate(String fileName){
        String txtFile = ".\\inputfiles\\" + fileName;
	BufferedReader br = null;
	String line = "";
	String textSplitBy = ",";
        List<Student> studentList = new ArrayList<Student>();
        
        //Create output and log files
        String outFileName = "outfile_" + fileName;
        String logFileName = "logfile_" + fileName;
        BufferedWriter bwOut = null;
        BufferedWriter bwLog = null;
        File outputFile = new File(".\\outputfiles\\" + outFileName);
        File logFile = new File(".\\logfiles\\" + logFileName);
        try{
        outputFile.createNewFile();
        logFile.createNewFile();
        bwOut = new BufferedWriter(new FileWriter(outputFile.getAbsoluteFile()));
        bwLog = new BufferedWriter(new FileWriter(logFile.getAbsoluteFile()));
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
        try {

		br = new BufferedReader(new FileReader(txtFile));
                int count = 0;
		while ((line = br.readLine()) != null) {
                        count++;
		        // use comma as separator
			String[] studentString = line.split(textSplitBy);
                        try{
                            Student student = loadStudent(studentString);
                            studentList.add(student);
                        }
                        catch(Exception spe){
                            bwLog.write("Error at line: " + count + "corresponding name " + studentString[0]);
							bwLog.newLine();
                        }
		}
                try{
                    generateOutput(studentList,bwOut);
                }catch(IOException iOException){
                    bwLog.write("unable to generate output file due to IOException");
					bwLog.newLine();
                }
	} catch (FileNotFoundException e) {
            try {
                bwLog.write("The file: " + fileName + " was not found");
				bwLog.newLine();
				System.out.println("File name doesnot exist. Please check the file name and try again");
				//outputFile.delete();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
                if(bwOut != null){
                    try {
				bwOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
                }
                
                if(bwLog!= null){
                    try {
				bwLog.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
                }

        }
    }

    private static Student loadStudent(String[] studentString) throws Exception{
        Student student = new Student();
        student.setName(studentString[0]);
        student.setHomeworkAssignment1(Float.parseFloat(studentString[1]));
        student.setHomeworkAssignment2(Float.parseFloat(studentString[2]));
        student.setHomeworkAssignment3(Float.parseFloat(studentString[3]));
        student.setMidTermScore(Float.parseFloat(studentString[4]));
        student.setProjectScore(Float.parseFloat(studentString[5]));
        student.setFinalScore(Float.parseFloat(studentString[6]));
        return student;
    }

    private static void generateOutput(List<Student> studentList, BufferedWriter bwOut) throws IOException {
        Iterator iterator = studentList.iterator();
        while(iterator.hasNext()){
            Student student = (Student)iterator.next();
            String line = student + " -- grade -- " + student.calculateGrade();
            bwOut.write(line);
            bwOut.newLine();
        }
    }
}
