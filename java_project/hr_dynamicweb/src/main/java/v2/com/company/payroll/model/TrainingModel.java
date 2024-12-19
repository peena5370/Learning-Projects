package v2.com.company.payroll.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrainingModel implements Serializable {
	private static final long serialVersionUID = -1084775244160331564L;
	
	private int id;
	private String info;
	private String startDate;
	private String endDate;
	private String status;
	private String employeeName;
	private String issuer;
	
	public TrainingModel(String info, String startDate, String endDate, String status, String employeeName, String issuer) {
		this.info = info;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.employeeName = employeeName;
		this.issuer = issuer;
	}
	
	public TrainingModel(int id, String status, String employeeName) {
		this.id = id;
		this.status = status;
		this.employeeName = employeeName;
	}
}
