package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // ÄLÄ laita githubiin omaa opiskelijanumeroasi
        String studentNr = "012345678";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/courses/students/"+studentNr+"/submissions";
        String url2 = "https://studies.cs.helsinki.fi/courses/courseinfo";

        String bodyText = Request.Get(url).execute().returnContent().asString();
        String bodyText2 = Request.Get(url2).execute().returnContent().asString();

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        Course[] courses = mapper.fromJson(bodyText2, Course[].class);
        
        System.out.println("Opiskelijanumero: " + studentNr+"\n");

        for (Submission submission : subs) {
            for (Course course : courses) {
                if (submission.getCourse().equals(course.getName())) {
                    course.setSubmission(submission);
                }
            }
        }

        for (Course course : courses) {
            if (!course.getSubmission().isEmpty()) {
                System.out.println(course);
            }
        }

    }
}