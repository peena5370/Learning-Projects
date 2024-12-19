package v2.com.company.payroll.model;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class EmployeePromotionModel implements Serializable {
	private static final long serialVersionUID = -4120027958579435207L;
	
	private int id;
	private Double previousSalary;
	private Double promoteSalary;
	private LocalDate promoteDate;
	private String promoteTitle;
	private String employeeName;
	private String approver;
	
	public EmployeePromotionModel(Double previousSalary, Double promoteSalary, LocalDate promoteDate, String promoteTitle, String employeeName, String approver) {
		this.previousSalary = previousSalary;
		this.promoteSalary = promoteSalary;
		this.promoteDate = promoteDate;
		this.promoteTitle = promoteTitle;
		this.employeeName = employeeName;
		this.approver = approver;
	}
}
