package eu.jpereira.trainings.designpatterns.creational.abstractfactory;


import eu.jpereira.trainings.designpatterns.creational.abstractfactory.json.JSONReportBody;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.json.JSONReportFooter;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.json.JSONReportHeader;

public class JSONReportElementFactory extends ReportElementFactory {
    @Override
    public ReportBody setReportBody() {
        return new JSONReportBody();
    }

    @Override
    public ReportFooter setReportFooter() {
        return new JSONReportFooter();
    }

    @Override
    public ReportHeader setReportHeader() {
        return new JSONReportHeader();
    }
}