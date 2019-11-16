package eu.jpereira.trainings.designpatterns.creational.builder.model;

import eu.jpereira.trainings.designpatterns.creational.builder.json.JSONReportBody;

public class JSONReportBodyBuilder extends JSONReportBody implements ReportBodyBuilder {

    private JSONReportBody reportBody;

    public JSONReportBodyBuilder() {
        reportBody = new JSONReportBody();
    }

    @Override
    public ReportBodyBuilder setCustomerName(String customerName) {
        reportBody.addContent("sale:{customer:{");
        reportBody.addContent("name:\"");
        reportBody.addContent(customerName);
        reportBody.addContent("\"");
        return this;
    }

    @Override
    public ReportBodyBuilder setCustomerPhone(String phoneNumber) {
        reportBody.addContent("\",phone:\"");
        reportBody.addContent(phoneNumber);
        reportBody.addContent("\"}");
        return this;
    }

    @Override
    public ReportBodyBuilder withItems() {
        reportBody.addContent(",items:[");
        return this;
    }

    @Override
    public ReportBodyBuilder newItem(String name, int quantity, double price) {
        reportBody.addContent("{name:\"");
        reportBody.addContent(name);
        reportBody.addContent("\",quantity:");
        reportBody.addContent(String.valueOf(quantity));
        reportBody.addContent(",price:");
        reportBody.addContent(String.valueOf(price));
        reportBody.addContent("}");
        return this;
    }

    @Override
    public ReportBody getReportBody() {
        reportBody.addContent("]}");
        return reportBody;
    }
}
