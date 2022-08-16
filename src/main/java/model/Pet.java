package model;

import lombok.Data;

import java.util.Date;


    @Data //having implicit @Getter, @Setter, @ToString, @EqualsAndHashCode and @RequiredArgsConstructor
    public class Pet { //create class and assign of data

        private int petId ;
        private String name ;
        private String status ;

    }

