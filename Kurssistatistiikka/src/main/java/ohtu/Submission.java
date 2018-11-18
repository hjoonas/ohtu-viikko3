package ohtu;

import java.util.List;

public class Submission {
    private int week;
    private int hours;
    private List<Integer> exercises;
    private String course;

    public void setWeek(int week) {
        this.week = week;
    }

    public int getWeek() {
        return week;
    }

    public void setHours(int hour) {
        this.hours = hour;
    }

    public int getHours() {
        return hours;
    }
    
    public void setExercises(int exercise) {
        this.exercises.add(exercise);
    }

    public List getExercises() {
        return exercises;
    }
    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "tehtyjä tehtäviä yhteensä " + exercises.size()+" aikaa kului "+ hours+ " tehdyt tehtävät: "+exercises;
    }
    
}