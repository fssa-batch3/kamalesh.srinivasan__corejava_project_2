package needsToBeDone.model;

public class Job {

	private String title;
	private int price;
	private String email;

	public Job(String title, int price, String email) {
		this.title = title;
		this.price = price;
		this.email = email;
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
