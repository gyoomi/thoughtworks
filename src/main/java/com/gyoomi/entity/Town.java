/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/5/10 9:53
 */
public class Town implements Comparable<Town>, Serializable {

    private static final long serialVersionUID = -2515700412978222529L;

    private String name;

    public Town() {}

    public Town(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Town o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Town town = (Town) o;
        return Objects.equals(name, town.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Town{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
