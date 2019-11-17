package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

import eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml.XMLReportBody;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml.XMLReportFooter;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml.XMLReportHeader;

public class XMLReportElementFactory extends ReportElementFactory {
    @Override
    public ReportBody setReportBody() {
        return new XMLReportBody();
    }

    @Override
    public ReportFooter setReportFooter() {
        return new XMLReportFooter();
    }

    @Override
    public ReportHeader setReportHeader() {
        return new XMLReportHeader();
    }
}
