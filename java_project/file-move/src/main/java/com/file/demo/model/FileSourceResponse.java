package com.file.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FileSourceResponse {
	private String sourceDir;
	private String destDir;
}
