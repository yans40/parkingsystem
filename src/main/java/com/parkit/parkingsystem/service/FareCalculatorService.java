package com.parkit.parkingsystem.service;

import com.parkit.parkingsystem.constants.Fare;
import com.parkit.parkingsystem.model.Ticket;
import org.jetbrains.annotations.NotNull;


public class FareCalculatorService {

	public void calculateFare(Ticket ticket) {
		if ((ticket.getOutTime() == null)
				|| (ticket.getOutTime().before(ticket.getInTime()))) {
			throw new IllegalArgumentException("Out time provided is incorrect:" + ticket.getOutTime().toString());
		}

        long inHour = ticket.getInTime().getTime();
        long outHour = ticket.getOutTime().getTime();

        // TODO: Some tests are failing here. Need to check if this logic is correct
        long duration = outHour - inHour;

        double durationPark = ((double) duration / 1000 / 60 / 60);

        double durationTime = 0;

        if  (durationPark >= 0.5) {

            durationTime = durationPark ;
        }



        switch (ticket.getParkingSpot().getParkingType()) {

            case CAR: {
                ticket.setPrice(durationTime * Fare.CAR_RATE_PER_HOUR);
                break;
            }
            case BIKE: {
                ticket.setPrice(durationTime * Fare.BIKE_RATE_PER_HOUR);
                break;
            }

            default:
                throw new IllegalArgumentException("Unknown Parking Type");
        }

    }
}