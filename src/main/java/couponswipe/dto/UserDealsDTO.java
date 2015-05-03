package couponswipe.dto;

public class UserDealsDTO {
    private String dealTitle;
    private String dealId;
    private String dealAmount;
    private String dealBuyUrl;
    private String dealMediumUrl;
    private String dealLargeUrl;
    
    
    public String getDealMediumUrl() {
        return dealMediumUrl;
    }
    public void setDealMediumUrl(String dealMediumUrl) {
        this.dealMediumUrl = dealMediumUrl;
    }
    public String getDealLargeUrl() {
        return dealLargeUrl;
    }
    public void setDealLargeUrl(String dealLargeUrl) {
        this.dealLargeUrl = dealLargeUrl;
    }
    public String getDealAmount() {
        return dealAmount;
    }
    public void setDealAmount(String dealAmount) {
        this.dealAmount = dealAmount;
    }
    public String getDealBuyUrl() {
        return dealBuyUrl;
    }
    public void setDealBuyUrl(String dealBuyUrl) {
        this.dealBuyUrl = dealBuyUrl;
    }
    public String getDealTitle() {
        return dealTitle;
    }
    public void setDealTitle(String dealTitle) {
        this.dealTitle = dealTitle;
    }
    public String getDealId() {
        return dealId;
    }
    public void setDealId(String dealId) {
        this.dealId = dealId;
    }
}
