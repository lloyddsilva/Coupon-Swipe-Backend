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
import couponswipe.data.dao.IUserDAO;
import couponswipe.data.po.UserPO;
import couponswipe.data.util.ConvertUtils;
import couponswipe.dto.UserDTO;

@Path("/user")
public class UserService extends BaseService {
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/get/{email}")
    public UserDTO findUser(@PathParam("email") String userName) {

        UserDTO user = null;
        try {
            UserPO po = loadExistingUser(userName);
            user = ConvertUtils.convert(po);
        } catch (Exception e) {
            handleException(e);
        } finally {
        }

        return user;
    }

    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/delete/{email}")
    public Response deleteUser(@PathParam("email") String userName) {

        try {
            deleteExistingUser(userName);
        } catch (Exception e) {
            handleException(e);
        } finally {
        }

        return ok();
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/signup")
    public Response addUser(UserDTO user) {
        System.out.println(user.getEmail());
        UserDTO resp = new UserDTO();
        try {
            IUserDAO dao = DAOFactory.getInstance().getUserDAO();

            UserPO existingUser = dao.findByEmail(user.getEmail());

            if (existingUser != null) {
                throw new ValidationException("User name already taken");
            }

            UserPO po = ConvertUtils.convert(user);
            System.out.println(po.getEmail());
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
    public Response updateUser(UserDTO user) {
        System.out.println(user.getEmail());
        UserDTO resp = new UserDTO();
        try {
            IUserDAO dao = DAOFactory.getInstance().getUserDAO();

            UserPO existingUser = dao.findByEmail(user.getEmail());

            if (existingUser == null) {
                throw new ValidationException("No user present");
            }

            UserPO po = ConvertUtils.convert(user);
            dao.update(po);
            resp = ConvertUtils.convert(po);
        } catch (Exception e) {
            handleException(e);
        } finally {
        }

        return created(resp);
    }

    @GET
    @Produces(MediaType.TEXT_XML)
    public String sayXMLHello() {
        return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
    }

}
