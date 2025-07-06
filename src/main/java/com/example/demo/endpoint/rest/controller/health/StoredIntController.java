package com.example.demo.endpoint.rest.controller.health;

import com.example.demo.service.StoredIntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
class StoredIntController {

    @Autowired
    private StoredIntService storedIntService;

    @GetMapping("/stored-int")
    public int getStoredInt() throws IOException {
        return storedIntService.getOrCreateStoredInt();
    }
}
