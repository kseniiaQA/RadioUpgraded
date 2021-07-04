package ru.netology.radio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {

    @Test
    void stationUnderLimitDefault() {
        Radio service = new Radio();

        service.setCurrentStation(-1);
        assertEquals(0, service.getCurrentStation());


        service.setCurrentStation(4);
        service.setCurrentStation(-1);
        assertEquals(4, service.getCurrentStation());
    }

    @Test
    void stationAboveLimitDefault() {
        Radio service = new Radio();

        service.setCurrentStation(10);
        assertEquals(0, service.getCurrentStation());


        service.setCurrentStation(4);
        service.setCurrentStation(10);
        assertEquals(4, service.getCurrentStation());
    }

    @Test
    void stationAboveLimitConstructor() {
        Radio service = new Radio(20);

        service.setCurrentStation(-1);
        assertEquals(0, service.getCurrentStation());


        service.setCurrentStation(5);
        service.setCurrentStation(50);
        assertEquals(5, service.getCurrentStation());
    }

    @Test
    void stationPrevButtonDefault() {
        Radio service = new Radio();

        assertEquals(0, service.getCurrentStation());


        service.prevButton();
        assertEquals(9, service.getCurrentStation());
        service.prevButton();
        assertEquals(8, service.getCurrentStation());
    }

    @Test
    void stationPrevButtonConstructor() {
        Radio service = new Radio(25);

        assertEquals(0, service.getCurrentStation());


        service.prevButton();
        assertEquals(24, service.getCurrentStation());
        service.prevButton();
        assertEquals(23, service.getCurrentStation());
    }

    @Test
    void stationNextButtonDefault() {
        Radio service = new Radio();

        assertEquals(0, service.getCurrentStation());

        service.setCurrentStation(8);

        service.nextButton();
        assertEquals(9, service.getCurrentStation());
        service.nextButton();
        assertEquals(0, service.getCurrentStation());
    }

    @Test
    void stationNextButtonConstructor() {
        Radio service = new Radio(30);

        assertEquals(0, service.getCurrentStation());

        service.setCurrentStation(28);

        service.nextButton();
        assertEquals(29, service.getCurrentStation());
        service.nextButton();
        assertEquals(0, service.getCurrentStation());
    }


    @Test
    void volumeUp() {
        Radio service = new Radio();


        assertEquals(0, service.getVolume());


        service.volumeUp();
        assertEquals(1, service.getVolume());
        service.volumeUp();
        assertEquals(2, service.getVolume());
    }

    @Test
    void volumeUpAboveMax() {
        Radio service = new Radio();


        assertEquals(0, service.getVolume());


        int i = 0;
        while (i < 110) {
            service.volumeUp();
            i++;
        }
        assertEquals(100, service.getVolume());
    }

    @Test
    void volumeDown() {
        Radio service = new Radio();


        service.volumeUp();
        assertEquals(1, service.getVolume());
        service.volumeUp();
        assertEquals(2, service.getVolume());


        service.volumeDown();
        assertEquals(1, service.getVolume());
        service.volumeDown();
        assertEquals(0, service.getVolume());

    }

    @Test
    void volumeDownMin() {
        Radio service = new Radio();


        assertEquals(0, service.getVolume());


        service.volumeDown();
        assertEquals(0, service.getVolume());
    }
}