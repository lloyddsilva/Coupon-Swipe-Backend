package couponswipe.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import couponswipe.common.exceptions.ValidationException;
import couponswipe.data.dao.DAOFactory;
import couponswipe.data.dao.IDealDAO;
import couponswipe.data.dao.IDealHistoryDAO;
import couponswipe.data.po.DealHistoryPO;
import couponswipe.data.po.DealPO;
import couponswipe.data.po.UserPO;
import couponswipe.data.util.ConvertUtils;
import couponswipe.dto.DealDTO;
import couponswipe.dto.DealHistoryDTO;
import couponswipe.dto.UserDTO;

@Path("/history")
public class DealHistoryService extends BaseService {
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/get/{dealId}/{email}")
    public DealHistoryDTO findUser(@PathParam("dealId") String dealId, @PathParam("email") String email) {
        
        DealHistoryDTO dealHistoryDTO = null;
        try {
           DealHistoryPO po = loadExistingDealHistory(dealId, email);
           dealHistoryDTO = ConvertUtils.convert(po);
        } catch (Exception e) {
            handleException(e);
        } finally {
        }

        return dealHistoryDTO;
    }
    
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/delete/{dealid}/{email}")
    public Response deleteUser(@PathParam("dealid") String dealId, @PathParam("email") String email) {

        try {
            deleteExistingDealHistory(dealId, email);
        } catch (Exception e) {
            handleException(e);
        } finally {
        }

        return ok();
    }
    
    @POST
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/add")
    public Response addDealHistory(DealHistoryDTO dealHistory) {
        DealHistoryDTO resp = new DealHistoryDTO();
        try {
            IDealHistoryDAO dao = DAOFactory.getInstance().getDealHistoryDAO();

            DealHistoryPO existingHistory = dao.findById(dealHistory.getDealUuid(), dealHistory.getEmail());

            if (existingHistory != null) {
                throw new ValidationException("Deal History already exists");
            }

            DealHistoryPO po = ConvertUtils.convert(dealHistory);
            dao.save(po);
            resp = ConvertUtils.convert(po);
        } catch (Exception e) {
            handleException(e);
        } finally {
        }

        return created(resp);
    }
    
    @POST
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/update")
    public Response updateUser(DealHistoryDTO dealHistory) {
        DealHistoryDTO resp = new DealHistoryDTO();
        try {
            IDealHistoryDAO dao = DAOFactory.getInstance().getDealHistoryDAO();

            DealHistoryPO existingDealHistory = dao.findById(dealHistory.getDealUuid(), dealHistory.getEmail() );

            if (existingDealHistory == null) {
                throw new ValidationException("No deal present");
            }

            DealHistoryPO po = ConvertUtils.convert(dealHistory);
            dao.update(po);
            resp = ConvertUtils.convert(po);
        } catch (Exception e) {
            handleException(e);
        } finally {
        }

        return created(resp);
    }
    
}
