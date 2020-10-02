package com.carriernet.assignment.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.carriernet.assignment.service.UserWalletServiceImpl;
import com.carriernet.assignment.vo.FundTransferDto;
import com.carriernet.assignment.vo.UserWalletDto;

@RestController("userWalletResource")
@RequestMapping(value = "/user/wallet")
public class UserWalletResource extends AbstactResource {

	@Autowired
	private UserWalletServiceImpl userWaletService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserWalletDto createUserWallet(@RequestBody UserWalletDto userWalletDto) {
		return userWaletService.createUserWallet(userWalletDto);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public UserWalletDto getUserWallet(@RequestBody UserWalletDto userWalletDto) {
		return userWaletService.getUserWallet(userWalletDto);
	}

	@GetMapping("/all")
	@ResponseStatus(HttpStatus.OK)
	public List<UserWalletDto> getUserAllWallet() {
		return userWaletService.getAllUserWallet();
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public UserWalletDto updateUserWallet(@RequestBody UserWalletDto userWalletDto) {
		return userWaletService.updateUserWallet(userWalletDto);
	}

	@PutMapping("/transfer")
	@ResponseStatus(HttpStatus.OK)
	public void fundTransfer(@RequestBody FundTransferDto fundTransferDto) {
		userWaletService.fundTransfer(fundTransferDto);
	}

}
