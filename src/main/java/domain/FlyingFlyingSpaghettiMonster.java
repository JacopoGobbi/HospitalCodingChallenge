package domain;

import java.util.Random;

public class FlyingFlyingSpaghettiMonster implements Divinity {
    public boolean appear() {
        return (long)(new Random().nextDouble()*1000000L)==0L;
    }
}
