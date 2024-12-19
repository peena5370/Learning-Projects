package v2.com.company.payroll.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class TitleModel implements Serializable {
	private static final long serialVersionUID = 8728662019365793033L;
	
	private int id;
	private String titleName;
}
