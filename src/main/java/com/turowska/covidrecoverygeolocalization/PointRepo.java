package com.turowska.covidrecoverygeolocalization;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PointRepo {
    private List<Point> points;

    public PointRepo(List<Point> points) {
        this.points = new ArrayList<>();
    }

    public List<Point> getPoints() {
        return points;
    }

    public void addPoints(Point point) {
        this.points.add(point);
    }
}
