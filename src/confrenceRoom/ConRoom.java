package confrenceRoom;

import java.util.ArrayList;
import java.util.Arrays;

public class ConRoom {
	private double roomInfo;
	private int maxNum;
	private int[][] openTime;
	private boolean picked;
	public ConRoom(double roomInfo, int maxNum, int[][] openTime) {
		this.roomInfo = roomInfo;
		this.maxNum = maxNum;
		this.openTime = openTime;
		this.picked = false;
	}
	public boolean isPicked() {
		return picked;
	}
	public void setPicked(boolean picked) {
		this.picked = picked;
	}
	public double getRoomInfo() {
		return roomInfo;
	}
	public void setRoomInfo(double roomInfo) {
		this.roomInfo = roomInfo;
	}
	public int getMaxNum() {
		return maxNum;
	}
	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}
	public int[][] getOpenTime() {
		return openTime;
	}
	public void setOpenTime(int[][] openTime) {
		this.openTime = openTime;
	}
	@Override
	public String toString() {
		return "ConRoom [roomInfo=" + roomInfo + ", maxNum=" + maxNum + ", openTime=" + Arrays.toString(openTime) + "]";
	}
	
}
