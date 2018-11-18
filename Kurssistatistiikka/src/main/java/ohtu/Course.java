package ohtu;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private int week;
    private String name;
    private List<Integer> exercises;
    private String term;
    private int year;
    private List<Submission> submissions;
    private String fullName;

    public Course () {
        this.submissions = new ArrayList<>();
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getWeek() {
        return week;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    
    public void setExercises(int exercise) {
        this.exercises.add(exercise);
    }

    public List getExercises() {
        return exercises;
    }

    public void setSubmission(Submission submission) {
        this.submissions.add(submission);
    }

    public List getSubmission() {
        return submissions;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTerm() {
        return term;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }    

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        System.out.println(fullName+" "+term+" "+ year+"\n");
        int allExercises = 0;
        for (Integer ex : exercises) {
            allExercises+=ex;
        }
        
        int allDoneExercises = 0;
        int allHours = 0;
        for (Submission submission : submissions) {
            System.out.println("viikko "+submission.getWeek()+":\n tehtyjä tehtäviä "+
            submission.getExercises().size()+"/"+this.exercises.get(submission.getWeek())+" aikaa kului " + 
            submission.getHours()+ " tehdyt tehtävät: "+submission.getExercises());
            allDoneExercises+=submission.getExercises().size();
            allHours+=submission.getHours();
        }

        return "\nyhteensä " +allDoneExercises + "/"+allExercises+" tehtävää ja " + allHours +" tuntia\n";
    }
    
}