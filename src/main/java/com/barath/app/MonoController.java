package com.barath.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.lang.invoke.MethodHandles;

/**
 * Created by barath.arivazhagan on 9/5/2017.
 */
@RestController
@RequestMapping(value="/mono")
public class MonoController {

    private static final Logger logger= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private MonoService service;

    public MonoController(MonoService service){
        this.service=service;

    }

    @GetMapping(value="/string")
    public Mono<String> createMonoOfString(){
        return service.createMonoOfString();
    }

    @GetMapping(value="/string/delay")
    public Mono<String> createMonoOfStringWithDelay(){
        return service.createMonoOfStringWithDelay();
    }

    @GetMapping(value="/doOnNext")
    public Mono<String> getMonoAfterDoOnNext(){
        return service.createMonoWithOperatorOnNext();

    }


    @GetMapping(value="/int")
    public Mono<Integer> createMonoOfInteger(){
        return service.createMonoWithIntegerType();

    }


}
