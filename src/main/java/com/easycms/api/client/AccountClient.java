package com.easycms.api.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.moxy.json.MoxyJsonFeature;

import com.easycms.api.MyApplication;
import com.easycms.model.Account;


/**
 * 用户客户端，用来测试资源
 */
public class AccountClient {

	private static String serverUri = "http://localhost:8080/api";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CreateUser();
		System.out.println("----------------------------------========== /CreateUser() ==========---------------------------------");
		
		deleteUser();
		System.out.println("----------------------------------=========== / deleteUser() =========---------------------------------");
		
		updateUser();
		System.out.println("----------------------------------=========== /updateUser() =========---------------------------------");
		
		getUserById();
		System.out.println("----------------------------------========== /getUserById() ==========---------------------------------");
		
		getUserByIdInfo();
		System.out.println("----------------------------------========== /getUserByIdInfo() ==========---------------------------------");
		
		getUserByIdInJson();
		System.out.println("----------------------------------========== /getUserByIdInJson() ==========---------------------------------");
		
		getUserByIdInJsonp();
		System.out.println("----------------------------------========== /getUserByIdInJsonp() ==========---------------------------------");
		
		getUserByIdInXml();
		System.out.println("----------------------------------========== /getUserByIdInXml() ==========---------------------------------");
		
		findByPage();
		System.out.println("----------------------------------========== /findByPage() ==========---------------------------------");
		
		findByPageJsonp();
		System.out.println("----------------------------------========== /findByPageJsonp() ==========---------------------------------");
	}
	
	/**
	 * 添加用户
	 */

    private static void CreateUser(){
		Client client = ClientBuilder.newBuilder().register(MoxyJsonFeature.class).register(MyApplication.createMoxyJsonResolver()).build();
		Account account = new Account();
		account.setId(44);
		account.setUsername("SCOTT");
		account.setPassword("123456");
		
		Response response = client.target(serverUri+"/users").request(MediaType.APPLICATION_JSON).post(Entity.entity(account, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		response.close();
    }

    /**
     * 删除用户
     */
    private static void deleteUser(){
		Client client = ClientBuilder.newBuilder().register(MoxyJsonFeature.class).register(MyApplication.createMoxyJsonResolver()).build();
		Response response = client.target(serverUri+"/users").path("1").request(MediaType.APPLICATION_JSON).delete();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		response.close();
    }
    
    /**
     * 更新用户
     */
    private static void updateUser(){
    	Client client = ClientBuilder.newBuilder().register(MoxyJsonFeature.class).register(MyApplication.createMoxyJsonResolver()).build();
		
    	Account account = new Account();
    	account.setId(1);
    	account.setUsername("SCOTT");
		
		Response response = client.target(serverUri+"/users").request(MediaType.APPLICATION_JSON).put(Entity.entity(account, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		response.close();
    }
    
    /**
     * 查询某一个用户
     */
    private static void getUserById(){
		Client client = ClientBuilder.newBuilder().register(MoxyJsonFeature.class).register(MyApplication.createMoxyJsonResolver()).build();
		Response response = client.target(serverUri+"/users").path("3").request(MediaType.APPLICATION_JSON).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		
		System.out.println("---------------------------------------------------");
		
		response = client.target(serverUri+"/users").path("3").request(MediaType.APPLICATION_XML).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		response.close();
    }
    /**
     * 查询某一个用户
     */
	private static void getUserByIdInfo() {
		Client client = ClientBuilder.newBuilder().register(MoxyJsonFeature.class).register(MyApplication.createMoxyJsonResolver()).build();
		Response response = client.target(serverUri + "/users/accept").path("3").request(MediaType.APPLICATION_JSON).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));

		System.out.println("---------------------------------------------------");

		response = client.target(serverUri + "/users").path("3").request(MediaType.APPLICATION_XML).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		response.close();
	}
	
	private static void getUserByIdInJson(){
		Client client = ClientBuilder.newBuilder().register(MoxyJsonFeature.class).register(MyApplication.createMoxyJsonResolver()).build();
		Response response = client.target(serverUri+"/users/json").path("3").request().get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		response.close();
	}
	
	private static void getUserByIdInJsonp(){
		Client client = ClientBuilder.newBuilder().register(MoxyJsonFeature.class).register(MyApplication.createMoxyJsonResolver()).build();
		Response response = client.target(serverUri+"/users/jsonp").path("3").queryParam("callback", "jsonpCallback").request().accept("application/javascript").get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		response.close();
	}
	
	private static void getUserByIdInXml(){
		Client client = ClientBuilder.newBuilder().register(MoxyJsonFeature.class).register(MyApplication.createMoxyJsonResolver()).build();
		Response response = client.target(serverUri+"/users/xml").path("3").request().get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		response.close();
	}
	
	public static void getAllUsers(){
		Client client = ClientBuilder.newBuilder().register(MoxyJsonFeature.class).register(MyApplication.createMoxyJsonResolver()).build();
		Response response = client.target(serverUri).path("users").request(MediaType.APPLICATION_JSON).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		System.out.println("---------------------------------");
		response = client.target(serverUri).path("/users").request(MediaType.APPLICATION_XML).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	
	/**
	 * 分页
	 */
	private static void findByPage(){
		Client client = ClientBuilder.newBuilder().register(MoxyJsonFeature.class).register(MyApplication.createMoxyJsonResolver()).build();
		Response response = client.target(serverUri+"/users").path("page").queryParam("pageNumber", "1").request(MediaType.APPLICATION_JSON).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		System.out.println("---------------------------------");
		response = client.target(serverUri+"/users").path("page").queryParam("pageNumber", "1").request(MediaType.APPLICATION_XML).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	/**
	 * 分页
	 */
	private static void findByPageJsonp(){
		Client client = ClientBuilder.newBuilder().register(MoxyJsonFeature.class).register(MyApplication.createMoxyJsonResolver()).build();
		Response response = client.target(serverUri+"/users/page").path("jsonp").queryParam("pageNumber", "1").request(MediaType.APPLICATION_JSON).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		System.out.println("---------------------------------");
		response = client.target(serverUri+"/users/page").path("jsonp").queryParam("pageNumber", "1").request(MediaType.APPLICATION_XML).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		System.out.println("---------------------------------");
		response = client.target(serverUri+"/users/page").path("jsonp").queryParam("pageNumber", "1").queryParam("callback", "jsonpCallback").request().accept("application/javascript").get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}	 
}
