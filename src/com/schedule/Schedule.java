
package com.schedule;

import java.util.*;

public class Schedule {
    private ArrayList<Nurse> nurses;

    public Schedule(ArrayList<Nurse> nurses) {
        this.nurses = nurses;
    }

    private boolean checkSchedule(String den, Nurse nurse) {
        if(nurse.getNight()>1)
            return false;
        if(den.equals("night"))
            nurse.setNight(nurse.getNight()+1);
        return true;
    }

    public ArrayList<Nurse> selectNurse(String den, int people) {
        Set<Nurse> temp = new HashSet<>();
        Nurse sel ;

        while(temp.size() < people) {
            Double d = Math.random() * 18;

            sel = nurses.get(d.intValue());

            if(!checkSchedule(den, sel)) {
                continue;
            }

            temp.add(sel);
        }
        return new ArrayList<>(temp);
    }
}
