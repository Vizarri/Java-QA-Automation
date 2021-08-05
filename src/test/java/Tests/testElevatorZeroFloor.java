package Tests;

import elevator.ElevatorFloors;
import models.Elevator.Elevator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class testElevatorZeroFloor {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 2, 3, 4, 5})
    public void testElevatorZeroFloor(int floor) {
        ElevatorFloors elevatorFloors = new ElevatorFloors(-1, 5);
        Elevator elevator = new Elevator(0, elevatorFloors, false);
        int expectedResult = floor;
        int actualResult = elevator.getCurrentFloor();
        Assert.assertEquals("0 этажа не может быть", expectedResult, actualResult);
    }
}
