package v2.com.company.payroll.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventModel implements Serializable {
	private static final long serialVersionUID = -1100212524625744916L;
	
	private int id;
	private String title;
	private String description;
	private String start;
	private String end;
	private String color;
	
	public EventModel(int id, String title, String description, String start, String end) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.start = start;
		this.end = end;
	}
}
