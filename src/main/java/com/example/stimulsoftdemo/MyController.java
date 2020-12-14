package com.example.stimulsoftdemo;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.stimulsoft.report.StiReport;
import com.stimulsoft.report.StiSerializeManager;
import com.stimulsoft.webviewer.StiWebViewerOptions;

@Controller
public class MyController {
	@Autowired
	ServletContext context;

	@GetMapping("/")
	public String indexAction( Model model ) throws Exception {
		String reportPath = context.getRealPath("/reports/Dashboards.mrt");
		StiReport report = StiSerializeManager.deserializeReport(new File(reportPath));
		report.render();
		StiWebViewerOptions options = new StiWebViewerOptions();

		model.addAttribute("reportPath", reportPath);
		model.addAttribute("report", report);
		model.addAttribute("options", options);
		
		return "index";
	}
}
