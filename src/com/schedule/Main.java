package com.schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.DoubleToIntFunction;

public class Main {

    public static void main(String[] args) {
        ArrayList<Nurse> nurses = new ArrayList<Nurse>();
        ArrayList<HashMap<String, ArrayList<Nurse>>> month_schedule = new ArrayList<>();

        nurses.add(new Nurse("양나경", 1));
        nurses.add(new Nurse("애봉이", 2));
        nurses.add(new Nurse("이윤지", 3));
        nurses.add(new Nurse("김혜리", 4));
        nurses.add(new Nurse("김고은", 5));
        nurses.add(new Nurse("진민옥", 6));
        nurses.add(new Nurse("이민주", 7));
        nurses.add(new Nurse("심은하", 8));
        nurses.add(new Nurse("박광경", 9));
        nurses.add(new Nurse("갑갑이", 10));
        nurses.add(new Nurse("성유진", 11));
        nurses.add(new Nurse("김애진", 12));
        nurses.add(new Nurse("명지영", 13));
        nurses.add(new Nurse("박지현", 14));
        nurses.add(new Nurse("김가영", 15));
        nurses.add(new Nurse("윤해빈", 16));
        nurses.add(new Nurse("유은경", 17));
        nurses.add(new Nurse("구다해", 18));

        Schedule schedule;
        for(int i=0; i<31; i++) {
            System.out.println(i);
            schedule = new Schedule(nurses, 5, 4, 3);
            schedule.settingSchedule();
            month_schedule.add(schedule.getSchedule());
            schedule = null;
        }
        System.out.println("1일 day 근무자 : ");
        for(Nurse one_day : month_schedule.get(0).get("day")) {
            System.out.println(one_day.getName());
        }

        System.out.println("2일 day 근무자 : ");
        for(Nurse one_day : month_schedule.get(1).get("day")) {
            System.out.println(one_day.getName());
        }

        System.out.println("3일 day 근무자 : ");
        for(Nurse one_day : month_schedule.get(2).get("day")) {
            System.out.println(one_day.getName());
        }
    }
}
