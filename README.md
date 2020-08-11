# my-spring-cloud-example
 spring-cloud-example
 
本项目是基于consul 的 spring cloud 微服务示例
相关consul 的使用参见 https://www.cnblogs.com/linjiqin/p/9718223.html
 
 octagon 文件夹是gateway
 
 round 是 sharp 和 square 都需要的依赖示例
 所以要先在这个文件夹执行 mvn install
 
 
 sharp\sharp.first 依赖  sharp\sharp.second， 所以要先 mvn install, 然后进入 sharp.first 后 mvn spring-boot:run  或者 py package.py就可以运行项目
 quare\sharp.first 依赖  quare\sharp.second
  sharp对square有微服务的依赖，不过不影响启动和打包。
 
 网络的性能损失是比较大的
 
 gateway  本身tps可以一万多，spring cloud gateway 代理 spring boot 就只有三千多tps,  再feign调用服务tps就只有一千多了
 不过这仍然比传统的php快得多， 比yaf 还快一点。不过现在php常驻是趋势了。
 
 
 
 key：config/myconsul,dev/data
value：
myName: jack
student: 
  name: jack
  age: 18
  sex: 男
  
 key： config/park,dev/data
 value：
 myName: jack
student: 
  name: jack
  age: 18
  sex: 男
  

 
