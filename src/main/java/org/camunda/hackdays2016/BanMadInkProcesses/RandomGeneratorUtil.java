package org.camunda.hackdays2016.BanMadInkProcesses;

import java.util.UUID;

public class RandomGeneratorUtil {
	
	
	public String generateID(){
        // Creating a random UUID (Universally unique identifier).
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();

        return randomUUIDString;
	}
	
	//paymentRejected
	//numberOfPayouts
	//historyOfFraud
	//userDeterminedFraud
	
	public Boolean getRandomUserDeterminedFraud(){
		return randomBoolean(50);
	}
	
	public Boolean getRandomHistoryOfFraud()
	{
		return randomBoolean(20);
	}
	
	public Boolean getRandomPaymentRejected()
	{
		return randomBoolean(30);
	}
	
	public int getRandomNumberOfPayments()
	{
		if(randomBoolean(50))
			return 0;
		return randomNumber(20);
	}
	
	public String getRandomName()
	{
		return "Niall";
	}
	
	public String getRandomClaimType()
	{
		if(randomBoolean(20))
			return "personal";
		if(randomBoolean(50))
			return "car";
	    
	    return "home";
			
	}
	
	public String getRandomRegion()
	{
		if(randomBoolean(15))
			return "austin";
		if(randomBoolean(20))
			return "pretoria";
		if(randomBoolean(20))
			return "dublin";
		
		return "berlin";
	}
	
	public double getRandomClaimAmount(){
		return randomNumber(2000000);
	}
	
	public boolean randomBoolean(int chanceOutOf100)
	{
	   int value = randomNumber(100);
	   
	   if(value < chanceOutOf100)
		   return true; //it's a hit!
	   else
		   return false; // it's a miss!
	}
	
	public int randomNumber(int upTo){
		int value = (int)(Math.random() * upTo);
		return value;
	}
	
}
