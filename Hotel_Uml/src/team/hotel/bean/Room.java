package team.hotel.bean;

/*
 * 房间bean
 * 
 * 
 * */
public class Room {

	private int id;
	/*
	 * 房间的状态
	 * 0不可住
	 * 1可入住
	 * 2被预定
	 * 3清理当中
	 * 4待添加
	 * */
	private int roomState;
	/*
	 * 房间的类型
	 * 0普通单间（单床）
	 * 1标间（两个单人床）
	 * 2大床房（单个双人床）
	 * 3家庭间（一单人床 一双人床）
	 * 4四人间（四单人床）
	 * 5待添加
	 * */
	private int roomType;
    /*
     * 房间所能容纳的人数
     * 整数
     * */
	private int roomSize;
	/*
	 * 房间电话号码
	 *
	 * */
	private String roomPhone =  null;
	/*
	 * 房间号码
	 * 如：1-134B
	 * 一楼134B房间
	 * */
	private String roomNum = null;
	/*
	 * 房间的基本消费
	 * 租用房间的花费
	 * */
	private double roomNomalCost;
	/*
	 * 房间的额外消费
	 * 
	 * */
	private double roomConsumeCost;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoomState() {
		return roomState;
	}
	public void setRoomState(int roomState) {
		this.roomState = roomState;
	}
	public int getRoomType() {
		return roomType;
	}
	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}
	public int getRoomSize() {
		return roomSize;
	}
	public void setRoomSize(int roomSize) {
		this.roomSize = roomSize;
	}
	public String getRoomPhone() {
		return roomPhone;
	}
	public void setRoomPhone(String roomPhone) {
		this.roomPhone = roomPhone;
	}
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public double getRoomNomalCost() {
		return roomNomalCost;
	}
	public void setRoomNomalCost(double roomNomalCost) {
		this.roomNomalCost = roomNomalCost;
	}
	public double getRoomConsumeCost() {
		return roomConsumeCost;
	}
	public void setRoomConsumeCost(double roomConsumeCost) {
		this.roomConsumeCost = roomConsumeCost;
	}
	
}