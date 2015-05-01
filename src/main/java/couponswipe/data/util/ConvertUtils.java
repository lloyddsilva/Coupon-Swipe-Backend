package couponswipe.data.util;

import couponswipe.data.po.DealHistoryPO;
import couponswipe.data.po.DealPO;
import couponswipe.data.po.UserPO;
import couponswipe.dto.DealDTO;
import couponswipe.dto.DealHistoryDTO;
import couponswipe.dto.UserDTO;

public class ConvertUtils {
    public static final UserDTO convert(UserPO po) {
        if (po == null) {
            UserDTO dto = new UserDTO();
           dto.setExists(false);
            return dto;
        }

        UserDTO dto = new UserDTO();
        dto.setEmail(po.getEmail());
        dto.setFirstName(po.getFirstName());
        dto.setLastName(po.getLastName());
        dto.setPhoneNumber(po.getPhoneNumber());
        
        dto.setPassword(po.getPassword());
        dto.setPrefDistance(po.getPrefDistance());
        dto.setPrefCategories(po.getPrefCategories());
        dto.setExists(true);

        return dto;
    }

    public static final UserPO convert(UserDTO dto) {
        if (dto == null) {
            return null;
        }

        UserPO po = new UserPO();
        po.setEmail(dto.getEmail());
        po.setFirstName(dto.getFirstName());
        po.setLastName(dto.getLastName());
        po.setPhoneNumber(dto.getPhoneNumber());
        po.setPassword(dto.getPassword());
        po.setPrefDistance(dto.getPrefDistance());
        po.setPrefCategories(dto.getPrefCategories());
        return po;
    }

    public static DealDTO convert(DealPO po) {
        if(po == null){
            return null;
        }
        DealDTO dto = new DealDTO();
        dto.setDealAmount(po.getDealAmount());
        dto.setDealBuyUrl(po.getDealBuyUrl());
        dto.setDealCategory(po.getDealCategory());
        dto.setDealCurrency(po.getDealCurrency());
        dto.setDealDescription(po.getDealDescription());
        dto.setDealExpiryDate(po.getDealExpiryDate());
        dto.setDealLatitude(po.getDealLatitude());
        dto.setDealLocation(po.getDealLocation());
        dto.setDealLongitude(po.getDealLongitude());
        dto.setDealStartDate(po.getDealStartDate());
        dto.setDealTitle(po.getDealTitle());
        dto.setDealUuid(po.getDealUuid());
        dto.setLargeImageUrl(po.getLargeImageUrl());
        dto.setMediumImageUrl(po.getMediumImageUrl());
        dto.setMerchantName(po.getMerchantName());
        dto.setMerchantUrl(po.getMerchantUrl());
        dto.setMerchantUuid(po.getMerchantUuid());
        dto.setSmallImageUrl(po.getSmallImageUrl());
        
        return dto;
    }

    public static DealPO convert(DealDTO dto) {
        if(dto == null){
            return null;
        }
        DealPO po= new DealPO();
        po.setDealAmount(dto.getDealAmount());
        po.setDealBuyUrl(dto.getDealBuyUrl());
        po.setDealCategory(dto.getDealCategory());
        po.setDealCurrency(dto.getDealCurrency());
        po.setDealDescription(dto.getDealDescription());
        po.setDealExpiryDate(dto.getDealExpiryDate());
        po.setDealLatitude(dto.getDealLatitude());
        po.setDealLocation(dto.getDealLocation());
        po.setDealLongitude(dto.getDealLongitude());
        po.setDealStartDate(dto.getDealStartDate());
        po.setDealTitle(dto.getDealTitle());
        po.setDealUuid(dto.getDealUuid());
        po.setLargeImageUrl(dto.getLargeImageUrl());
        po.setMediumImageUrl(dto.getMediumImageUrl());
        po.setMerchantName(dto.getMerchantName());
        po.setMerchantUrl(dto.getMerchantUrl());
        po.setMerchantUuid(dto.getMerchantUuid());
        po.setSmallImageUrl(dto.getSmallImageUrl());
        
        return po;
    }

    public static DealHistoryDTO convert(DealHistoryPO po) {
        // TODO Auto-generated method stub
        if (po == null) {
            return null;
        }
        DealHistoryDTO dto = new DealHistoryDTO();
        dto.setAction(po.getAction());
        dto.setCreatedAt(po.getCreatedAt());
        dto.setDealUuid(po.getDealUuid());
        dto.setUpdatedAt(po.getUpdatedAt());
        dto.setEmail(po.getEmail());
        return dto;
    }

    public static DealHistoryPO convert(DealHistoryDTO dto) {
        if (dto == null) {
            return null;
        }
        DealHistoryPO po = new DealHistoryPO();
        po.setAction(dto.getAction());
        po.setCreatedAt(dto.getCreatedAt());
        po.setDealUuid(dto.getDealUuid());
        po.setUpdatedAt(dto.getUpdatedAt());
        po.setEmail(dto.getEmail());
        return po;
    }

    
}
