package cn.cloud.sharp.first.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.cloud.sharp.first.client.ParkClient;
import org.springframework.web.client.RestTemplate;

import cn.cloud.round.first.dto.Park;

// Ribbon-Hystrix-Feign

@RestController
@RequestMapping("/devices")
public class DevicesController {

    @Autowired
    private ParkClient parkClient;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.consul-park}")
    private String parkServiceUrl;

    @GetMapping("/park-template")
    public Park getUser() {
        // 测试 netflix-ribbon
        return restTemplate.getForObject(parkServiceUrl + "/park/", Park.class);
    }

    @GetMapping("/park-list")
    public String callParkList() {
        return parkClient.parkList();
    }

    @GetMapping("/park")
    public Park callPark() {
        // 测试 new FeignClient
        Park park = parkClient.park();
        park.setName("保密");
        return park;
    }


}
