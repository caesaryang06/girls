package com.yxm.girls.controller;

import com.yxm.girls.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    /**
     * 当需要多个url访问同一个方法的时候就需要使用集合 类似如下
     *http://localhost:8081/hello/say 或者 http://localhost:8081/hello/hello  都可以访问say()这个方法
      * @return
     */
    @GetMapping(value = {"/hello","/say"})
    public String say(){

        return "i like girl with "+girlProperties.getCupSize();
    }


    /**
     * 该案例主要用来获取请求中的参数  这个是用来获取 http://localhost:8081/hello/hello/12  12这个参数的方法
     * @return
     */
    @GetMapping("/hello/{id}")
    public String getParemeter1(@PathVariable("id") Integer ids){

        return "id=="+ids;
    }

    /**
     * 该案例主要用来获取http://localhost:8081/hello/hello?id=14 这个id的值
     * @RequestParam(value = "id",required = false,defaultValue = "0"
     * 上面的这个注解的意思是 id这个参数可以不传值【就是说不带id这个参数也可以访问】  给一个默认值为0
     * @param cmId
     * @return
     */
    @GetMapping("/hello2")
    public String getParemeter2(@RequestParam(value = "id",required = false,defaultValue = "0") Integer cmId){

        return "id=="+cmId;
    }


}
