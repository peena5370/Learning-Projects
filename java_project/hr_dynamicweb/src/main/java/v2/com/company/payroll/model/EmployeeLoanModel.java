package v2.com.company.payroll.model;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeLoanModel implements Serializable {
	private static final long serialVersionUID = -63180241388824173L;
	
	private int id;
	private String reasons;
	private Double amount;
	private LocalDate issueDate;
	private String status;
	private String employeeName;
	private String approver;
	
	public EmployeeLoanModel(String reasons, Double amount, LocalDate issueDate, String status, String employeeName) {
		this.reasons = reasons;
		this.amount = amount;
		this.issueDate = issueDate;
		this.status = status;
		this.employeeName = employeeName;
	}
	
	public EmployeeLoanModel(int id, String status, String approver) {
		this.id = id;
		this.status = status;
		this.approver = approver;
	}
}
