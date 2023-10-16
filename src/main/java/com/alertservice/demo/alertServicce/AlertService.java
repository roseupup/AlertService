package com.alertservice.demo.alertServicce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlertService {

    @Autowired
    private AlertRepository alertRepository;

    public Alert addAlert(Alert alert) {
        return alertRepository.save(alert);
    }

    public List<Alert> getAlerts(String serviceId, String startTs, String endTs) {
        return alertRepository.findByServiceIdAndAlertTsBetween(serviceId, startTs, endTs);
    }

	public AlertRepository getAlertRepository() {
		return alertRepository;
	}

	public void setAlertRepository(AlertRepository alertRepository) {
		this.alertRepository = alertRepository;
	}
}
