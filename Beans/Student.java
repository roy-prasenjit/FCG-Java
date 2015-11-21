/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

public class Student {
    private String name;
    private float homeworkAssignment1;
    private float homeworkAssignment2;
    private float homeworkAssignment3;
    private float midTermScore;
    private float projectScore;
    private float finalScore;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHomeworkAssignment1() {
        return homeworkAssignment1;
    }

    public void setHomeworkAssignment1(float homeworkAssignment1) {
        this.homeworkAssignment1 = homeworkAssignment1;
    }

    public float getHomeworkAssignment2() {
        return homeworkAssignment2;
    }

    public void setHomeworkAssignment2(float homeworkAssignment2) {
        this.homeworkAssignment2 = homeworkAssignment2;
    }

    public float getHomeworkAssignment3() {
        return homeworkAssignment3;
    }

    public void setHomeworkAssignment3(float homeworkAssignment3) {
        this.homeworkAssignment3 = homeworkAssignment3;
    }

    public float getMidTermScore() {
        return midTermScore;
    }

    public void setMidTermScore(float midTermScore) {
        this.midTermScore = midTermScore;
    }

    public float getProjectScore() {
        return projectScore;
    }

    public void setProjectScore(float projectScore) {
        this.projectScore = projectScore;
    }

    public float getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(float finalScore) {
        this.finalScore = finalScore;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", homeworkAssignment1=" + homeworkAssignment1 + ", homeworkAssignment2=" + homeworkAssignment2 + ", homeworkAssignment3=" + homeworkAssignment3 + ", midTermScore=" + midTermScore + ", projectScore=" + projectScore + ", finalScore=" + finalScore + '}';
    }
    
    
    public String calculateGrade(){
        String grade = "";
        float homeworkAssignmentScore = (float) (0.45*((this.getHomeworkAssignment1() + this.getHomeworkAssignment2() + this.getHomeworkAssignment3())/3));
        float final_numerical_grade = homeworkAssignmentScore + 0.25f*this.getProjectScore()+ 0.30f*((this.getMidTermScore() + this.getFinalScore())/2);
        if (final_numerical_grade >= 90 && final_numerical_grade <= 100){
            grade = "A";
        }
        else if(final_numerical_grade >= 80 && final_numerical_grade <= 89){
            grade = "B";
        }
        else if(final_numerical_grade >= 70 && final_numerical_grade <= 79){
            grade = "C";
        }
        else if(final_numerical_grade >= 60 && final_numerical_grade <= 69){
            grade = "D";
        }
        else{
            grade = "F";
        }
        return grade;
    }
}
