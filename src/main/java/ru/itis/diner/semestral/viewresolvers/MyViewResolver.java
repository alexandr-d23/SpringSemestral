package ru.itis.diner.semestral.viewresolvers;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Map;


public class MyViewResolver extends FreeMarkerViewResolver {


    public MyViewResolver(String prefix, String suffix) {
        super(prefix, suffix);
    }

    @Override
    protected View createView(String viewName, Locale locale) throws Exception {
        if (viewName.startsWith("status:")) {
            MyFreeMarkerView view = new MyFreeMarkerView();
            int statusNumber = getStatusFromViewName(viewName);
            HttpStatus status = getHttpStatus(statusNumber);
            view.setRequiredStatus(status.value());
            return view;
        }
        System.out.println("My resolver");
        return super.createView("status", locale);
    }

    private HttpStatus getHttpStatus(int statusNumber){
        HttpStatus status = HttpStatus.resolve(statusNumber);
        if(status == null) throw new IllegalStateException("Incorrect status");
        return status;
    }

    private int getStatusFromViewName(String viewName){
        return Integer.parseInt(viewName.split(" ")[1]);
    }

    private class MyFreeMarkerView extends FreeMarkerView{

        private Integer status = null;

        public void setRequiredStatus(int status){
            this.status = status;
        }

        @Override
        public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
            if(status!= null){
                response.setStatus(status);
              //  response.getWriter().print("status: "+status);
            }
            super.render(model, request, response);
        }
    }
}
