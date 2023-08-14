package com.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PaintingDAO paintingDAO = new PaintingDAO();

        paintingDAO.dropPaintingTable();
        paintingDAO.setUpPaintingTable();

        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("please enter the painting you wish to add:");
            String input = sc.nextLine();
            paintingDAO.insertPainting(input);
            System.out.println("Here are all your paintings so far");
            List<String> myPaintings = paintingDAO.getAllPaintingNames();
            System.out.println(myPaintings);
            
        }
    }
}