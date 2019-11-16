package eu.jpereira.trainings.designpatterns.creational.builder.model;

import eu.jpereira.trainings.designpatterns.creational.builder.xml.XMLReportBody;

public class XMLReportBodyBuilder extends XMLReportBody implements ReportBodyBuilder {

    XMLReportBody reportBody = new XMLReportBody();/*
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
			report.setReportBody(reportBody);
     */

    public XMLReportBodyBuilder() {
        reportBody = new XMLReportBody();
    }

    @Override
    public ReportBodyBuilder setCustomerName(String customerName) {
        reportBody.putContent("<sale><customer><name>");
        reportBody.putContent(customerName);
        reportBody.putContent("</name>");
        return this;
    }

    @Override
    public ReportBodyBuilder setCustomerPhone(String phoneNumber) {
        reportBody.putContent("</name><phone>");
        reportBody.putContent(phoneNumber);
        reportBody.putContent("</phone></customer>");
        return null;
    }

    @Override
    public ReportBodyBuilder withItems() {
        reportBody.putContent("<items>");
        return null;
    }

    @Override
    public ReportBodyBuilder newItem(String name, int quantity, double price) {
        reportBody.putContent("<item><name>");
        reportBody.putContent(name);
        reportBody.putContent("</name><quantity>");
        reportBody.putContent(quantity);
        reportBody.putContent("</quantity><price>");
        reportBody.putContent(price);
        reportBody.putContent("</price></item>");
        return null;
    }

    @Override
    public ReportBody getReportBody() {
        reportBody.putContent("</items></sale>");
        return reportBody;
    }
}
