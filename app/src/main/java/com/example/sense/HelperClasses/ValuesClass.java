package com.example.sense.HelperClasses;

import android.content.Intent;

public class ValuesClass {
    public Integer score;
    public Integer energypoints;
    public Integer dailygoal;

    public ValuesClass() {

    }

    public ValuesClass(Integer score, Integer energypoints, Integer dailygoal) {
        this.score = score;
        this.energypoints = energypoints;
        this.dailygoal = dailygoal;
    }

    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }

    public Integer getEnergypoints() { return energypoints; }
    public void setEnergypoints(Integer energypoints) { this.energypoints = energypoints; }

    public Integer getDailygoal() { return dailygoal; }
    public void setDailygoal(Integer dailygoal) { this.dailygoal = dailygoal; }
}
