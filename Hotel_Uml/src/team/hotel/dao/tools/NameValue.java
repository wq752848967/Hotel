package team.hotel.dao.tools;

/**
 * werunDao����ʹ�õĸ�����
 * @author yellowbaby
 *
 */
public class NameValue {
	
	public  final static String TYPE_WHERE = "where";  
	public final static String TYPE_SET = "set";  
	public final static String TYPE_LIKE = "like";  
	public final static String TYPE_WHERE_OR = "or";
	
	/**
	 * ����
	 */
	private String name;
	
	/**
	 * ֵ
	 */
	private Object value;
	
	
	/**
	 * ָ����ѯ���ͣ�������where��set��like,or����
	 * where ����where�Ӿ��е�  where userId = ?
	 * set ����update�Ӿ��е�update set userId = ?
	 * like����where�Ӿ������ where userId like %%
	 * or ����where�Ӿ��ĩβ  (placeId = 3  or placeId = 4)  �мǣ�����or�Ӿ�ı������������������Ҫ�����������ӵ�ĩβ
	 */
	private String type = TYPE_WHERE;
	
	public NameValue(String name, Object value) {
		this.name = name;
		this.value = value;
	}
	
	public NameValue(String name, Object value,String type) {
		this.name = name;
		this.value = value;
		this.type = type;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
}
