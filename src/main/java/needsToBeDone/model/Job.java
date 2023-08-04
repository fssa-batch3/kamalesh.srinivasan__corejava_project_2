package needsToBeDone.model;

public class Job {

	private String title;
	private String location;
	private int price;
	private String summary; 
	private String qualification;
	private String responsibilities;
	private String email;
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Job(String title, String location, int price, String summary,  String qualification, String responsibilities,String email) {
		this.title = title;
		this.location =location;
		this.price = price;
		this.summary = summary;
		this.qualification = qualification;
		this.responsibilities = responsibilities;
		this.email = email;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getResponsibilities() {
		return responsibilities;
	}

	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

}
