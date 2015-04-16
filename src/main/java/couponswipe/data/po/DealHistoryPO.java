package couponswipe.data.po;

import com.google.gson.Gson;

public class DealHistoryPO {
	private String email;
	private String dealUuid;
	private String action;
	private String createdAt;
	private String updatedAt;
	


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDealUuid() {
		return dealUuid;
	}

	public void setDealUuid(String dealUuid) {
		this.dealUuid = dealUuid;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
