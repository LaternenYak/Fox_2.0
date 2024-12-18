package com.oni42.api.controller;

import com.oni42.api.service.FabricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fabric")
public class FabricController {

    private final FabricService fabricService;

    @Autowired
    public FabricController(FabricService fabricService) {
        this.fabricService = fabricService;
    }

    @GetMapping("/calculate")
    public String calculateFabric(
            @RequestParam double length,
            @RequestParam double width) {
        return fabricService.performCalculation(length, width);
    }
}
