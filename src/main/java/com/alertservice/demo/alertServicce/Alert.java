package com.alertservice.demo.alertServicce;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alert {
	@Id
    private String alertId;
    private String serviceId;
    private String serviceName;
    private String model;
    private String alertType;
    private String severity;
    private String teamSlack;
    public Alert(String alertId, String serviceId, String serviceName, String model, String alertType, String alertTs,
			String severity, String teamSlack) {
		super();
		this.alertId = alertId;
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.model = model;
		this.alertType = alertType;
		this.alertTs = alertTs;
		this.severity = severity;
		this.teamSlack = teamSlack;
	}

	public Alert() {
		// TODO Auto-generated constructor stub
	}

	private String alertTs;
    public String getAlertId() {
		return alertId;
	}
	public void setAlertId(String alertId) {
		this.alertId = alertId;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getAlertType() {
		return alertType;
	}
	public void setAlertType(String alertType) {
		this.alertType = alertType;
	}
	public String getAlertTs() {
		return alertTs;
	}
	public void setAlertTs(String alertTs) {
		this.alertTs = alertTs;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getTeamSlack() {
		return teamSlack;
	}
	public void setTeamSlack(String teamSlack) {
		this.teamSlack = teamSlack;
	}
	@Override
	public String toString() {
		return "Alert [alertId=" + alertId + ", serviceId=" + serviceId + ", serviceName=" + serviceName + ", model="
				+ model + ", alertType=" + alertType + ", alertTs=" + alertTs + ", severity=" + severity
				+ ", teamSlack=" + teamSlack + "]";
	}
}
