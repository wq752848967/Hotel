package team.hotel.bean;

/*
 * ����bean
 * 
 * 
 * */
public class Room {

	private int id;
	/*
	 * �����״̬
	 * 0����ס
	 * 1����ס
	 * 2��Ԥ��
	 * 3������
	 * 4�����
	 * */
	private int roomState;
	/*
	 * ���������
	 * 0��ͨ���䣨������
	 * 1��䣨�������˴���
	 * 2�󴲷�������˫�˴���
	 * 3��ͥ�䣨һ���˴� һ˫�˴���
	 * 4���˼䣨�ĵ��˴���
	 * 5�����
	 * */
	private int roomType;
    /*
     * �����������ɵ�����
     * ����
     * */
	private int roomSize;
	/*
	 * ����绰����
	 *
	 * */
	private String roomPhone =  null;
	/*
	 * �������
	 * �磺1-134B
	 * һ¥134B����
	 * */
	private String roomNum = null;
	/*
	 * ����Ļ�������
	 * ���÷���Ļ���
	 * */
	private double roomNomalCost;
	/*
	 * ����Ķ�������
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