package team.hotel.dao.tools;

/**
 * werunDao里面使用的辅助类
 * @author yellowbaby
 *
 */
public class NameValue {
	
	public  final static String TYPE_WHERE = "where";  
	public final static String TYPE_SET = "set";  
	public final static String TYPE_LIKE = "like";  
	public final static String TYPE_WHERE_OR = "or";
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 值
	 */
	private Object value;
	
	
	/**
	 * 指定查询类型，现在有where，set，like,or四种
	 * where 用在where子句中的  where userId = ?
	 * set 用在update子句中的update set userId = ?
	 * like用在where子句里面的 where userId like %%
	 * or 用在where子句的末尾  (placeId = 3  or placeId = 4)  切记，带有or子句的必须大于两个，而且需要放在整个句子的末尾
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
