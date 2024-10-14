package com.flipkart.client;

import com.flipkart.bean.*;
import com.flipkart.business.BookingService;
import com.flipkart.business.SlotService;
import com.flipkart.dao.*;
import com.flipkart.utils.DbUtils;

import java.util.*;

public class SlotActivityMenu {

    public static GymDao gymDao = new GymDao();
    public static DbUtils dbUtils = new DbUtils();
    public static SlotDao slotDao = new SlotDao();
    public static BookingDao bookingDao = new BookingDao();

    private SlotService slotService = new SlotService();

    public void addSlot(Scanner scanner,String gymOwnerId){

        List<Gym> gymList=gymDao.getGymCenters(gymOwnerId);


        System.out.println();
        System.out.println("=== Approved Gym List ===");
        System.out.printf("%-15s %-25s %-20s %-30s%n", "Gym ID", "Gym Name", "City", "Address");
        System.out.println("--------------------------------------------------------------");
        for (Gym gym : gymList) {
            if (gym.getIsListed()) {
                System.out.printf("%-15s %-25s %-20s %-30s%n", gym.getGymId(), gym.getGymName(), gym.getCity(), gym.getAddress());
            }
        }

        System.out.println();
        System.out.print("Select the Gym ID to add slots: ");


        boolean isValidSelection=false;
        String selectedId = "";
        while (isValidSelection==false){
            selectedId=scanner.nextLine();
            for(Gym gym:gymList){
                if(gym.getGymId().equals(selectedId)){
                    isValidSelection=true;
                }
            }

            if(!isValidSelection) {
                System.out.println("Invalid selection, please try again");
                addSlot(scanner, gymOwnerId);
            }

        }

        System.out.println();
        System.out.println("Please enter the below details");
        System.out.println();

        String id = Integer.toString(1+dbUtils.getTableCnt("Slot"));
        System.out.print("Enter year(yyyy): ");
        String year = scanner.nextLine();
        System.out.print("Enter month(mm): ");
        String month = scanner.nextLine();
        System.out.print("Enter date(dd): ");
        String date = scanner.nextLine();

        System.out.print("Enter Start time according to 24hrs clock(0000-2359): ");
        String startTime = scanner.nextLine();
        System.out.print("Enter End time according to 24hrs clock(0000-2359): ");
        String endTime = scanner.nextLine();
        System.out.print("Enter capacity of slot(Number of vacancies): ");

        String st = date+"/"+month+"/"+year;
        int cp = scanner.nextInt();
        Slot slt = new Slot(selectedId,  id, st, startTime,endTime,cp);
        slotService.addSlot(slt);

        System.out.println();
        System.out.println("------ Slot added successfully ------");
        System.out.println();

    }


    public void bookSlot(Scanner scanner, User user){

        List<Gym> gymList=gymDao.getAllGymCenters();

        System.out.println();
        System.out.print("Enter city: ");
        String city = scanner.nextLine();
        System.out.println();
        System.out.println("-----Gyms that are available in " + city +"-----");

        System.out.println();
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-15s %-25s %-30s%n", "Gym ID", "Gym Name", "Address");
        System.out.println("---------------------------------------------------------------");

        for (Gym gym : gymList) {
            if (gym.getIsListed() && gym.getCity().equals(city)) {
                System.out.printf("%-15s %-25s %-30s%n",
                        gym.getGymId(),
                        gym.getGymName(),
                        gym.getAddress());
            }
        }

        System.out.println();
        System.out.print("Enter the selected gym's ID: ");
        String gymId = scanner.nextLine();

        Gym selectedGym=getGymFromId(gymList, gymId, city);

        while(selectedGym==null){
            System.out.println("Invalid selection, please try again");
            System.out.println("Enter the selected gym's ID: ");
            gymId = scanner.nextLine();
            selectedGym=getGymFromId(gymList,gymId,city);
        }



        System.out.print("Enter the date of booking (DD/MM/YYYY): ");
        String date=scanner.nextLine();





        List<Slot> slotList= slotDao.getSlots(gymId,date);
        List<String> availableSlotIds=new LinkedList<>();

        System.out.println();
        System.out.println("=== Available Slots ===");
        System.out.printf("%-15s %-20s %-20s %-15s %-10s%n", "Slot ID", "Start Time", "End Time", "Capacity", "Date");
        System.out.println("--------------------------------------------------------------------------------");

        for (Slot slot : slotList) {
            int bookedCount = bookingDao.bookedSlotCount(slot.getSlotID());
            int currentCapacity = slot.getCapacity() - bookedCount;

            if (currentCapacity != 0) {
                availableSlotIds.add(slot.getSlotID());
                System.out.printf("%-15s %-20s %-20s %-15d %-10s%n",
                        slot.getSlotID(),
                        slot.getStarttime(),
                        slot.getEndtime(),
                        currentCapacity,
                        slot.getDate());
            }
        }

        System.out.println();
        System.out.print("Select the slot ID to book the slot: ");

        String selectedSlotId = scanner.nextLine();

        while(!isValidSlotId(availableSlotIds,selectedSlotId)){
            System.out.println("Invalid selection, please try again");
            selectedSlotId=scanner.nextLine();
        }

        slotService.bookSlot(user.getUserId(),selectedSlotId);
        System.out.println("------SLOT BOOKED------");
        System.out.println();


    }


    public Gym getGymFromId(List<Gym> gymList, String gymId, String selectedCity){
        for(Gym gym:gymList){
            if(gym.getGymId().equals(gymId) && gym.getCity().equals(selectedCity))
            {
                return gym;
            }
        }
        return null;
    }

    public boolean isValidSlotId(List<String> slotIds, String selectedSlotId){
        for(String slotId:slotIds){
            if(slotId.equals(selectedSlotId))
            {
                return true;
            }
        }
        return false;
    }

    public void cancelSlot(Scanner scanner, User user){


        BookingService bookingService=new BookingService();


        bookingService.viewAllBookings(user.getUserId());

        System.out.print("Select ID of the booking for cancelling: ");
        String selectedSlotId=scanner.nextLine();

        bookingDao.deleteSlot(selectedSlotId);

        System.out.println("------Slot Cancelled Successfully------");
        System.out.println();
    }






}

