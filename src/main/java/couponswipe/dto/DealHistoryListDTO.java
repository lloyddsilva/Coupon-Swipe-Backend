package couponswipe.dto;

import java.util.ArrayList;
import java.util.List;

public class DealHistoryListDTO {
    public List<UserDealsDTO> getDeals() {
        return deals;
    }
    
    
    
    public void setDeals(List<UserDealsDTO> deals) {
        this.deals = deals;
    }

    List<UserDealsDTO> deals = new ArrayList<UserDealsDTO>();
    
    public void add(UserDealsDTO d){
        deals.add(d);
    }
    
}
