package com.miguel;

public class Employee {
        private int id;
        private String name;
        private String email;
        private String gender;
        private String country;

    public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		

	    public Employee(int id, String name, String email, String gender, String country) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.gender = gender;
			this.country = country;
		}

		public Employee(int id, String name, String email, String phone) {
	        this.id = id;
	        this.name = name;
	        this.email = email;
	        this.gender = phone;
	    }
		
	public Employee(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.gender = phone;
    }

    public Employee(String name, String email, String gender, String country) {
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.country = country;
	}

	public String getPhone() {
        return gender;
    }

    public void setPhone(String phone) {
        this.gender = phone;
    }

    public Employee(){

   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
