package com.schedule;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.DoubleToIntFunction;

public class Main {

    public static void main(String[] args) throws SQLException {
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


        String driver = "org.mariadb.jdbc.Driver";
        String query = "INSERT INTO nurse VALUES(?,?,?,?)";
        Connection con=null;
        PreparedStatement statement=null;
        ResultSet result;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(
                    "jdbc:mariadb://127.0.0.1:3306/nurse_schedule",
                    "testuser",
                    "testuser123!");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("DB 접속 실패");
            e.printStackTrace();
        }
        if( con != null ) {
            System.out.println("DB 접속 성공");

            try {
                statement = con.prepareStatement(query);

                for(int i=0; i<30; i++) {
                    System.out.println("check-"+i);
                    WorkingDay wd = new WorkingDay(5,4,3,nurses);
                    for(Nurse n : wd.settingSchedule().get("day")) {
                        statement.setInt(1, n.getRank());
                        statement.setString(2, n.getName());
                        statement.setString(3, "day");
                        statement.setInt(4, i+1);
                        System.out.println(statement.executeUpdate());
                    }
                }



            }catch (SQLException e) {
                System.out.println("실패   "+statement);
            }
        }
        else {
            System.out.println("Failed to create connection to database.");
        }



        System.out.println("day 멤버: ");
        for(Nurse n : month_schedule.get(0).get("day")) {
            System.out.print(" "+n.getName());
        }
        System.out.println("\neven 멤버: ");
        for(Nurse n : month_schedule.get(0).get("even")) {
            System.out.print(" "+n.getName());
        }
        System.out.println("\nnight 멤버: ");
        for(Nurse n : month_schedule.get(0).get("night")) {
            System.out.print(" "+n.getName());
        }
    }
}
