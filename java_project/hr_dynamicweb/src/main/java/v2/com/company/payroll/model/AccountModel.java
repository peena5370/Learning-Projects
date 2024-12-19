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
public class AccountModel implements Serializable {
	private static final long serialVersionUID = 1333704727183703636L;
	
	private  int id;
	private String username;
	private String password;
	private String key;
	private String dateCreated;
	private String dateChanged;

	public AccountModel(String username, String password, String key, String dateCreated) {
		this.username = username;
		this.password = password;
		this.key = key;
		this.dateCreated = dateCreated;
	}
}
