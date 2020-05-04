package com.amdexa.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.ServletContextAware;
//import com.icesoft.faces.webapp.CompatResourceServlet;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;

@SpringBootApplication
public class App implements ServletContextAware {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
        servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", "true");
        servletContext.setInitParameter("javax.faces.STATE_SAVING_METHOD", "server");
        servletContext.setInitParameter("com.icesoft.faces.uploadDirectory", "upload");
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
        servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", "true");
    }


    @Bean
    public ServletRegistrationBean<FacesServlet> facesServletRegistrationBean() {
        ServletRegistrationBean<FacesServlet> servletRegistrationBean = new ServletRegistrationBean<>(
                new FacesServlet(), "*.jsf", "/icefaces/*");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }


    /*@Bean
    public ServletRegistrationBean<CompatResourceServlet> resourceServletRegistrationBean() {
        ServletRegistrationBean<CompatResourceServlet> servletRegistrationBean = new ServletRegistrationBean<>(
                new CompatResourceServlet(), "/xmlhttp/*");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }*/
}