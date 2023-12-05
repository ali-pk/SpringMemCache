package com.example.springmemcache.Controller;

import com.example.springmemcache.Service.MemService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/memcached")
public class MemController {

    @Autowired
    private MemService memService;

    @RequestMapping("/store")
    public String storeValue(@RequestParam String mapName, @RequestParam String key, @RequestParam String value){
        memService.storeValue(mapName,key, value);
        return "Data inserted";
    }

    @GetMapping("/get")
    public String getValue(@RequestParam String mapName,@RequestParam String key){
        return memService.getValue(mapName,key);
    }

    @GetMapping("/clear")
    public String getValue(@RequestParam String mapName){
        memService.clear(mapName);
        return "Data Cleared";
    }
}




