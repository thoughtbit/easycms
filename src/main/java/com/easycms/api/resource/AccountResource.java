package com.easycms.api.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.JSONP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.easycms.model.Account;
import com.easycms.service.AccountService;

@Path("/users")
@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})//Accept 接受值类型
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})//ContentType 返回值类型
public class AccountResource {
	private static Logger logger = LoggerFactory.getLogger(AccountService.class);
	
	@Autowired
	private AccountService accountService;
    
    public AccountResource() {
    	logger.debug("UserResource()");
    }

    
	/**
	 * 增加
	 * @param account
	 */
	@POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void createUser(Account account){
		accountService.createAccount(account);
    }
	
	/**
	 * http://localhost:8080/api/users
	 * @POST POST操作
	 * @return
	 */
	/*@POST
	public Response createUser(Account account) {
		return Response.ok(account).build();
	}*/
	
	
	/**
	 * 删除用户
	 * @param id
	 */
    @DELETE
    @Path("{id}")
    public void deleteUser(@PathParam("id")int id){
    	accountService.deleteAccount(id);
    }
    
	/**
	 * http://localhost:8080/api/users/1
	 * @DELETE DELETE操作
	 * @param id
	 * @return
	 */
/*	@DELETE
	@Path("/{id}")
	public Response deleteUser(@PathParam("id") int id) {
		accountService.deleteAccount(id);
		return Response.ok(id).build();
	}*/
    
    
    /**
     * 修改用户
     * @param account
     */
    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updateUser(Account account){
    	accountService.updateAccount(account);
    }
    
	/**
	 * http://localhost:8080/api/users
	 * @PUT PUT操作
	 * @return
	 */
	/*@PUT
	public Response updateUser(Account account) {
		accountService.updateAccount(account);
		return Response.ok(account).build();
	}*/
    
 
    /**
     * 根据id查询
     * GET方式返回xml和json格式数据,通过请求头Accept来判断Accept:application/xml或Accept:application/json
     * @param id
     * @return
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Account getUserById(@PathParam("id") int id){
    	Account account = accountService.findAccountById(id);
    	return account;
    }
   
	
	/**
	 * GET方式返回xml和json格式数据,通过请求头Accept来判断Accept:application/xml或Accept:application/json
	 * http://localhost:8080/api/users/accept/1
	 * @param id
	 * @return
	 */
	@GET
	@Path("/accept/{id}")
	public Response  getUserByIdInfo(@PathParam("id") int id) {
		Account account = accountService.findAccountById(id);
		return Response.ok(account).build();
	}
    
	/**
	 * GET方式返回json格式数据
	 * http://localhost:8080/api/users/json/1
	 * @param id
	 * @return
	 */
	@GET
	@Path("/json/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserByIdInJson(@PathParam("id") int id) {
		Account account = accountService.findAccountById(id);
		return Response.ok(account, MediaType.APPLICATION_JSON).build();
	}
	
	
	/**
	 * GET方式返回jsonp格式数据
	 * http://localhost:8080/api/users/jsonp/1
	 * @param id
	 * @return
	 */
	@GET
	@Path("/jsonp/{id}")
	@JSONP(callback="jsonp",queryParam="callback")
	@Produces("application/javascript")
	public Response getUserByIdInJsonp(@PathParam("id") int id) {
		Account account = accountService.findAccountById(id);
		return Response.ok(account, "application/javascript").build();
	}
	
	
	/**
	 * GET方式返回xml格式数据
	 * http://localhost:8080/api/users/xml/1
	 * @param id
	 * @return
	 */
	@GET
	@Path("/xml/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getUserByIdInXml(@PathParam("id") int id) {
		Account account = accountService.findAccountById(id);
		return Response.ok(account, MediaType.APPLICATION_XML).build();
 
	}
	

	/**
	 * 查询所有, GET方式返回json 或者 xml 数据格式
	 * 使用List<Account>返回xml或json格式的数据 注意方法声明返回值为List<Account>而不再是Response
	 * @return
	 */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Account> getAllUsers(){     
    	List<Account> accounts = new ArrayList<Account>();   
    	accounts = accountService.findAccountAll();
        return accounts;
    }
    
    /**
	 * 使用GenericEntity类型返回xml或json格式的数据。注意方法声明为Response
	 * @return
	 */
	/*@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response getAllUsers(){     
    	List<Account> accounts = new ArrayList<Account>();   
    	accounts = accountService.findAccountAll();
		GenericEntity<List<Account>> entity = new GenericEntity<List<Account>>(accounts){};
		return Response.ok(entity).build();
    }*/
    
    
	/**
	 * 分页, GET方式返回json 或者 xml 数据格式
	 * 使用List<Account>返回xml或json格式的数据 注意方法声明返回值为List<Account>而不再是Response
	 * @return
	 */
    @Path("/page")
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Account> findByPage(@QueryParam("pageNumber")int pageNumber,@DefaultValue("20")@QueryParam("pageSize")int pageSize){     
    	List<Account> accounts = new ArrayList<Account>();   
    	accounts = accountService.findAccountAll();
		//计算总页数
		int totalPages = accounts.size() % pageSize==0 ? accounts.size() / pageSize :accounts.size() / pageSize +1 ;
		
		if(pageNumber <= 0 ){
			pageNumber = 1;
		}else if(pageNumber >= totalPages){
			pageNumber = totalPages;
		}
		
		int start = (pageNumber-1)*pageSize;//起始位置
		int end = start + pageSize; //结束位置
		
	    for (int i = start; i < end; i++) {
	    	System.out.print("分页："+accounts.get(i));
		}
    	
        return accounts;
    }
    
	/**
	 * 使用Account返回xml或jsonp格式的数据 注意方法声明返回值为Account而不再是Response
	 * @return
	 */
    @Path("/page/jsonp")
	@JSONP(callback="jsonp",queryParam="callback")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,"application/javascript"})
	@GET
    public List<Account> findByPageJsonp(@QueryParam("pageNumber")int pageNumber,@DefaultValue("20")@QueryParam("pageSize")int pageSize){     
    	List<Account> accounts = new ArrayList<Account>();   
    	accounts = accountService.findAccountAll();
		//计算总页数
		int totalPages = accounts.size() % pageSize==0 ? accounts.size() / pageSize :accounts.size() / pageSize +1 ;
		
		if(pageNumber <= 0 ){
			pageNumber = 1;
		}else if(pageNumber >= totalPages){
			pageNumber = totalPages;
		}
		
		int start = (pageNumber-1)*pageSize;//起始位置
		int end = start + pageSize; //结束位置
		
	    for (int i = start; i < end; i++) {
	    	System.out.print("分页："+accounts.get(i));
		}
    	
        return accounts;
    }
    
    
}
