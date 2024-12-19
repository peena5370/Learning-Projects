package v2.com.company.payroll.model;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayRollModel implements Serializable {
	private static final long serialVersionUID = -7962351050743547422L;
	
	private int id;
	private Double overtimepay;
	private Double deduction;
	private Double total;
	private LocalDate issueDate;
	private Double baseSalary;
	private String employeeName;
	private String approver;

	public PayRollModel(Double overtimepay, Double deduction, Double total, Double baseSalary, LocalDate issueDate, String employeeName, String approver) {
		this.overtimepay = overtimepay;
		this.deduction = deduction;
		this.total = total;
		this.baseSalary = baseSalary;
		this.issueDate = issueDate;
		this.employeeName = employeeName;
		this.approver = approver;
	}
}
