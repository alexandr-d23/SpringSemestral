package ru.itis.diner.semestral.entities;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class ValidatedUserParameters implements UserParametersService {
    List<String> list;

    public ValidatedUserParameters(){
        list = new ArrayList<>();
        list.add("email");
        list.add("name");
        list.add("password");
        list.add("gender");
        list.add("country");
    }

    @Override
    public Map<String, String> getValuesFromRequest(HttpServletRequest request) {
        Map<String,String> result = new TreeMap<>();
        for(String s : list){
            result.put(s, request.getParameter(s));
        }
        return result;
    }

    @Override
    public Collection<String> getUserParameters() {
        return list;
    }
}
