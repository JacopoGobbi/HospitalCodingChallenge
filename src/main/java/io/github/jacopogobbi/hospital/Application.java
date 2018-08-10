package io.github.jacopogobbi.hospital;

import io.github.jacopogobbi.hospital.domain.FlyingFlyingSpaghettiMonster;

class Application {
    public static void main(String[] args) {
        new Hospital(new FlyingFlyingSpaghettiMonster()).treatPatients(args);
    }
}