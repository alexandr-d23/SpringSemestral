package ru.itis.diner.semestral.servlet.project;

public class Answer<T> {
    private final boolean isSuccessful;
    private String description;
    private T resource;

    public Answer(boolean isValidated) {
        this.isSuccessful = isValidated;
        description = "";
    }

    public Answer(boolean isValidated, String description) {
        this.isSuccessful = isValidated;
        this.description = description;
    }

    public T getResource() {
        return resource;
    }

    public void setResource(T resource) {
        this.resource = resource;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public String getDescription() {
        return description;
    }
}
