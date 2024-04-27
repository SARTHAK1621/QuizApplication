package com.sarthak.QuizService.model;

public class Response {
	
	private Integer id;
	private String response;
	public Response() {
		super();
	}
	public Response(Integer id, String response) {
		super();
		this.id = id;
		this.response = response;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the response
	 */
	public String getResponse() {
		return response;
	}
	/**
	 * @param response the response to set
	 */
	public void setResponse(String response) {
		this.response = response;
	}
	@Override
	public String toString() {
		return "Response [id=" + id + ", response=" + response + ", getId()=" + getId() + ", getResponse()="
				+ getResponse() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	

}
