package com.example.eurekaclient.service;

import java.util.Map;

import com.example.eurekauser.pojo.UserPo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


// 指定服务ID（Service ID）
@FeignClient("user")
public interface UserService {
	// 指定通过HTTP的GET方法请求路径
	@GetMapping("/user/{id}")
	// 这里会采用Spring MVC的注解配置
	public UserPo getUser(@PathVariable("id") Long id);

	// POST方法请求用户微服务
	@PostMapping("/insert")
	public Map<String, Object> addUser(
            // 请求体参数
            @RequestBody UserPo user);

	// POST方法请求用户微服务
	@PostMapping("/update/{userName}")
	public Map<String, Object> updateName(
            // URL参数
            @PathVariable("userName") String userName,
            // 请求头参数
            @RequestHeader("id") Long id);

	// 调用用户微服务的timeout请求
	@GetMapping("/timeout")
	public String testTimeout();
}