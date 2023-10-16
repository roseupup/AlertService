package com.alertservice.demo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import com.alertservice.demo.alertServicce.Alert;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
//To test the get API properly, banned the default rolling back action of database
@Rollback(false)
public class AlertControllerTest {
	@Autowired
    private MockMvc mockMvc;
//    @MockBean
//    private AlertService alertService;
    
    @Autowired
    private ObjectMapper objectMapper; 
    
    
    @Test
    public void testAddAndGetAlert_Success() throws Exception {
        Alert alert = new Alert("b950482e9911ec7e41f7ca5e5d9a424f", "my_test_service_id", "my_test_service", 
                                "my_test_model", "anomaly", "1695644160", "warning", "slack_ch");
        
        //Post an alert
        mockMvc.perform(post("/alerts")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(alert)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.alert_id").value("b950482e9911ec7e41f7ca5e5d9a424f"))
                    .andExpect(jsonPath("$.error").isEmpty());

        //Get alerts of my_test_service_id as service id and start_ts/end_ts between 0-2000000000
        mockMvc.perform(get("/alerts")
                .param("service_id", "my_test_service_id")
                .param("start_ts", "0") 
                .param("end_ts", "2000000000") 
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.service_id").value("my_test_service_id"))
                .andExpect(jsonPath("$.alerts[0].alertId").value("b950482e9911ec7e41f7ca5e5d9a424f"));
    }
    
    
    

}
