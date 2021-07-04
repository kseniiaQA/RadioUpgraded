package ru.netology.radio;

public class Radio {

    private int currentStation;
    private int volume;
    private int quantityStation = 10;

    public Radio() {
    }

    public Radio(int quantityStation) {
        this.quantityStation = quantityStation;
    }


    public void nextButton() {
        if (this.currentStation == quantityStation - 1) {
            this.currentStation = 0;
        } else {
            this.currentStation++;
        }
    }

    public void prevButton() {
        if (this.currentStation == 0) {
            this.currentStation = quantityStation - 1;
        } else {
            this.currentStation--;
        }
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation < 0 || currentStation > quantityStation - 1) {
            return;
        }
        this.currentStation = currentStation;
    }

    public int getCurrentStation() {
        return currentStation;
    }


    private boolean isVolumeMax(int currentVolume) {
        return currentVolume == 100;
    }

    public void volumeUp() {
        if (this.isVolumeMax(this.volume)) {
            return;
        }
        this.volume++;
    }

    private boolean isVolumeMin(int currentVolume) {
        return currentVolume == 0;
    }

    public void volumeDown() {
        if (this.isVolumeMin(this.volume)) {
            return;
        }
        this.volume--;
    }

    public int getVolume() {
        return volume;
    }
}