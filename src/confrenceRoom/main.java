package confrenceRoom;

import java.util.ArrayList;
import java.util.Arrays;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Double> ans = new ArrayList();
		int num = 5;
		int time1 = toMin("14:30");
		int time2 = toMin("15:00");
		ArrayList<ConRoom> rooms = new ArrayList();
		int[][] openTime1 = {{toMin("9:00"), toMin("9:15")}, {toMin("14:30"), toMin("15:00")}};
		rooms.add(addRoom(7.11, 8, openTime1));
		int[][] openTime2 = {{toMin("10:00"), toMin("11:00")}, {toMin("14:00"), toMin("15:00")}};
		int[][] openTime3 = {{toMin("11:30"), toMin("12:30")}, {toMin("17:00"), toMin("17:30")}};
		int[][] openTime4 = {{toMin("9:30"), toMin("10:30")}, {toMin("12:00"), toMin("12:150")}, {toMin("15:15"), toMin("16:15")}};
		int[][] openTime5 = {{toMin("9:00"), toMin("11:00")}, {toMin("14:00"), toMin("16:00")}};
		int[][] openTime6 = {{toMin("10:30"), toMin("11:30")}, {toMin("13:30"), toMin("15:30")}, {toMin("16:30"), toMin("17:30")}};
		rooms.add(addRoom(8.23, 6, openTime2));
		rooms.add(addRoom(8.43, 7, openTime3));
		rooms.add(addRoom(9.511, 9, openTime4));
		rooms.add(addRoom(9.527, 4, openTime5));
		rooms.add(addRoom(9.547, 8, openTime6));

		for(int i = 0; i < rooms.size(); i++) {
			if(rooms.get(i).getMaxNum()<num) {
				rooms.remove(i);
			}
		}
		for(int i = 0; i < rooms.size(); i++) {
			if(check(rooms.get(i).getOpenTime(),time1,time2)) {
				ans.add(rooms.get(i).getRoomInfo());
			}
		}
		
		System.out.println(ans);
		System.out.println(binarySearch(ans, 8));
		
	}
	public static int toMin(String time) {
		String[] hourMin = time.split(":");
		int hour = Integer.parseInt(hourMin[0]);
		int min = Integer.parseInt(hourMin[1]);
		return hour*60 + min;
	}
	public static ConRoom addRoom(double roomNum, int maxNum, int[][] openTime1) {
		ConRoom room = new ConRoom(roomNum, maxNum, openTime1);
		return room;
	}
	private static boolean check(int[][] arr, int toCheckValue1, int toCheckValue2) {
		boolean test = false;
		for (int[] element : arr) { 
            if (element[0] <= toCheckValue1 &&  element[1] >= toCheckValue2) { 
                test = true; 
                break; 
            } 
        }  
        return test;
	}
	public static double binarySearch(ArrayList<Double> arr, int target) {
		int n = arr.size()-1;
		if(target <= arr.get(0)) return arr.get(0);
		if(target >= arr.get(n)) return arr.get(n);
		int i =0, j = n, mid = 0;
		while(i<j) {
			mid = (i+j)/2;
			if(arr.get(mid) == target) return arr.get(mid);
			if(target < arr.get(mid)) {
				if(mid > 0 && target > arr.get(mid - 1)) return findClosest(arr.get(mid - 1), arr.get(mid), target);
				j = mid;
			}
			else {
				if(mid < n-1 && target < arr.get(mid + 1)) return findClosest(arr.get(mid), arr.get(mid + 1), target);
				i = mid + 1;
			}			
			}
		return arr.get(mid);
	}
	
	public static double findClosest(double val1, double val2, int target) {
		if(target - val1 >= val2 - target) return val2;
		else
			return val1;
	}

}
