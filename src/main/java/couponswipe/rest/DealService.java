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
import couponswipe.data.dao.IUserDAO;
import couponswipe.data.po.DealPO;
import couponswipe.data.po.UserPO;
import couponswipe.data.util.ConvertUtils;
import couponswipe.dto.DealDTO;
import couponswipe.dto.UserDTO;

@Path("/deal")
public class DealService  extends BaseService{
    
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/get/{dealid}")
    public DealDTO loadDeal(@PathParam("dealid") String dealId) {

        DealDTO deal = null;
        try {
            DealPO po = loadExistingDeal(dealId);
            deal = ConvertUtils.convert(po);
        } catch (Exception e) {
            handleException(e);
        } finally {
        }

        return deal;
    }
    
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/delete/{dealid}")
    public Response deleteUser(@PathParam("dealid") String dealId) {

        try {
            deleteExistingDeal(dealId);
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
    public Response addUser(DealDTO deal) {
        DealDTO resp = new DealDTO();
        try {
            IDealDAO dao = DAOFactory.getInstance().getDealDAO();

            DealPO existingDeal = dao.findById(deal.getDealUuid());

            if (existingDeal != null) {
                throw new ValidationException("Deal already exists");
            }

            DealPO po = ConvertUtils.convert(deal);
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
    public Response updateUser(DealDTO deal) {
        DealDTO resp = new DealDTO();
        try {
            IDealDAO dao = DAOFactory.getInstance().getDealDAO();

            DealPO existingDeal = dao.findById(deal.getDealUuid());

            if (existingDeal == null) {
                throw new ValidationException("No deal present");
            }

            DealPO po = ConvertUtils.convert(deal);
            dao.update(po);
            resp = ConvertUtils.convert(po);
        } catch (Exception e) {
            handleException(e);
        } finally {
        }

        return created(resp);
    }
}
