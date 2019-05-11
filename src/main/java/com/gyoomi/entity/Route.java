/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * Route
 *
 * @author Leon
 * @version 2019/5/10 10:07
 */
public class Route implements Serializable {

    private static final long serialVersionUID = -6444364338027828386L;

    private Town from;
    private Town to;
    private Integer distance;

    public Route() {}

    public Route(Town from, Town to, Integer distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Route route = (Route) o;
        return Objects.equals(from, route.from) &&
                Objects.equals(to, route.to) &&
                Objects.equals(distance, route.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, distance);
    }

    public Town getFrom() {
        return from;
    }

    public void setFrom(Town from) {
        this.from = from;
    }

    public Town getTo() {
        return to;
    }

    public void setTo(Town to) {
        this.to = to;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Route{" +
                "from=" + from +
                ", to=" + to +
                ", distance=" + distance +
                '}';
    }
}
