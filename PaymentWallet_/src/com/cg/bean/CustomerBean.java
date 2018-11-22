package com.cg.bean;

	import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

	@Entity
	@Table(name="Bank_Customer5")
	public class CustomerBean {
		
		@Id
		@Column(name="cust_id")
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int Id;

		@Column(name="First_name")
		private String firstName;
		
		@Column(name="Last_name")
		private String lastName;
		
		@Column(name="email_id")
		private String emailId;
		@Column(name="gender")
		private String gender;
		
		
		@Column(name="phone_number")
		private String phoneNo;
		
		@Column(name="pan_number")
		private String panNum;
		
		@Column(name="address")
		private String address;
		
		@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
		@JoinColumn(name="accountId")
		private AccountBean accountBean;
		

		
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getPhoneNo() {
			return phoneNo;
		}
		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}
		
		public String getFirstName() {
			return firstName;
		}
		
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		
		public String getPanNum() {
			return panNum;
		}
		public void setPanNum(String panNum) {
			this.panNum = panNum;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		
		public AccountBean getAccountBean() {
			return accountBean;
		}
		public void setAccountBean(AccountBean accountBean) {
			this.accountBean = accountBean;
		}
		
		
		
		@Override
		public String toString() {
			return "CustomerBean [Id=" + Id + ", firstName=" + firstName
					+ ", lastName=" + lastName + ", emailId=" + emailId
					+ ", gender=" + gender + ", phoneNo=" + phoneNo
					+ ", panNum=" + panNum + ", address=" + address
					+ ", accountBean=" + accountBean + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Id;
			result = prime * result + ((address == null) ? 0 : address.hashCode());
			result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
			result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
			result = prime * result + ((gender == null) ? 0 : gender.hashCode());
			result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
			result = prime * result + ((panNum == null) ? 0 : panNum.hashCode());
			result = prime * result + ((phoneNo == null) ? 0 : phoneNo.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CustomerBean other = (CustomerBean) obj;
			if (Id != other.Id)
				return false;
			if (address == null) {
				if (other.address != null)
					return false;
			} else if (!address.equals(other.address))
				return false;
			if (emailId == null) {
				if (other.emailId != null)
					return false;
			} else if (!emailId.equals(other.emailId))
				return false;
			if (firstName == null) {
				if (other.firstName != null)
					return false;
			} else if (!firstName.equals(other.firstName))
				return false;
			if (gender == null) {
				if (other.gender != null)
					return false;
			} else if (!gender.equals(other.gender))
				return false;
			if (lastName == null) {
				if (other.lastName != null)
					return false;
			} else if (!lastName.equals(other.lastName))
				return false;
			if (panNum == null) {
				if (other.panNum != null)
					return false;
			} else if (!panNum.equals(other.panNum))
				return false;
			if (phoneNo == null) {
				if (other.phoneNo != null)
					return false;
			} else if (!phoneNo.equals(other.phoneNo))
				return false;
			return true;
		}
		public CustomerBean(int id, String firstName, String lastName, String emailId, String gender, String phoneNo,
				String panNum, String address) {
			super();
			Id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.emailId = emailId;
			this.gender = gender;
			this.phoneNo = phoneNo;
			this.panNum = panNum;
			this.address = address;
		}
		public CustomerBean() {
			super();
		}
		
		
		
		
		
		
			

}
