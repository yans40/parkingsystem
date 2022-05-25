package com.parkit.parkingsystem.dao;

import com.parkit.parkingsystem.constants.ParkingType;
import com.parkit.parkingsystem.model.ParkingSpot;
import com.parkit.parkingsystem.model.Ticket;
import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class TicketDAOTest {


    private static ParkingSpot parkingSpot =new ParkingSpot(1, ParkingType.CAR, true);




    @Test
    void saveTicket() {
        TicketDAO ticketDAO =new TicketDAO();


        Ticket ticket = new Ticket();

        ticket.setParkingSpot(parkingSpot);
        ticket.setVehicleRegNumber("ABCDEF");
        ticket.setPrice(1.5);
        ticket.setIsRecurrent(false);
        ticket.setInTime(new Date(System.currentTimeMillis() - (60 * 60 * 1000)));
        ticket.setOutTime(new Date());
        ticketDAO.saveTicket(ticket);

        assertThat(ticketDAO.saveTicket(ticket)).isTrue();

    }

    @Test
    void getTicketbyId() {
        TicketDAO ticketDAO =new TicketDAO();
        Ticket  ticket = ticketDAO.getTicket("NOCAR");
        Assertions.assertNull(ticket);
        assertFalse(ticketDAO.isRecurrent("NOCAR"));
    }

  /*  @Test
    void updateTicket() {
    }

    @Test
    void isRecurrent() {
    }*/
}