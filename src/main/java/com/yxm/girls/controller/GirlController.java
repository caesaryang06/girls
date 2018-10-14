package com.yxm.girls.controller;

import com.yxm.girls.Repository.GirlRespository;
import com.yxm.girls.beans.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GirlController {
    @Autowired
    private GirlRespository girlRespository;

   //获取女生列表
    @GetMapping("/girls")
   public List<Girl> showGirls(){

     return girlRespository.findAll();
   }

   //新增女生信息
    @PostMapping("/addGirl")
    public String addGirl(@RequestParam("cupSize") String cupSize,
                          @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        Girl result = girlRespository.save(girl);
        return result==null?"保存失败":"保存成功";
    }

   //根据id查询一个女生
    @GetMapping("/girl/{id}")
    public Girl findGirlOne(@PathVariable("id") Integer id){
        Optional<Girl> optionalGirl = girlRespository.findById(id);

        return optionalGirl.isPresent()?optionalGirl.get():null;
    }

   //根据id修改girl
   @PutMapping("/girl/{id}")
    public Girl updateGirlById(@PathVariable("id") Integer id,
                               @RequestParam("cupSize") String cupSize,
                               @RequestParam("age") Integer age){
       Girl girl = new Girl();
       girl.setCupSize(cupSize);
       girl.setAge(age);
       girl.setId(id);
       Girl result = girlRespository.save(girl);

       return result;
   }

   //根据id删除女生
    @DeleteMapping("/girl/{id}")
    public String deleteGirl(@PathVariable("id") Integer id){

        girlRespository.deleteById(id);
        return "ok";
    }



}
