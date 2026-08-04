package com.work.controller;

import org.springframework.hateoas.RepresentationModel;

public class ResultResource extends RepresentationModel<ResultResource> {

	private Integer result;

	public ResultResource() {
	}

	public ResultResource(Integer result) {
		this.result = result;
	}

	public Integer getResult() {
		return result;
	}
}
