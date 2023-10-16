package com.alertservice.demo.alertServicce;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlertController {
	
	@Autowired
    private AlertService alertService;
	
	//Alert Service Post API
	@PostMapping("alerts")
    public ResponseEntity<Map<String, String>> addAlert(@RequestBody Alert alert) {
        try {
            alertService.addAlert(alert);
            return ResponseEntity.ok(Map.of("alert_id", alert.getAlertId(), "error", ""));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("alert_id", alert.getAlertId(), "error", ex.getMessage()));
        }
    }
	
	//Alert Service Get API
	@GetMapping("/alerts")
	public ResponseEntity<Object> getAlerts(@RequestParam String service_id,
		            @RequestParam String start_ts,
		            @RequestParam String end_ts) {
		try {
			List<Alert> alerts = alertService.getAlerts(service_id, start_ts, end_ts);
			//If no Alerts found
			if (alerts.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(Map.of("success", false, "error", "No alerts found"));
			}
			//Found Alerts
			Map<String, Object> response = new HashMap<>();
			response.put("service_id", service_id);
			response.put("service_name", alerts.get(0).getServiceName());
			response.put("alerts", alerts);
			return ResponseEntity.ok(response);
			} catch (Exception ex) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(Map.of("success", false, "error", ex.getMessage()));
			}
	}

}

