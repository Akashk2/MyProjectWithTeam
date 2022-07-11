package com.rms.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.dao.RmsDao;
import com.rms.model.CandidatesDetails;
import com.rms.model.FinalResponse;

@Service
public class RmsService {

	@Autowired
	private RmsDao rmsDao;
	
	public String addCandidate(CandidatesDetails candidatesDetails) {
		
		String substring = candidatesDetails.getUploadedBy().toUpperCase().substring(0, 3);
		candidatesDetails.setUploadedBy(substring);
		String upperCase = candidatesDetails.getStatus().toUpperCase();
		candidatesDetails.setStatus(upperCase);
		CandidatesDetails save = rmsDao.save(candidatesDetails);
		try {
			FinalResponse finalResponse = new FinalResponse();
			if(save!=null) {
				finalResponse.setStatus(true);
				finalResponse.setMessage("Successfully");
				finalResponse.setData(save);
			}else {
				finalResponse.setStatus(false);
				finalResponse.setMessage("Data not found");
				finalResponse.setData(null);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "Data Successfully inserted";
	}
	
	public List<CandidatesDetails> getAllCandidate() {
		List<CandidatesDetails> findAll = rmsDao.findAll();
		try {
			FinalResponse finalResponse = new FinalResponse();
			if(findAll!=null) {
				finalResponse.setStatus(true);
				finalResponse.setMessage("Successfully");
				finalResponse.setData(findAll);
			}else {
				finalResponse.setStatus(false);
				finalResponse.setMessage("Data not found");
				finalResponse.setData(null);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return findAll;
	}
	
	
	public FinalResponse countCandidate() {
		Collection<CandidatesDetails> findAllActiveUsers = rmsDao.findAll();
		FinalResponse finalResponse = new FinalResponse();
		try {
			
			if(findAllActiveUsers!=null) {
				finalResponse.setStatus(true);
				finalResponse.setMessage(String.valueOf(findAllActiveUsers.size()));
			}else {
				finalResponse.setStatus(false);
				finalResponse.setMessage("0");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return finalResponse;
	}
	
	public FinalResponse countCandidateUpdatedInOneWeek() {
		Collection<CandidatesDetails> findAllActiveUsers = rmsDao.countCandidateUpdatedInOneWeek();
		FinalResponse finalResponse = new FinalResponse();
		try {
			
			if(findAllActiveUsers!=null) {
				finalResponse.setStatus(true);
				finalResponse.setData(String.valueOf(findAllActiveUsers.size()));
			}else {
				finalResponse.setStatus(false);
				finalResponse.setMessage("0");
				finalResponse.setData(null);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return finalResponse;
	}
	
	public FinalResponse getTotalres() {
		Collection<CandidatesDetails> findAllActiveUsers = rmsDao.getTotalres();
		FinalResponse finalResponse = new FinalResponse();
		try {
			
			if(findAllActiveUsers!=null) {
				finalResponse.setStatus(true);
				finalResponse.setData(String.valueOf(findAllActiveUsers.size()));
			}else {
				finalResponse.setStatus(false);
				finalResponse.setMessage("0");
				finalResponse.setData(null);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return finalResponse;
	}
	
	public FinalResponse countCandidateUpdatedInOneMonth() {
		Collection<CandidatesDetails> findAllActiveUsers = rmsDao.countCandidateUpdatedInOneMonth();
		FinalResponse finalResponse = new FinalResponse();
		try {
			
			if(findAllActiveUsers!=null) {
				finalResponse.setStatus(true);
				finalResponse.setData(String.valueOf(findAllActiveUsers.size()));
			}else {
				finalResponse.setStatus(false);
				finalResponse.setMessage("0");
				finalResponse.setData(null);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return finalResponse;
	}
	
	public FinalResponse countCandidateUpdatedInOneYear() {
		Collection<CandidatesDetails> findAllActiveUsers = rmsDao.countCandidateUpdatedInOneYear();
		FinalResponse finalResponse = new FinalResponse();
		try {
			
			if(findAllActiveUsers!=null) {
				finalResponse.setStatus(true);
				finalResponse.setData(String.valueOf(findAllActiveUsers.size()));
			}else {
				finalResponse.setStatus(false);
				finalResponse.setMessage("0");
				finalResponse.setData(null);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return finalResponse;
	}
	
	public FinalResponse resumeUpdated() {
		Collection<CandidatesDetails> newUploadsByRecuiter = rmsDao.countCandidateUpdatedInOneMonth();
		Collection<CandidatesDetails> newUploadsByCandidate = rmsDao.countCandidateUpdatedInOneWeek();
		Collection<CandidatesDetails> resumeDeactivated = rmsDao.countCandidateUpdatedInOneYear();
//		Collection<CandidatesDetails> totalres = rmsDao.getTotalres();
		FinalResponse finalResponse = new FinalResponse();
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		try {
			
			if(newUploadsByRecuiter!=null) {
				map.put("Resumes Updated in the Last 30 days", newUploadsByCandidate.size());
				
			}else {
				map.put("Resumes Updated in the Last 30 days", 0);
			}
			
			if(newUploadsByCandidate!=null) {
				map.put("Resumes Not Updated for > 30 days to 1 Year", newUploadsByRecuiter.size()-1);
				
			}else {
				map.put("Resumes Not Updated for > 30 days to 1 Year", 0);
			}
			
			if(resumeDeactivated!=null) {
				map.put("Not Updated last>1 Year", resumeDeactivated.size());
				
			}else {
				map.put("Not Updated last>1 Year", 0);
			}
//			if(totalres!=null) {
//				map.put("Total Resume", totalres.size());
//				
//			}else {
//				map.put("Total Resume", 0);
//			}
			finalResponse.setMessage(String.valueOf(newUploadsByRecuiter.size()+newUploadsByCandidate.size()+resumeDeactivated.size()-1));
			finalResponse.setData(map);
			finalResponse.setStatus(true);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return finalResponse;
	}
	
	/*
	 * Author Akash kumar
	 * Resume Upload Summary
	 * return FinalResponse
	 * 
	 */
	public FinalResponse resumeUploadsSummary() {
		Collection<CandidatesDetails> newUploadsByRecuiter = rmsDao.newUploadsByRecuiter();
		Collection<CandidatesDetails> newUploadsByCandidate = rmsDao.newUploadsByCandidate();
		Collection<CandidatesDetails> resumeDeactivated = rmsDao.resumeDeactivated();
		FinalResponse finalResponse = new FinalResponse();
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		try {
			
			if(newUploadsByRecuiter!=null) {
				map.put("Uploaded By Recuiter", newUploadsByRecuiter.size());
				
			}else {
				map.put("Uploaded By Recuiter", 0);
			}
			
			if(newUploadsByCandidate!=null) {
				map.put("Uploaded By Candidate", newUploadsByCandidate.size());
				
			}else {
				map.put("Uploaded By Candidate", 0);
			}
			
			if(resumeDeactivated!=null) {
				map.put("Resume Deactivated", resumeDeactivated.size());
				
			}else {
				map.put("Resume Deactivated", 0);
			}
			finalResponse.setMessage(String.valueOf(newUploadsByRecuiter.size()+newUploadsByCandidate.size()+resumeDeactivated.size()));
			finalResponse.setData(map);
			finalResponse.setStatus(true);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return finalResponse;
	}
}
