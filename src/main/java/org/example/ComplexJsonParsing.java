package org.example;


import io.restassured.path.json.JsonPath;

public class ComplexJsonParsing {

    public static void main(String[] args) {
        JsonPath js = new JsonPath(payload.CoursePrice());

        //Print No of courses returned by API
        int count = js.getInt("courses.size()");
        System.out.println(count);
        System.out.println("------------------------------------");

        //Print Purchase Amount
        int totalAmount=js.getInt("dashboard.purchaseAmount");
        System.out.println(totalAmount);
        System.out.println("------------------------------------");

        //Print Title of the last course
        String CourseTitle=js.get("courses[3].title");
        System.out.println(CourseTitle);
        System.out.println("------------------------------------");

        //Print All course titles and their respective Prices
        for(int i=0;i<count;i++)
        {
           String CourseTitles= js.get("courses["+i+"].title");
           System.out.println(js.get("courses["+i+"].price").toString());
           System.out.println(CourseTitles);
        }

        //Print no of copies sold by RPA Course
        System.out.println("------------------------------------");
         for(int i=0;i<count;i++) {
             String CourseTitles = js.get("courses["+i+"].title");
             if (CourseTitles.equalsIgnoreCase("rpa"))
             {
                 int copies = js.get("courses["+i+"].copies");
                 System.out.println(copies);
                 break;
             }
         }

    }
}