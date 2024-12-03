package day_3;

import lombok.Getter;

@Getter
public class Multiplier {

    public final long result;

    public Multiplier(long first_number, long second_number){
        result = first_number * second_number;
    }

}
