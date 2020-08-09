package cn.cloud.square.first.service.impl;

import cn.cloud.round.first.dto.Park;
import cn.cloud.square.first.service.ParkService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkServiceImpl implements ParkService {
    @Override
    public List<Park> getParkList() {
        // 这里手动构造两条数据，加装从数据库查询出来的
        List<Park> parkList = new ArrayList<>();

        Park park1 = new Park();
        park1.setId(1001);
        park1.setName("地王大厦");
        parkList.add(park1);

        Park park2 = new Park();
        park2.setId(1002);
        park2.setName("国金中心");
        parkList.add(park2);

        return parkList;
    }
}
