package ru.itis.diner.semestral.entities;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Map;

public interface UserParametersService {
    Map<String, String> getValuesFromRequest(HttpServletRequest request);
    Collection<String> getUserParameters();
}
