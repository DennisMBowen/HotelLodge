package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Dennis Bowen - dmbowen
 * CIS175 - Fall 2022
 * Sep 13, 2022
 */


@Entity
@Table(name = "rooms")
public class HotelRoom {
	
	//Instance variables
	@Id
	@Column(name = "RoomNumber")
	private int roomNumber;
	@Column(name = "BedsNumber")
	private int numberOfBeds;
	@Column(name = "BedSize")
	private String bedSize;
	@Column(name = "Vacancy")
	private boolean isVacant;
	
	//Getters and Setters
	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getNumberOfBeds() {
		return numberOfBeds;
	}

	public void setNumberOfBeds(int numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}

	public String getBedSize() {
		return bedSize;
	}

	public void setBedSize(String bedSize) {
		this.bedSize = bedSize;
	}

	
	public boolean isVacant() {
		return isVacant;
	}

	public void setVacant(boolean isVacant) {
		this.isVacant = isVacant;
	}
	

	//Default No_arg Constructor
	public HotelRoom() {
		
	}
	
	//Constructor that uses parameters
	public HotelRoom(int roomNumber, int numberOfBeds, String bedSize, boolean isVacant) {
		this.roomNumber = roomNumber;
		this.numberOfBeds = numberOfBeds;
		this.bedSize = bedSize;
		this.isVacant = isVacant;
	}
	
	public String displayRoomDetails() {
			return "Room Number " + this.roomNumber + ": " + this.numberOfBeds + " " + this.bedSize + " bed(s), Vacancy: " + this.isVacant;
	}
	
}
