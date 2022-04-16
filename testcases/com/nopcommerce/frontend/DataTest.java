package com.nopcommerce.frontend;

import com.github.javafaker.Faker;

public class DataTest {
	
	public class RegisteredAccount{
		
		Faker faker = new Faker();
		public String firstName = this.faker.name().firstName();
		public String lastName = this.faker.name().lastName();
		public String email = this.faker.bothify("????####@????.com");
		public String password = this.faker.bothify("????????");
		public String confirmPassword = password;
		
	}
	
	public class CustomerInfo{
		public String gender = "F";
		public String firstName = "Automation";
		public String lastName = "FC";
		public String birthDay = "1";
		public String birthMonth = "January";
		public String birthYear = "1999";
		public String email = "automationfc.vn@gmail.com";
		public String company = "Automation FC";
	}
	
	public class Address{
		public String firstName = "Automation";
		public String lastName = "FC";
		public String email = "automationfc.vn@gmail.com";
		public String company = "Automation FC";
		public String country = "Viet Nam";
		public String city = "Da Nang";
		public String address1 = "123/04 Le Lai";
		public String address2 = "234/05 Hai Phong";
		public String zip = "550000";
		public String phone = "0123456789";
		public String fax = "0987654321";
		
	}
	
}
