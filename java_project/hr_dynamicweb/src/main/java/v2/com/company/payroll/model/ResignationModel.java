package v2.com.company.payroll.model;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResignationModel implements Serializable {
	private static final long serialVersionUID = 922137899058639561L;
	
	private int id;
	private String reasons;
	private LocalDate date;
	private String employeeName;
	private String approver;
	
	public ResignationModel(String reasons, LocalDate date, String employeeName, String approver) {
		this.reasons = reasons;
		this.date = date;
		this.employeeName = employeeName;
		this.approver = approver;
	}
}