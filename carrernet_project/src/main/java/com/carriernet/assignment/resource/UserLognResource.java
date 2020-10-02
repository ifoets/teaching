package com.carriernet.assignment.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.carriernet.assignment.service.UserLoginServiceImpl;
import com.carriernet.assignment.vo.UserAccountDto;

@RestController("userLognResource")
@RequestMapping(value = "/user")
public class UserLognResource extends AbstactResource {

	@Autowired
	private UserLoginServiceImpl userLoginService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserAccountDto createUser(@RequestBody UserAccountDto userAccountDto) {
		return userLoginService.createUser(userAccountDto);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public UserAccountDto getLogin(@RequestBody UserAccountDto userAccountDto) {
		return userLoginService.getUser(userAccountDto);
	}

	@GetMapping("/logout")
	@ResponseStatus(HttpStatus.OK)
	public UserAccountDto getLogOut(@RequestBody UserAccountDto userAccountDto) {
		return userLoginService.logout(userAccountDto);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Integer updatePassworf(@RequestBody UserAccountDto userAccountVO) {
		return userLoginService.updatePassword(userAccountVO);
	}

}
