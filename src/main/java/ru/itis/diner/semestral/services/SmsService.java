package ru.itis.diner.semestral.services;

public interface SmsService {
    void sendSms(String phone, String text);
}
