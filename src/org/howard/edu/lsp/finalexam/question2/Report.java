package org.howard.edu.lsp.finalexam.question2;

/**
 * Abstract base class that defines the Template Method pattern for report generation.
 * The fixed workflow is: loadData -> formatHeader -> formatBody -> formatFooter.
 * Subclasses implement each variable step; generateReport() enforces the order.
 */
public abstract class Report {

    /**
     * Template method — defines and enforces the fixed report workflow.
     * Declared final so subclasses cannot reorder or skip steps.
     */
    public final void generateReport() {
        loadData();
        System.out.println("=== HEADER ===");
        formatHeader();
        System.out.println();
        System.out.println("=== BODY ===");
        formatBody();
        System.out.println();
        System.out.println("=== FOOTER ===");
        formatFooter();
        System.out.println();
    }

    /** Loads report-specific data into fields. */
    protected abstract void loadData();

    /** Prints the report-specific header content. */
    protected abstract void formatHeader();

    /** Prints the report-specific body content. */
    protected abstract void formatBody();

    /** Prints the report-specific footer content. */
    protected abstract void formatFooter();
}
