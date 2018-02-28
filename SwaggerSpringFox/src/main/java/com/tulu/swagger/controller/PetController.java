package com.tulu.swagger.controller;

import com.tulu.swagger.controller.Response.PetResponse;
import io.prometheus.client.Counter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1.0")
public class PetController {
    private static Counter numberOfGetRequests = Counter.build("total_pet_info_request", "Total number of pet info request").register();

    @RequestMapping(value = "/pet/{petID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PetResponse> getPetInfo(@PathVariable(name = "petID") Integer petId) {

        System.out.println("Get info of: " + petId);

        PetResponse petResponse = new PetResponse();
        petResponse.setName("Cat");
        petResponse.setType("Mammal");

        numberOfGetRequests.inc();

        return new ResponseEntity(petResponse,HttpStatus.OK);
    }
}
