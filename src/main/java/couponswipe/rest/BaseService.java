package couponswipe.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import couponswipe.common.exceptions.CheckedException;
import couponswipe.common.exceptions.ServiceException;
import couponswipe.data.dao.DAOFactory;
import couponswipe.data.po.DealHistoryPO;
import couponswipe.data.po.DealPO;
import couponswipe.data.po.UserPO;


public class BaseService {
	
	protected void handleException(Exception e) {
		
		if (e instanceof CheckedException) {
			throw (CheckedException) e;
		} else {
			throw new ServiceException(e);
		}
	}
	
	protected Response ok() {
		return Response.status(Status.OK).build();
	}

	protected Response ok(Object obj) {
		return Response.status(Status.OK).entity(obj).build();
	}

	protected Response created(Object obj) {
		return Response.status(Status.CREATED).entity(obj).build();
	}
	
	protected UserPO loadExistingUser(String email) {
	    
		UserPO po = DAOFactory.getInstance().getUserDAO().findByEmail(email);

		return po;
	}
	
	protected void deleteExistingUser(String email){
	    DAOFactory.getInstance().getUserDAO().deleteByEmail(email);
	    
	}
	
	protected DealPO loadExistingDeal(String dealId){
	    DealPO po = DAOFactory.getInstance().getDealDAO().findById(dealId);
	    return po;
	}
	
	protected void deleteExistingDeal(String email){
        DAOFactory.getInstance().getDealDAO().deleteById(email);
        
    }
	
	protected DealHistoryPO loadExistingDealHistory(String dealId, String email){
	    DealHistoryPO po = DAOFactory.getInstance().getDealHistoryDAO().findById(dealId, email);
        return po;
	}
	
	protected void deleteExistingDealHistory(String dealId, String email){
        DAOFactory.getInstance().getDealHistoryDAO().deleteById(dealId, email);
        
    }
	
}
