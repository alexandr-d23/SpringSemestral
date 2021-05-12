package ru.itis.diner.semestral.util;

public interface EmailUtil {
    void send(String to, String subject, String from, String text);
}
