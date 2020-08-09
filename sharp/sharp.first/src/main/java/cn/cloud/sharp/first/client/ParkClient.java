package cn.cloud.sharp.first.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import cn.cloud.round.first.dto.Park;

@FeignClient(name = "park", fallback = ParkClient.ParkClientFallback.class)
public interface ParkClient {

    @GetMapping("/park/list")
    String parkList();

    @GetMapping("/park/")
    Park park();

    @Component
    static class ParkClientFallback implements ParkClient {
        // 对应的方法，如果产生服务降级就可以到这里来
        @Override
        public String parkList() {
            return "哎哟";
        }

        @Override
        public Park park() {
            return new Park();
        }
    }
}
