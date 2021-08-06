package Tests;

import elevator.ElevatorFloors;
import org.junit.Assert;
import org.junit.Test;

public class TestElevatorFloors {

    @Test
    public void testElevatorFloorsСonstructor() {
        ElevatorFloors elevatorFloors = new ElevatorFloors(5, 10);
        int expectedResult = 5;
        int actualResult = elevatorFloors.getMinFloor();
        Assert.assertEquals("Минимальный этаж не может быть больше 1", expectedResult, actualResult);

    }
}
