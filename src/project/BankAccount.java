/**
 * Copyright 2019 Techtorial LLC
 */
package project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BankAccount {
 
	ArrayList<AccountInfo> customers;

	{
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("data/names.txt"));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			customers = new ArrayList<>();
			while (line != null) {
				String[] accountDetails = line.split(",");
				String[] nameLastName = accountDetails[0].split(" ");
				AccountInfo o1 = new AccountInfo(nameLastName[0], nameLastName[1], Integer.parseInt(accountDetails[1]),
						accountDetails[2]);
				customers.add(o1);
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			String everything = sb.toString();
		} catch (Exception e) {
			System.out.println("File not loaded");
		} finally {
		}
	}

	/**
	 * Write a method that will count customers only from chicago //loop for the city return the number
	 * Use customers -> holds all Customer information
	 * 
	 * @return int -> number of customers from Chicago
	 */
	public int countChicagoCustomers() {
		int countChicago=0;
		for (int i=0; i<customers.size();i++){
			if (customers.get(i).getCity().equals("chicago")){
				countChicago++;
			}
		}
		return countChicago;
	}

	/**
	 * Write a method that will return person name who has highest balance
	 * 
	 * Use customers -> holds all Customer information
	 * 
	 * @return String (name of person who has highest balance)
	 */

	public String highestBalance() {
		String nameOfPerson="";
		int largestBalance=0;
		int num=0;
		for (int i=0; i<customers.size();i++){
			if(customers.get(i).getBalance()>largestBalance){
				largestBalance=customers.get(i).getBalance();
				num=i;
			}
		nameOfPerson=customers.get(num).getName();
		}
		return nameOfPerson;
	}

	/**
	 * Write a method that will accept Arrays of AccountInfo object and
	 * will add those new customers to ArrayList "customers"
	 * and will return same arrayList with new customer added.
	 * 
	 * @parameter array of AccountInfo
	 * @return ArrayList -> added with new customers
	 */
	public ArrayList<AccountInfo> addArray(AccountInfo[] newCustomers) {

	for (int i=0;i<newCustomers.length;i++ ){

		customers.add(newCustomers[i]);
	}
		// TO DO take this new arrays of customers and add it to arrayList
		//(from array to arraylist, returns arraylist)
		return customers;
	}

	/**
	 * Write a code that will update a balance for the customer who made
	 * transaction. If customer is not in the list then return null
	 * 
	 * for example:
	 * method updateBalance(new AccountInfo("Anna", "Dennis", 50, "atlanta"));
	 * original record from customers arrayList: Anna Dennis,300,atlanta
	 * then deduct $50 from previous balance which is $300 and
	 * return AccountInfo object with deducted amount -> Anna Dennis,250,atlanta
	 *
	 * customers -> holds all Customer information
	 *
	 * @parameter AccountInfo Object
	 * @return AccountInfo object
	 * 
	 */

	public AccountInfo updateBalance(AccountInfo transaction) {
		for(int i=0; i<customers.size(); i++){
			if(customers.get(i).getName().equals(transaction.getName())&&customers.get(i).getLastName().equals(transaction.getLastName())&&
					customers.get(i).getCity().equals(transaction.getCity())){
				int newBalance=customers.get(i).getBalance()-transaction.getBalance();
				return new AccountInfo(transaction.getName(), transaction.getLastName(),newBalance, transaction.getCity());
			}
		}
		return null;
	}

	/**
	 * Write a method that will remove all duplicate data from customers
	 * ArrayList and return number of unique customers
	 * 
	 * @return ArrayList of unique customers
	 */

	public int removeDuplicateCustomers() {
		ArrayList <AccountInfo>newList=new ArrayList();
	for(int i=0; i<customers.size(); i++){
		for(int k=i+1; k<customers.size(); k++){
			if(customers.get(i).getName().equals(customers.get(k).getName())
					&& customers.get(i).getLastName().equals(customers.get(k).getLastName())
					&& customers.get(i).getCity().equals(customers.get(k).getCity())){
				newList.add(customers.get(i));

			}

		}

		}
	customers.removeAll(newList);
		return customers.size();
	}

}
