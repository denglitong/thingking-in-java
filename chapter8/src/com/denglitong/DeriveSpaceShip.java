package com.denglitong;

/**
 * @autor denglitong
 * @date 2019/7/26
 */
public class DeriveSpaceShip extends SpaceShipControls {

    private String name;

    public DeriveSpaceShip(String name) {
        this.name= name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        DeriveSpaceShip protector = new DeriveSpaceShip("NESA Protector");
        protector.forward(100);
    }

}
