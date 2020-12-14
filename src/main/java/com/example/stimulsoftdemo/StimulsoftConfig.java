package com.example.stimulsoftdemo;

import javax.servlet.http.HttpServlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stimulsoft.web.servlet.StiWebResourceServlet;
import com.stimulsoft.webviewer.servlet.StiWebViewerActionServlet;

@Configuration
public class StimulsoftConfig {
	@Bean
	public ServletRegistrationBean<HttpServlet> webviewerActionBean() {
		ServletRegistrationBean<HttpServlet> servRegBean = new ServletRegistrationBean<>();
	    servRegBean.setServlet(new StiWebViewerActionServlet());
	    servRegBean.addUrlMappings("/stimulsoft_webviewer_action");
	    servRegBean.setLoadOnStartup(1);
	    System.out.println("Webserver Registered");
	    return servRegBean;
	}

	@Bean
	public ServletRegistrationBean<HttpServlet> webResourceBean() {
		ServletRegistrationBean<HttpServlet> servRegBean = new ServletRegistrationBean<>();
	    servRegBean.setServlet(new StiWebResourceServlet());
	    servRegBean.addUrlMappings("/stimulsoft_web_resource/*");
	    servRegBean.setLoadOnStartup(1);
	    System.out.println("Resources Registered");
	    return servRegBean;
	}
}
