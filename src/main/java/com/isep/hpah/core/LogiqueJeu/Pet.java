package com.isep.hpah.core.LogiqueJeu;

import java.util.Random;

    enum Pet {
    OWL,RAT,CAT,TOAD;

    }

    class RandomEnum <E extends Enum<Pet>> {
        Random RND = new Random();
        E[] values;

        public RandomEnum(Class<E> token) {
            values = token.getEnumConstants();
        }

        public E random() {
        return values[RND.nextInt(values.length)];
    }

}


