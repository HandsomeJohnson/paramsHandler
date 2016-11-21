package com.hexincad.test;

public class HxMsg {
	
	private String cmd;
	private String jobID;
	private ModelParams params;
	private String details;
	private String path;
	
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public String getJobID() {
		return jobID;
	}
	public void setJobID(String jobID) {
		this.jobID = jobID;
	}
	public ModelParams getParams() {
		return params;
	}
	public void setParams(ModelParams params) {
		this.params = params;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
