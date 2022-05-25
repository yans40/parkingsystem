package com.parkit.parkingsystem.service;

import com.parkit.parkingsystem.constants.ParkingType;
import com.parkit.parkingsystem.dao.ParkingSpotDAO;
import com.parkit.parkingsystem.dao.TicketDAO;
import com.parkit.parkingsystem.model.ParkingSpot;
import com.parkit.parkingsystem.model.Ticket;
import com.parkit.parkingsystem.util.InputReaderUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public
class ParkingServiceTest {

    private static ParkingService parkingService;

    @Mock
    private static InputReaderUtil inputReaderUtil;
    @Mock
    private static ParkingSpotDAO parkingSpotDAO;
    @Mock
    private static TicketDAO ticketDAO;


    @BeforeEach
    private
    void setUpPerTest() {

        try {

            parkingService = new ParkingService(inputReaderUtil, parkingSpotDAO, ticketDAO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to set up test mock objects");
        }
    }


    @Test
    public
    void processIncomingCarTest() throws Exception {

        //GIVEN

        when(inputReaderUtil.readSelection()).thenReturn(1);//donne l'information sur le type de parking souhaité
        when(parkingSpotDAO.getNextAvailableSlot(any(ParkingType.class))).thenReturn(1);// donne l'info sur le n° de place dispo



        // WHEN
        parkingService.processIncomingVehicle();


        verify(parkingSpotDAO, Mockito.times(1)).updateParking(any(ParkingSpot.class));//vérifie si la mise à jour de la base de données parking est appelée au moins une fois


    }

    @Test
    public
    void processIncomingBikeTest() {

        //GIVEN
        when(inputReaderUtil.readSelection()).thenReturn(2);
        when(parkingSpotDAO.getNextAvailableSlot(any(ParkingType.class))).thenReturn(2);

        // WHEN
        parkingService.processIncomingVehicle();

        verify(parkingSpotDAO, Mockito.times(1)).getNextAvailableSlot(any(ParkingType.class));
        verify(parkingSpotDAO, Mockito.times(1)).updateParking(any(ParkingSpot.class));
        assertThat(parkingSpotDAO.getNextAvailableSlot(any(ParkingType.class))).isEqualTo(0);

    }


    @Test
    void processExitingVehicleTest() throws Exception {


        when(inputReaderUtil.readVehicleRegistrationNumber()).thenReturn("ABCDEF");


        parkingService.processExitingVehicle();

        verify(ticketDAO, Mockito.times(1)).getTicket("ABCDEF");
        assertThat(inputReaderUtil.readVehicleRegistrationNumber()).isEqualTo("ABCDEF");


    }
}
