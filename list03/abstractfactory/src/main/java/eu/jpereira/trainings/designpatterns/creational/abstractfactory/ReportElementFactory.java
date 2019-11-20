package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

public abstract class ReportElementFactory {
    public abstract ReportBody setReportBody();

    public abstract ReportFooter setReportFooter();

    public abstract ReportHeader setReportHeader();
}
