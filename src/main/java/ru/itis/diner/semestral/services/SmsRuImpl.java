package ru.itis.diner.semestral.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutorService;

@Component
public class SmsRuImpl implements SmsService {

    @Autowired
    private ExecutorService executorService;

    @Value("${sms.ru.url}")
    private String smsUrl;

    @Value("${sms.ru.api_id}")
    private String smsApiId;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void sendSms(String phone, String text) {
        String url = smsUrl + "?api_id=" + smsApiId + "&to=" + phone + "&msg=" + text + "&json=1";
        executorService.submit(() -> {
            restTemplate.getForObject(url, String.class);
        });
    }
}
