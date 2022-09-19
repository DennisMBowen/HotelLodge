package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.HotelRoom;

/**
 * @author Dennis Bowen - dmbowen
 * CIS175 - Fall 2022
 * Sep 13, 2022
 */
public class HotelRoomHelper {
	
	//Create global instance of EntityFactoryManager
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("HotelLodge");
		
	//Method to accept a ListItem to add
	public void insertItem (HotelRoom hr) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(hr);
		em.getTransaction().commit();
		em.close();
	}
		
	public List<HotelRoom> showAllRooms(){
		EntityManager em = emfactory.createEntityManager();
		List<HotelRoom>allRooms = em.createQuery("SELECT i FROM HotelRoom i").getResultList();
		return allRooms;
	}
	
	public void deleteRoom(int roomNumber) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		HotelRoom toDelete = em.find(HotelRoom.class, roomNumber);
		em.remove(toDelete);
		em.getTransaction().commit();
		em.close();
	}


	public void updateVacancy(int roomNumber) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		HotelRoom toUpdate = em.find(HotelRoom.class, roomNumber);
		if (toUpdate.isVacant()) {
			System.out.println("This hotel room is currently vacant. It will be updated to not vacant.");
			toUpdate.setVacant(false);
		} else {
			System.out.println("This hotel is currently occupied. It will be updated to vacant.");
			toUpdate.setVacant(true);
		}
		em.getTransaction().commit();
		em.close();
		
	}
	
	
	
}
