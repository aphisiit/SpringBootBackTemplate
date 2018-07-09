package com.training.backend.controller;

import com.training.backend.service.UserService;
import flexjson.JSONSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/userCustom")
public class UserController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "UserService")
    @Autowired
    UserService userService;

    @GetMapping(value = "/findAll",headers = "Accept=application/json; charset=UTF-8")
    public ResponseEntity<String> findAll(){
        LOGGER.info("findAll");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json; charset=utf-8");
        try {
            return new ResponseEntity<String>(
                    new JSONSerializer()
                            .prettyPrint(true)
                            .exclude("*.class")
                            .serialize(userService.findAllUser())
                    ,headers
                    ,HttpStatus.OK);
        }catch (Exception e){
            LOGGER.error(e.getMessage());
            return new ResponseEntity<String>(e.getMessage(),headers,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/{id}",headers = "Accept=application/json; charset=UTF-8")
    public ResponseEntity<String> findById(@PathVariable("id") Long id){
        LOGGER.info("findById : {}",id);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json; charset=utf-8");

        try {
            return new ResponseEntity<String>(
                    new JSONSerializer()
                        .prettyPrint(true)
                        .exclude("*.class")
                        .serialize(userService.findById(id).get())
                    ,headers
                    ,HttpStatus.OK);
        }catch (Exception e){
            LOGGER.error(e.getMessage());
            return new ResponseEntity<String>(e.getMessage(),headers,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/findByFirstNameIgnoreCaseContaining",headers = "Accept=application/json; charset=UTF-8")
    public ResponseEntity<String> findByFirstNameIgnoreCaseContaining(@RequestParam("firstName") String firstName){
        LOGGER.info("firstName : {}",firstName);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json; charset=utf-8");

        return new ResponseEntity<String>(
                new JSONSerializer()
                        .prettyPrint(true)
                        .exclude("*.class")
                        .serialize(userService.findByFirstNameIgnoreCaseContaining(firstName))
                ,headers,HttpStatus.OK);
    }


    @DeleteMapping(value = "/deleteById/{id}",headers = "Accept=application/json; charset=UTF-8")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id){
        LOGGER.info("deleteById");

        userService.deleteById(id);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json; charset=utf-8");

        return new ResponseEntity<String>("\"status\" : \"success\"",headers,HttpStatus.OK);
    }
}
