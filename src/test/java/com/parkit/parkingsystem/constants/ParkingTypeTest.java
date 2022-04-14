package com.parkit.parkingsystem.constants;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingTypeTest {

    @Test
    void valueOf() {
        ParkingType parkingType = ParkingType.CAR;
        assertEquals(parkingType.valueOf("CAR"),parkingType);

    }

}