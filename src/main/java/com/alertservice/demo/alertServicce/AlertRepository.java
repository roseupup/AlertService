package com.alertservice.demo.alertServicce;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface AlertRepository extends JpaRepository<Alert, String> {

    List<Alert> findByServiceIdAndAlertTsBetween(String serviceId, String startTs, String endTs);

}