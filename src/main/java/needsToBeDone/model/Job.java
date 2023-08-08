package needsToBeDone.model;

public class Job {

	private String title;
	private int price;
	private String email;
	private String jobid;

	

	public Job(String title, int price, String email) {
		this.title = title;
		this.price = price;
		this.email = email;
	}
	
	
	public void UpdateJob(String title, int price, String jobid) {
		this.title = title;
		this.price = price;
		this.jobid = jobid;
	}
	
	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
