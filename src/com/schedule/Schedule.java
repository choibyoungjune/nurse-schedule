
package com.schedule;

import java.util.*;
import java.util.stream.Collectors;

public class Schedule {
    private ArrayList<Nurse> nurses, employee=new ArrayList<>();
    private int day_people, even_people, night_people;
    private HashMap<String, ArrayList<Nurse>> schedule = new HashMap<>();

    public Schedule(ArrayList<Nurse> nurses, int day_people, int even_people, int night_people) {
        this.nurses = nurses;
        this.day_people = day_people;
        this.even_people = even_people;
        this.night_people = night_people;
    }

    private boolean checkSchedule(String den, Nurse nurse) {
        if(nurse.getNight()>1)
            return false;
        if(den.equals("night"))
            nurse.setNight(nurse.getNight()+1);
        return true;
    }

    public void settingSchedule() {
        selectNurse("day",day_people);
        selectNurse("even",even_people);
        selectNurse("night",night_people);
    }

    private void selectNurse(String den, int people) {
        Set<Nurse> temp = new HashSet<>();
        Nurse sel;

        while(temp.size() < people) {
            Double d = Math.random() * 18;

            if(employee.contains(nurses.get(d.intValue())))
                continue;
            sel = nurses.get(d.intValue());

            if(!checkSchedule(den, sel))
                continue;

            if(schedule.get(den)!=null)
                temp = schedule.get(den).stream().collect(Collectors.toSet());
            temp.add(sel);
            schedule.put(den, new ArrayList<>(temp));
        }

        for(Nurse n : schedule.get(den))
            employee.add(n);
    }

    public HashMap<String, ArrayList<Nurse>> getSchedule() {
        return schedule;
    }
}
