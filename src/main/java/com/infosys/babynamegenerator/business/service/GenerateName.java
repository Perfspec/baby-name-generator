package com.infosys.babynamegenerator.business.service;

import org.springframework.stereotype.Service;

import com.infosys.babynamegenerator.constants.Constants;

@Service
public class GenerateName implements IGenerateNames {

	public String generateName(Integer desiredLength, String initialName) {
		Integer initLength = initialName.length();
		
		if(initLength==desiredLength) {
			return initialName;
		} else if(initLength > desiredLength) {
			return initialName.substring(0, desiredLength);
		} else {
			return buildToDesiredLength(desiredLength, initialName);
		}
	}
	
	private String buildToDesiredLength(Integer desiredLength, String initialName) {
		StringBuilder newName=new StringBuilder(initialName);
		for(int count=initialName.length(); count <= desiredLength;count++) {
			newName.append(generateChar());
		}
		return newName.toString();
	}
	
	private char generateChar() {
		Integer rand = (int) Math.floor(Math.random()*Constants.alphabet.length+1);
		return Constants.alphabet[rand];
	}

}
