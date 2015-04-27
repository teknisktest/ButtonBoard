package com.soprasteria.boot.service;

import com.soprasteria.boot.domain.Stilling;
import org.springframework.stereotype.Service;

/**
 * Created by olovholm on 27.04.2015.
 */

@Service
public class StillingService {

    public static Stilling stringTilStilling(String str){
        for (Stilling stiling : Stilling.values()) {
            if (stiling.name().equalsIgnoreCase(str))
                return stiling;
        }
        return null;
    }


}
