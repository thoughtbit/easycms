package com.easycms.api;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;

import com.easycms.model.Account;

public class AccountRestServiceTest extends JerseyTest {

	@Override
	protected Application configure() {
		enable(TestProperties.LOG_TRAFFIC);
		enable(TestProperties.DUMP_ENTITY);
		return new MyApplication();
	}

	@Override
	protected void configureClient(ClientConfig config) {
		super.configureClient(config);
		config.register(MyApplication.createMoxyJsonResolver());
	}

	@Test
	public void testGetAllUsers() {
		Response response = target("/users").request()
				.accept(MediaType.APPLICATION_XML).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));

		System.out
				.println("-----------------------------------------------------");

		response = target("/users").request()
				.accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));

	}

	@Test
	public void testFindByPage() {
		Response response = target("/users").path("page")
				.queryParam("pageNumber", "1").request()
				.accept(MediaType.APPLICATION_XML).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));

		System.out
				.println("-----------------------------------------------------");

		response = target("/users").path("page").queryParam("pageNumber", "1")
				.request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));

	}

	@Test
	public void testFindByPageJsonp() {
		Response response = target("/users/page").path("jsonp")
				.queryParam("pageNumber", "1")
				.queryParam("callback", "jsonpCallback").request()
				.accept(MediaType.APPLICATION_XML).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));

		System.out
				.println("-----------------------------------------------------");

		response = target("/users/page").path("jsonp")
				.queryParam("pageNumber", "1")
				.queryParam("callback", "jsonpCallback").request()
				.accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));

		System.out
				.println("-----------------------------------------------------");

		response = target("/users/page").path("jsonp")
				.queryParam("pageNumber", "1")
				.queryParam("callback", "jsonpCallback").request()
				.accept("application/javascript").get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));

	}

	@Test
	public void testGetUserByIdInJson() {
		Response response = target("/users").path("json").path("1").request()
				.accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}

	@Test
	public void testGetUserByIdInJsonp() {
		Response response = target("/users").path("jsonp").path("1")
				.queryParam("callback", "jsonpCallback").request()
				.accept("application/javascript").get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}

	@Test
	public void testGetUserByIdInXml() {
		Response response = target("/users").path("xml").path("1").request()
				.accept(MediaType.APPLICATION_XML).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}

	@Test
	public void testGetUserByIdInfo() {
		Response response = target("/users").path("1").request()
				.accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));

		System.out
				.println("-----------------------------------------------------");

		response = target("/users").path("1").request()
				.accept(MediaType.APPLICATION_XML).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}

	/**
	 * @DELETE
	 */
	@Test
	public void testDeleteUser() {
		Response response = target("/users").path("1").request()
				.accept(MediaType.APPLICATION_JSON).delete();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}

	/**
	 * @POST
	 */
	@Test
	public void testCreateUser() {
		Account account = new Account();
		account.setId(44);
		account.setUsername("SCOTT");
		account.setPassword("123456");
		Response response = target("/users").request()
				.accept(MediaType.APPLICATION_JSON)
				.post(Entity.entity(account, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}

	/**
	 * @PUT
	 */
	@Test
	public void testUpdateUser() {
		Account account = new Account();
		account.setId(1);
		account.setUsername("SCOTT");
		Response response = target("/users").request()
				.accept(MediaType.APPLICATION_JSON)
				.put(Entity.entity(account, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}

}
