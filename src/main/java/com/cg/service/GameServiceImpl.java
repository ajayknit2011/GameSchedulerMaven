package com.cg.service;

import com.cg.bean.Game;

public class GameServiceImpl implements GameService {

	public Game add(Game game) {
		// TODO Auto-generated method stub
		if(game==null ) {
			
			throw new IllegalArgumentException();
		}
		//Game game1=new Game("Cricket",3);
		return null;
	}

	/*
	 * 
	 * 
	 * public Customer createWallet(String name, String phone, BigDecimal amount) {
		
		if(name == null || phone == null || amount == null){
			throw new IllegalArgumentException();
		}
		Customer customer = new Customer(name,phone, new Wallet(amount));
		if(repo.save(customer)){
			return customer;
		}
		return null;
	}
	 * */
	
	
}
