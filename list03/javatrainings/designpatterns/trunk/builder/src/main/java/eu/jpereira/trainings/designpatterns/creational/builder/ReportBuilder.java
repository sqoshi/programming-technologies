package eu.jpereira.trainings.designpatterns.creational.builder;

import eu.jpereira.trainings.designpatterns.creational.builder.json.JSONReportBody;
import eu.jpereira.trainings.designpatterns.creational.builder.model.Report;
import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBody;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SaleEntry;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SoldItem;
import eu.jpereira.trainings.designpatterns.creational.builder.xml.XMLReportBody;

import java.util.Iterator;

public class ReportBuilder {
    private int trash;
    private ReportBody reportBody;
    private SaleEntry saleEntry;


    public ReportBuilder(ReportBody reportBody, SaleEntry saleEntry) {
        this.reportBody = reportBody;
        this.saleEntry = saleEntry;
        System.out.println("Surprise");
    }

    public SaleEntry setSaleEntry(SaleEntry saleEntry) {

        return this.saleEntry = saleEntry;
    }

    public void setReportBody(ReportBody reportBody) {
        this.reportBody = reportBody;

    }
    public ReportBuilder setReport(String type) {

        // Algorithms to build the body objects are different
        if (type.equals("JSON")) {

            JSONReportBody reportBody = new JSONReportBody();
            //Add customer info
            reportBody.addContent("sale:{customer:{");
            reportBody.addContent("name:\"");
            reportBody.addContent(saleEntry.getCustomer().getName());
            reportBody.addContent("\",phone:\"");
            reportBody.addContent(saleEntry.getCustomer().getPhone());
            reportBody.addContent("\"}");
            //add array of items
            reportBody.addContent(",items:[");
            Iterator<SoldItem> it = saleEntry.getSoldItems().iterator();
            while ( it.hasNext() ) {
                SoldItem item = it.next();
                reportBody.addContent("{name:\"");
                reportBody.addContent(item.getName());
                reportBody.addContent("\",quantity:");
                reportBody.addContent(String.valueOf(item.getQuantity()));
                reportBody.addContent(",price:");
                reportBody.addContent(String.valueOf(item.getUnitPrice()));
                reportBody.addContent("}");
                if ( it.hasNext() ) {
                    reportBody.addContent(",");
                }

            }
            reportBody.addContent("]}");


            this.setReportBody(reportBody);

        } else if (type.equals("XML")) {
            XMLReportBody reportBody = new XMLReportBody();
            reportBody.putContent("<sale><customer><name>");
            reportBody.putContent(this.saleEntry.getCustomer().getName());
            reportBody.putContent("</name><phone>");
            reportBody.putContent(this.saleEntry.getCustomer().getPhone());
            reportBody.putContent("</phone></customer>");

            reportBody.putContent("<items>");

            Iterator<SoldItem> it = saleEntry.getSoldItems().iterator();
            while ( it.hasNext() ) {
                SoldItem soldEntry= it.next();
                reportBody.putContent("<item><name>");
                reportBody.putContent(soldEntry.getName());
                reportBody.putContent("</name><quantity>");
                reportBody.putContent(soldEntry.getQuantity());
                reportBody.putContent("</quantity><price>");
                reportBody.putContent(soldEntry.getUnitPrice());
                reportBody.putContent("</price></item>");
            }
            reportBody.putContent("</items></sale>");
            this.setReportBody(reportBody);
        } else if (type.equals("HTML")) {

            HTMLReportBody reportBody = new HTMLReportBody();
            reportBody.putContent("<span class=\"customerName\">");
            reportBody.putContent(this.saleEntry.getCustomer().getName());
            reportBody.putContent("</span><span class=\"customerPhone\">");
            reportBody.putContent(this.saleEntry.getCustomer().getPhone());
            reportBody.putContent("</span>");

            reportBody.putContent("<items>");

            Iterator<SoldItem> it = saleEntry.getSoldItems().iterator();
            while ( it.hasNext() ) {
                SoldItem soldEntry= it.next();
                reportBody.putContent("<item><name>");
                reportBody.putContent(soldEntry.getName());
                reportBody.putContent("</name><quantity>");
                reportBody.putContent(soldEntry.getQuantity());
                reportBody.putContent("</quantity><price>");
                reportBody.putContent(soldEntry.getUnitPrice());
                reportBody.putContent("</price></item>");
            }
            reportBody.putContent("</items>");
            this.setReportBody(reportBody);
        }

        return this;
    }
    public Report build(){
        return new Report(this);
    }

}
