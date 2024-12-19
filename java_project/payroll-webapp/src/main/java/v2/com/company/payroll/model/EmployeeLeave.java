package v2.com.company.payroll.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeLeave implements Serializable {
	private static final long serialVersionUID = 6696520401820242605L;
	
	private int id;
	private String reasons;
	private String dateFrom;
	private String dateTo;
	private String type;
	private String status;
	private String employeeName;
	private String approver;
	
	public EmployeeLeave(String reasons, String dateFrom, String dateTo, String type, String status, String employeeName) {
		this.reasons = reasons;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.type = type;
		this.status = status;
		this.employeeName = employeeName;
	}
	
	public EmployeeLeave(int id, String status, String approver) {
		this.id = id;
		this.status = status;
		this.approver = approver;
	}
}
