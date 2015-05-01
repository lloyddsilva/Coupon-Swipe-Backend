package couponswipe.dto;

import com.google.gson.Gson;

public class UserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private int prefDistance;
    private String prefCategories;
    private boolean exists;
    

   

    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPrefDistance() {
        return prefDistance;
    }

    public void setPrefDistance(int prefDistance) {
        this.prefDistance = prefDistance;
    }

    public String getPrefCategories() {
        return prefCategories;
    }

    public void setPrefCategories(String prefCategories) {
        this.prefCategories = prefCategories;
    }
    
    @Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
