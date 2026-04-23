package org.howard.edu.lsp.finalexam.question2;

import java.util.ArrayList;
import java.util.List;

/**
 * Driver that demonstrates the Template Method pattern via polymorphism.
 * Both report types are stored as Report references and driven through
 * the same generateReport() call, with each subclass supplying its own steps.
 */
public class ReportDriver {

    public static void main(String[] args) {
        List<Report> reports = new ArrayList<>();
        reports.add(new StudentReport());
        reports.add(new CourseReport());

        for (Report report : reports) {
            report.generateReport();
        }
    }
}
