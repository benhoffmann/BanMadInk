package org.camunda.hackdays2016.BanMadInkProcesses;

public class FraudScoreTableObject {
	
	String tableName = "fraudRating";
	String fraudInstanceID;
	//inputs
	boolean paymentRejected;
	int numberOfPayouts;
	boolean historyOfFraud;
	long calimAmount;
	
	//Output
	int fraudScore;

	
	
	
	
	public String getFraudInstanceID() {
		return fraudInstanceID;
	}

	public void setFraudInstanceID(String fraudInstanceID) {
		this.fraudInstanceID = fraudInstanceID;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public boolean isPaymentRejected() {
		return paymentRejected;
	}

	public void setPaymentRejected(boolean paymentRejected) {
		this.paymentRejected = paymentRejected;
	}

	public int getNumberOfPayouts() {
		return numberOfPayouts;
	}

	public void setNumberOfPayouts(int numberOfPayouts) {
		this.numberOfPayouts = numberOfPayouts;
	}

	public boolean isHistoryOfFraud() {
		return historyOfFraud;
	}

	public void setHistoryOfFraud(boolean historyOfFraud) {
		this.historyOfFraud = historyOfFraud;
	}

	public long isCalimAmount() {
		return calimAmount;
	}

	public void setCalimAmount(long calimAmount) {
		this.calimAmount = calimAmount;
	}

	public int getFraudScore() {
		return fraudScore;
	}

	public void setFraudScore(int fraudScore) {
		this.fraudScore = fraudScore;
	}
	

}
