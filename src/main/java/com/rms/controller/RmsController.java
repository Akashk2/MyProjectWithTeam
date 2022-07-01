package com.rms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.rms.model.CandidatesDetails;
import com.rms.model.FinalResponse;
import com.rms.service.RmsService;

@RestController
public class RmsController {

	@Autowired
	private RmsService rmsService;

	@RequestMapping("/")
    public ModelAndView admissionForm() {
        return new ModelAndView("addCandidate");
    }
	@PostMapping("/addCandidate")
	public String addCandidate(@ModelAttribute CandidatesDetails candidatesDetails) {
		return rmsService.addCandidate(candidatesDetails);
	}
	
	@RequestMapping("/home")
    public ModelAndView allCandidatesUi() {
        return new ModelAndView("home");
    }
	
	@GetMapping("/getAllCandidate")
	public List<CandidatesDetails> getAllCandidate() {
		return rmsService.getAllCandidate();
	}
	
	@GetMapping("/countCandidate")
	public FinalResponse countCandidate() {
		return rmsService.countCandidate();
	}
	
	@GetMapping("/lessThanMonth")
	public FinalResponse lastWeek() {
		return rmsService.countCandidateUpdatedInOneWeek();
	}
	
	@GetMapping("/getTotalRes")
	public FinalResponse getTotalres() {
		return rmsService.getTotalres();
	}
	
	@GetMapping("/lastMonth")
	public FinalResponse lastMonth() {
		return rmsService.countCandidateUpdatedInOneMonth();
	}
	
	@GetMapping("/lastYear")
	public FinalResponse lastYear() {
		return rmsService.countCandidateUpdatedInOneYear();
	}
	
	@GetMapping("/resumeUploadsSummary")
	public FinalResponse resumeUploadsSummary() {
		return rmsService.resumeUploadsSummary();
	}
}
