package com.srr.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/swagger")
@Api(tags = {"MyController","Swagger学习控制器"},description = "学习哦")
public class MyController {

    @PostMapping("/post")
    @ApiOperation(value = "post方法,执行数据新增",notes = "swagge学习哦")
    public String post(@ApiParam(name = "用户名",value = "新增用户",required = true) String a, String b) {
        return "post";
    }

    @ApiIgnore
    @GetMapping("/get")
    public String get(String a, String b) {
        return "get";
    }

    @MyAnnotation$Swagger
    @RequestMapping("/req")
    public String req(String m) {
        return "req";
    }
}
