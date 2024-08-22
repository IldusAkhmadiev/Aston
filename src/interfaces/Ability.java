package interfaces;

import units.Unit;

import java.util.Random;

public interface Ability {
    /**
     *  Передается % вероятности сработывания способности
     *  Ожидаемое значение от 1 до 100
     *  При передаче некорректного числа автоматически генерируется случайный %
     * **/
    default boolean canUseAbility(int percentSuccess) {
        if(percentSuccess == 0) {
            return false;
        }
       final int PERCENT = (percentSuccess <= 0  || percentSuccess >= 101)
               ? new Random().nextInt(1,101)
               : percentSuccess ;

       int i = new Random().nextInt(1,101);
       if (i <= PERCENT) {  // удачно способность можно применить
           return true;
       }
       return false;
   }


    <T extends Unit> void useAbility(T unit);

    abstract boolean canUseAbility();
}

