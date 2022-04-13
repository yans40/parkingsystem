package com.parkit.parkingsystem.service;

import com.parkit.parkingsystem.constants.Fare;
import com.parkit.parkingsystem.model.Ticket;

import javax.swing.*;

public class FareCalculatorService {

	public void calculateFare(Ticket ticket) {
		if ((ticket.getOutTime() == null)
				|| (ticket.getOutTime().before(ticket.getInTime()))) {
			throw new IllegalArgumentException("Out time provided is incorrect:" + ticket.getOutTime().toString());
		}

		long inHour = ticket.getInTime().getTime();
		long outHour = ticket.getOutTime().getTime();

		// TODO: Some tests are failing here. Need to check if this logic is
		// correct
		long duration = outHour - inHour;

		// if (duration<1800000)


		double durationPark = ((double) duration / 1000 / 60 / 60);



		switch (ticket.getParkingSpot().getParkingType()) {



			case CAR : {
				ticket.setPrice(durationPark * Fare.CAR_RATE_PER_HOUR);
				break;
			}
			case BIKE : {
				ticket.setPrice(durationPark * Fare.BIKE_RATE_PER_HOUR);
				break;
			}

			default :
				throw new IllegalArgumentException("Unknown Parking Type");
		}

	}
}