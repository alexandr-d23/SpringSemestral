package ru.itis.diner.semestral.util;

public interface MailGenerator {
    String getMailForConfirm(String serverUrl, String code);
}
