package com.ben.springdata_h2_poc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ben.springdata_h2_poc.models.Customer;
import com.ben.springdata_h2_poc.repository.CustomerRepository;
/**
 * 
 Example for register POST request:
 curl -X POST \
  http://localhost:8070/register \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 65df3dfa-5bea-7afc-d22b-2c50c6bceb87' \
  -d '{
	"id" : 123,
	"firstName" : "ben",
	"lastName" : "el"
}'
 * @author belnekave
 *
 */
@RestController
public class RegistrationController {

	@Autowired
	private CustomerRepository custoRepo;

	@RequestMapping(method = RequestMethod.POST, value = "/register", produces = MediaType.APPLICATION_JSON)
	public Response insertCustomer(@RequestBody Customer user) {
		custoRepo.save(user);
		try {
			return Response.status(200).entity(user.toString()).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Server error").build();

		}
	}

	@ExceptionHandler
	void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {

		response.sendError(HttpStatus.BAD_REQUEST.value());

	}

}
