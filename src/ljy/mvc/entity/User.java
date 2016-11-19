package ljy.mvc.entity;

public class User {
	private Integer id;
	private String username;
	private String passwrod;
	private String email;
	private Adders adders;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswrod() {
		return passwrod;
	}
	public void setPasswrod(String passwrod) {
		this.passwrod = passwrod;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Adders getAdders() {
		return adders;
	}
	public void setAdders(Adders adders) {
		this.adders = adders;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
/*	@Override
	public String toString() {
		return "User [username=" + username + ", passwrod=" + passwrod
				+ ", email=" + email + ", adders=" + adders + "]";
	}*/
	
	
	public User(String username, String passwrod, String email) {
		super();
		this.username = username;
		this.passwrod = passwrod;
		this.email = email;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", passwrod="
				+ passwrod + ", email=" + email + "]";
	}
	public User(Integer id, String username, String passwrod, String email) {
		super();
		this.id = id;
		this.username = username;
		this.passwrod = passwrod;
		this.email = email;
	}
	public User() {
		super();
	}
	
	
}
