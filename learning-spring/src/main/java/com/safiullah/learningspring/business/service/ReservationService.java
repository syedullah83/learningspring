package com.safiullah.learningspring.business.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safiullah.learningspring.business.domain.RoomReservation;
import com.safiullah.learningspring.data.entity.Guest;
import com.safiullah.learningspring.data.entity.Reservation;
import com.safiullah.learningspring.data.entity.Room;
import com.safiullah.learningspring.data.repository.GuestRepository;
import com.safiullah.learningspring.data.repository.ReservationRepository;
import com.safiullah.learningspring.data.repository.RoomRepository;

@Service
public class ReservationService {

	private final RoomRepository roomRepository;
	private final GuestRepository guestRepository;
	private final ReservationRepository reservationRepository;
	
	@Autowired
	public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository,
			ReservationRepository reservationRepository) {
		super();
		this.roomRepository = roomRepository;
		this.guestRepository = guestRepository;
		this.reservationRepository = reservationRepository;
	}
	
	public List<RoomReservation> getRoomReservationsForDate(Date date){
		List<RoomReservation> roomReservations = null;
		Iterable<Reservation> reservations = reservationRepository.findReservationByResDate(date);
		for (Reservation reservation : reservations) {
			RoomReservation roomResr = new RoomReservation();
			roomResr.setDate(date);
			Guest guest = guestRepository.findById(reservation.getGuestId()).get();
			roomResr.setFirstName(guest.getFirstName());
			roomResr.setLastName(guest.getLastName());
			roomResr.setGuestId(guest.getGuestId());
			Room room = roomRepository.findById(reservation.getRoomId()).get();
			roomResr.setRoomId(room.getRoomId());
			roomResr.setRoomName(room.getRoomName());
			roomResr.setRoomNumber(room.getRoomNumber());
			roomReservations.add(roomResr);
		}
		return roomReservations;
	}
	
}
