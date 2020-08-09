package cn.cloud.square.first.controller;

import cn.cloud.square.first.dto.ParkListResponse;
import cn.cloud.round.first.dto.Park;
import cn.cloud.square.first.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/park")
public class ParkController {

    @Autowired
    private ParkService parkService;

    @GetMapping("/list")
    public ParkListResponse parkList() {
        return new ParkListResponse(1001, "success", parkService.getParkList());
    }

    @GetMapping("/")
    public Park park() {
        Park park1 = new Park();
        park1.setId(1001);
        park1.setName("地王大厦");
        return park1;
    }
}
