package org.howard.edu.lsp.finalexam.question2;

/**
 * Concrete report that displays course name and enrollment count.
 * Implements the variable steps of the Template Method defined in Report.
 */
public class CourseReport extends Report {

    private String courseName;
    private int enrollment;

    @Override
    protected void loadData() {
        courseName = "CSCI 363";
        enrollment = 45;
    }

    @Override
    protected void formatHeader() {
        System.out.println("Course Report");
    }

    @Override
    protected void formatBody() {
        System.out.println("Course: " + courseName);
        System.out.println("Enrollment: " + enrollment);
    }

    @Override
    protected void formatFooter() {
        System.out.println("End of Course Report");
    }
}
