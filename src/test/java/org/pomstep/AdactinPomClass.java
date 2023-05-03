package org.pomstep;

import org.basestep.LearnBaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinPomClass extends LearnBaseClass {
	public AdactinPomClass() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement username;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "login")
	private WebElement login;

	@FindBy(id = "location")
	private WebElement location;

	@FindBy(id = "hotels")
	private WebElement hotels;

	@FindBy(id = "room_type")
	private WebElement roomtype;

	@FindBy(id = "room_nos")
	private WebElement roomnos;

	@FindBy(id = "datepick_in")
	private WebElement indate;

	@FindBy(id = "datepick_out")
	private WebElement outdate;

	@FindBy(id = "adult_room")
	private WebElement adultsnos;

	@FindBy(id = "child_room")
	private WebElement childnos;

	@FindBy(id = "Submit")
	private WebElement submit;

	@FindBy(id = "radiobutton_0")
	private WebElement selecthotel;

	@FindBy(id = "continue")
	private WebElement continuenext;

	@FindBy(id = "first_name")
	private WebElement firstname;

	@FindBy(id = "last_name")
	private WebElement lastname;

	@FindBy(id = "address")
	private WebElement address;

	@FindBy(id = "cc_num")
	private WebElement ccardnum;

	@FindBy(id = "cc_type")
	private WebElement cardtype;

	@FindBy(id = "cc_exp_month")
	private WebElement expmonth;

	@FindBy(id = "cc_exp_year")
	private WebElement expyear;
	
	@FindBy(id = "cc_cvv")
	private WebElement cvvnum;

	@FindBy(id = "book_now")
	private WebElement book;

	@FindBy(id = "order_no")
	private WebElement orderid;


	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotels() {
		return hotels;
	}

	public WebElement getRoomtype() {
		return roomtype;
	}

	public WebElement getRoomnos() {
		return roomnos;
	}

	public WebElement getIndate() {
		return indate;
	}

	public WebElement getOutdate() {
		return outdate;
	}

	public WebElement getAdultsnos() {
		return adultsnos;
	}

	public WebElement getChildnos() {
		return childnos;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getSelecthotel() {
		return selecthotel;
	}

	public WebElement getContinuenext() {
		return continuenext;
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCcardnum() {
		return ccardnum;
	}

	public WebElement getCardtype() {
		return cardtype;
	}

	public WebElement getExpmonth() {
		return expmonth;
	}

	public WebElement getExpyear() {
		return expyear;
	}

	public WebElement getCvvnum() {
		return cvvnum;
	}

	public WebElement getBook() {
		return book;
	}

	public WebElement getOrderid() {
		return orderid;
	}
	
	public void login(String textUser,String textPass) {
		elementTextSend(getUsername(), textUser);
		elementTextSend(getPassword(), textPass);
		elementClick(getLogin());
	}
	
	public void searchHotel(String locat, String hotelname, String room,String roomno, String in, String out, String adult,
			String child) {
		elementTextSend(getLocation(), locat);
		elementTextSend(getHotels(), hotelname);
		elementTextSend(getRoomtype(), room);
		elementTextSend(getRoomnos(), roomno);
		clearBox(indate);	
		elementTextSend(getIndate(), in);
		getOutdate().clear();
		elementTextSend(getOutdate(), out);		
		elementTextSend(getAdultsnos(), adult);
		elementTextSend(getChildnos() , child);
		
	}
	
	public void searchOk() {
		elementClick(submit);
	}
	
	public void selectHotel() {
		selecthotel.click();
		continuenext.click();
	}
	
	public void hotelpage(String firstname, String lastname, String address, String cardNum, String cardType, String expmonth,
			String expear, String cvvnum) {
		elementTextSend(getFirstname(), firstname);
		elementTextSend(getLastname(), lastname);
		elementTextSend(getAddress(), address);
		elementTextSend(getCcardnum(), cardNum);
		elementTextSend(getCardtype(), cardType);
		elementTextSend(getExpmonth(), expmonth);
		elementTextSend(getExpyear(), expear);
		elementTextSend(getCvvnum(), cvvnum);
	}
	
	public void bookHotel() {
		elementClick(book);
	}
	
	public void orderId() {
		
		
	}

	
	 

	
	
	
	

	
}