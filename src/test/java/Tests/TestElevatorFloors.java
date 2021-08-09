package Tests;

import elevator.ElevatorFloors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestElevatorFloors {

    @Test
    public void testElevatorFloorsСonstructor() {
        ElevatorFloors elevatorFloors = new ElevatorFloors(5, 10);
        int expectedResult = 5;
        int actualResult = elevatorFloors.getMinFloor();
        Assertions.assertEquals(expectedResult, actualResult,"Минимальный этаж не может быть больше 1");

    }
}
