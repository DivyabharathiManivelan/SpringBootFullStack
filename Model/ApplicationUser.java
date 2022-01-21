/*
 * package com.example.project.Model;
 * 
 * import lombok.Data;
 * 
 * import java.util.Date;
 * 
 * import javax.persistence.Entity; import javax.persistence.Id;
 * 
 * @Entity public class ApplicationUser {
 * 
 * // public long userId;
 * 
 * @Id public String username; public String user_email; public String password;
 * public String user_mobile; public String location; public String
 * getUsername() { return username; }
 * 
 * public void setUsername(String user_name) { this.username = user_name; }
 * 
 * public String getUser_email() { return user_email; }
 * 
 * public void setUser_email(String user_email) { this.user_email = user_email;
 * }
 * 
 * public String getPassword() { return password; }
 * 
 * public void setPassword(String password) { this.password = password; }
 * 
 * public String getUser_mobile() { return user_mobile; }
 * 
 * public void setUser_mobile(String user_mobile) { this.user_mobile =
 * user_mobile; }
 * 
 * public String getLocation() { return location; }
 * 
 * public void setLocation(String location) { this.location = location; }
 * 
 * public ApplicationUser(String user_name, String user_email, String password,
 * String user_mobile, String location) { super(); this.username = user_name;
 * this.user_email = user_email; this.password = password; this.user_mobile =
 * user_mobile; this.location = location; }
 * 
 * public ApplicationUser() { // super(); }
 * 
 * public ApplicationUser(String user_name, String password) { super();
 * this.username = user_name; this.password = password; }
 * 
 * // public Date user_dob;
 * 
 * }
 */

package com.example.project.Model;

import lombok.Data;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "APPLICATIONUSER")
public class ApplicationUser {
	   @Id
	    @GeneratedValue(generator="system-uuid")
	    @GenericGenerator(name="system-uuid", strategy = "uuid")
	    public String id;
	    public String getUserid(){
	      return id;
	    }
	     public void setUserid(String userid) {
	        this.id = userid;
	    }
    public String user_name;
    public String user_email;
    public String password;
    public String user_mobile;
    public String location;

 public String getUsername() {
		return user_name;
	}

	public void setUsername(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_mobile() {
		return user_mobile;
	}

	public void setUser_mobile(String user_mobile) {
		this.user_mobile = user_mobile;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

      public ApplicationUser(String user_name, String user_email, String password, String user_mobile, String location) {
        super();
        this.user_name = user_name;
        this.user_email = user_email;
        this.password = password;
        this.user_mobile = user_mobile;
        this.location = location;
    }

    public ApplicationUser() {
        super();
    }

    public ApplicationUser(String user_name, String password) {
        super();
        this.user_name = user_name;
        this.password = password;
    }

    //    public Date user_dob;

}
