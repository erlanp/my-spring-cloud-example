package cn.cloud.sharp.first.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import cn.cloud.round.first.config.StudentConfig;
import cn.cloud.round.first.config.Student2Config;

@RestController
@EnableConfigurationProperties({StudentConfig.class, Student2Config.class})
@RequestMapping("/config")
public class ConfigController {

	@Autowired
	private StudentConfig studentConfig;
	
	@Autowired
    private Student2Config student2Config;
    
    @Value("${myName}")
	protected String msgname;
	@RequestMapping("/msgname")
    public String msgname() {
        return msgname;
    }

    @RequestMapping("/config")
    public String testConfig() {
        return studentConfig.toString();
    }

    @RequestMapping("/config2")
    public String testConfig2() {
        return student2Config.toString();
    }

    @RequestMapping("/student")
    public StudentConfig student() {
        return studentConfig;
    }
}
