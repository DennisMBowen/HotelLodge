import java.util.List;
import java.util.Scanner;


import controller.HotelRoomHelper;
import model.HotelRoom;


/**
 * @author Dennis Bowen - dmbowen
 * CIS175 - Fall 2022
 * Sep 13, 2022
 */

public class StartProgram {
	
	static Scanner in = new Scanner (System.in);
	static HotelRoomHelper hrh = new HotelRoomHelper();
	
	private static void addHotelRoom(){
		// TODO Auto-generated method stub
		System.out.println();
		System.out.print("Enter the hotel room number: ");
		int roomNumber = in.nextInt();
		System.out.print("Enter the number of beds: ");
		int beds = in.nextInt();
		System.out.print("Enter the bed size: ");
		String size = in.next();
		boolean isVacant = true;
		System.out.print("Is the room vacant? (y/n): ");
		String vacancy = in.next();
		if (vacancy.equals("n")){
			isVacant = false;
		}
		HotelRoom newRoom = new HotelRoom(roomNumber, beds, size, isVacant);
		hrh.insertItem(newRoom);
		
	}
	
	private static void removeHotelRoom() {
		System.out.println();
		System.out.print("Enter the hotel room number to be deleted: ");
		int roomNumber = in.nextInt();
		hrh.deleteRoom(roomNumber);
	}
	
	private static void viewHotelRooms() {
		List<HotelRoom>allRooms = hrh.showAllRooms();
		System.out.println();
		for(HotelRoom room : allRooms) {
			System.out.println(room.displayRoomDetails());
		}
	}
	
	private static void editVacancy () {
		System.out.println();
		System.out.print("Enter the hotel room number to change the vacancy status:  ");
		int roomNumber = in.nextInt();
		hrh.updateVacancy(roomNumber);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runProgram();
	}
	
	public static void runProgram() {
		System.out.println("Welcome to Hotel Lodge database creator!");
		boolean running = true;
		while (running) {
			System.out.println();
			int selection = 0;
			System.out.println("Please select from the following options: ");
			System.out.println("1 = Add a new hotel room");
			System.out.println("2 = Remove hotel room from database");
			System.out.println("3 = Update an existing hotel room's vacancy status");
			System.out.println("4 = Display hotel rooms");
			System.out.println("5 = Exit the program");
			System.out.print("User Selection: ");
			selection = in.nextInt();
			if (selection == 1) {
				addHotelRoom();
			} else if (selection == 2) {
				removeHotelRoom();
			} else if (selection == 3 ) {
				editVacancy();
			} else if (selection == 4 ) {
				hrh.showAllRooms();
				viewHotelRooms();
			} else if (selection == 5 ) {
				System.out.println("Good-bye!");
				running = false;
			} else {
				System.out.println("Invalid entry");
			}
		}
	}
	
}
