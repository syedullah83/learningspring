package com.safiullah.learningspring.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.safiullah.learningspring.business.domain.RoomReservation;
import com.safiullah.learningspring.business.service.ReservationService;
import com.safiullah.learningspring.utils.DateUtils;

@Controller
@RequestMapping("/reservations")
public class RoomReservationWebController {

	@Autowired
	ReservationService reservationService;
	
	@GetMapping
	public String getReservations(@RequestParam(value = "date", required = false) String dateString, Model model) {
		
		// Parsing dateString to Date using the method we created in DateUtils class.
		Date date = DateUtils.createDateFromDateString(dateString);
		List<RoomReservation> roomReservations = reservationService.getRoomReservationsForDate(date);
		model.addAttribute("roomReservations", roomReservations);
		return "reservations";
		
	}
	
}
