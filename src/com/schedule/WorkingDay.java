package com.schedule;

import java.util.ArrayList;
import java.util.HashMap;

public class WorkingDay {
    int day_people, even_people, night_people;
    ArrayList<Nurse> nurses;
    HashMap<String, ArrayList<Nurse>> one_day = new HashMap<>();

    public WorkingDay(int day_people, int even_people, int night_people, ArrayList<Nurse> nurses) {
        this.day_people = day_people;
        this.even_people = even_people;
        this.night_people = night_people;
        this.nurses = nurses;
    }

    public HashMap<String, ArrayList<Nurse>> settingSchedule() {
        Schedule schedule = new Schedule(nurses);
        one_day.put("day",schedule.selectNurse("day",day_people));
        one_day.put("even",schedule.selectNurse("even",even_people));
        one_day.put("night",schedule.selectNurse("night",night_people));
        return one_day;
    }
}
