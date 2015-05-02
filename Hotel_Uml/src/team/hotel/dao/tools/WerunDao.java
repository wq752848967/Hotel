package team.hotel.dao.tools;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class WerunDao {

	private  JdbcTemplate template;

	/**
	 * 锟斤拷锟街革拷锟斤拷锟斤拷锟斤拷欠锟斤拷锟斤拷某锟斤拷录
	 * 
	 * @param tableName
	 *            锟斤拷锟斤拷
	 * @param nameValues
	 *            锟街讹拷锟斤拷锟皆硷拷值锟侥硷拷锟斤拷
	 * @return 锟斤拷锟节凤拷锟斤拷true锟斤拷锟斤拷锟斤拷false
	 */
	public boolean checkTable(String tableName, NameValue... nameValues) {
		int rowCount = getRowCount(tableName, nameValues);
		return (rowCount == 0) ? false : true;
	}

	/**
	 * 锟斤拷询某锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟铰�
	 * 
	 * @param tableName
	 *            锟斤拷锟斤拷
	 * @param formClass
	 *            实锟斤拷锟斤拷锟絚lass锟斤拷
	 * @param nameValues
	 *            锟街讹拷锟斤拷锟皆硷拷值锟侥硷拷锟较ｏ拷锟斤拷锟斤拷锟轿拷眨锟斤拷头锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟叫的硷拷录
	 * @return List<Form>
	 */
	public List<?> getObjects(String tableName, Class<? extends Object> fromClass,
			NameValue... nameValues) {
		return getObjects(tableName, fromClass, null, 0, 0, nameValues);
	}

	/**
	 * 锟斤拷询某锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟铰�锟斤拷锟斤拷指锟斤拷锟斤拷锟侥革拷锟街讹拷锟斤拷锟津，第硷拷页锟斤拷锟皆硷拷页锟侥达拷小
	 * 
	 * @param tableName
	 *            锟斤拷锟斤拷
	 * @param fromClass
	 *            实锟斤拷锟斤拷锟絚lass锟斤拷
	 * @param orderBy
	 *            锟斤拷锟侥革拷锟街讹拷锟斤拷锟斤拷
	 * @param pageCount
	 *            锟节硷拷页
	 * @param pageSize
	 *            页锟斤拷锟叫�
	 * @param nameValues
	 *            锟街讹拷锟斤拷锟皆硷拷值锟侥硷拷锟斤拷
	 * @return List<Form>
	 */
	public List<?> getObjects(String tableName, Class<? extends Object> fromClass,
			String orderBy, int pageCount, int pageSize,
			NameValue... nameValues) {

		StringBuffer sql = null;
		Object[] args = null;

		sql = new StringBuffer("select * from " + tableName);

		if (nameValues != null) {

			sql.append(" where ");

			args = new Object[nameValues.length];

			getSqlAndArgs(sql, args, nameValues);

		}

		if (orderBy != null) {
			sql.append(" order by " + orderBy);
		}

		if (pageCount >= 0 && pageSize > 0) {
			sql.append(" limit " + pageCount * pageSize + "," + pageSize);
		}

		//System.out.println(sql);

		return template.query(sql.toString(), args, new BeanPropertyRowMapper(
				fromClass));
	}

	/**
	 * 锟斤拷询某锟斤拷锟斤拷锟斤拷锟铰硷拷锟斤拷锟斤拷锟�
	 * 
	 * @param tableName
	 *            锟斤拷锟斤拷
	 * @param nameValues
	 *            锟街讹拷锟斤拷锟皆硷拷值锟侥硷拷锟斤拷
	 * @return 锟斤拷录锟斤拷锟斤拷锟斤拷
	 */
	public int getRowCount(String tableName, NameValue... nameValues) {

		StringBuffer sql = null;
		Object[] args = null;

		if (nameValues != null) {

			sql = new StringBuffer("select count(0) from " + tableName
					+ " where ");

			args = new Object[nameValues.length];

			getSqlAndArgs(sql, args, nameValues);

		} else {
			sql = new StringBuffer("select count(0) from " + tableName);
		}

		return template.queryForInt(sql.toString(), args);
	}

	/**
	 * 锟斤拷询一锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟侥筹拷锟斤拷锟铰硷拷锟斤拷锟斤拷锟斤拷芸隙锟斤拷锟饺★拷锟斤拷锟斤拷锟斤拷锟揭伙拷锟斤拷锟铰硷拷锟斤拷锟斤拷锟斤拷锟斤拷锟絀D锟斤拷user
	 * 
	 * @param tableName
	 *            锟斤拷锟斤拷
	 * @param formClass
	 *            实锟斤拷锟斤拷锟絚lass锟斤拷
	 * @param nameValues
	 *            锟街讹拷锟斤拷锟皆硷拷值锟侥硷拷锟较ｏ拷锟斤拷锟斤拷锟轿拷眨锟斤拷头锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟叫的硷拷录
	 * @return Form
	 */
	public Object getSingleObject(String tableName,
			Class<? extends Object> fromClass, NameValue... nameValues) {
		if(getObjects(tableName, fromClass, nameValues).isEmpty()){
			System.out.println("zou-zhe-li");
			return null;
		}
		else
			return getObjects(tableName, fromClass, nameValues).get(0);
	}

	/**
	 * 锟斤拷锟斤拷锟斤拷锟斤拷某锟斤拷锟斤拷
	 * 
	 * @param tableName
	 *            锟斤拷锟斤拷
	 * @param columnName
	 *            锟斤拷要锟斤拷询锟侥憋拷锟斤拷锟斤拷锟斤拷侄锟斤拷锟斤拷锟絬ser锟斤拷锟斤拷锟絠d
	 * @param nameValues
	 *            锟斤拷询锟斤拷锟斤拷
	 * @param requiredType
	 *            希锟斤拷锟斤拷锟斤拷锟斤拷值锟斤拷锟斤拷锟酵ｏ拷锟斤拷锟窖疘D锟斤拷锟斤拷Integer.class
	 * @return
	 */
	public Object getTableColumn(String tableName, String columnName,
			Class requiredType, NameValue... nameValues) {
		List<?> list = getTableColumns(tableName, columnName, requiredType,
				nameValues);
		if (list == null || list.size() == 0) {
			if (requiredType == Integer.class) {
				return -1;
			} else {
				return null;
			}
		}
		return getTableColumns(tableName, columnName, requiredType, nameValues)
				.get(0);
	}

	/**
	 * 锟斤拷锟斤拷锟斤拷锟斤拷某锟斤拷锟斤拷
	 * 
	 * @param tableName
	 *            锟斤拷锟斤拷
	 * @param columnName
	 *            锟斤拷要锟斤拷询锟侥憋拷锟斤拷锟斤拷锟斤拷侄锟斤拷锟斤拷锟絬ser锟斤拷锟斤拷锟絠d
	 * @param nameValues
	 *            锟斤拷询锟斤拷锟斤拷
	 * @param requiredType
	 *            希锟斤拷锟斤拷锟斤拷锟斤拷值锟斤拷锟斤拷锟酵ｏ拷锟斤拷锟窖疘D锟斤拷锟斤拷Integer.class
	 * @return
	 */
	public List<?> getTableColumns(String tableName, String columnName,
			Class requiredType, NameValue... nameValues) {

		StringBuffer sql = new StringBuffer("select " + columnName + " from "
				+ tableName + " where ");

		Object[] args = new Object[nameValues.length];

		getSqlAndArgs(sql, args, nameValues);

		return template.queryForList(sql.toString(), args, requiredType);

	}

	/**
	 * 锟斤拷锟街革拷锟斤拷锟斤拷锟侥筹拷锟斤拷锟铰硷拷锟絠d
	 * 
	 * @param tableName
	 *            锟斤拷锟斤拷
	 * @param nameValues
	 *            锟街讹拷锟斤拷锟皆硷拷值锟侥硷拷锟斤拷
	 * @return 某锟斤拷录锟斤拷id
	 */
	public int getTableId(String tableName, NameValue... nameValues) {
		return (Integer) getTableColumn(tableName, "id", Integer.class,
				nameValues);
	}

	

	/**
	 * 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�锟斤拷1锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟叫碉拷锟斤拷锟斤拷锟轿拷眨锟斤拷锟斤拷锟斤拷锟揭拷锟斤拷锟�锟斤拷2锟斤拷锟斤拷锟斤拷谋锟斤拷锟斤拷锟斤拷锟斤拷id锟斤拷锟斤拷为锟斤拷锟斤拷
	 * 
	 * @param tableName
	 *            锟斤拷锟斤拷
	 * @param nameValues
	 *            锟斤拷询锟斤拷锟斤拷
	 * @return 锟斤拷锟斤拷锟斤拷锟斤拷锟�
	 */
	public int insert(String tableName, NameValue... nameValues) {

		StringBuffer sql = new StringBuffer("insert into " + tableName.toLowerCase() + "(");
		Object[] args = new Object[nameValues.length];

		getInsertSqlAndArgs(sql, args, nameValues);
		
		if(template==null)
		{
			System.out.println("*-  null");
			
		}
        
		return template.update(sql.toString(), args);
				

	}

	/**
	 * 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�锟斤拷1锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟叫碉拷锟斤拷锟斤拷锟轿拷眨锟斤拷锟斤拷锟斤拷锟揭拷锟斤拷锟�锟斤拷2锟斤拷锟斤拷锟斤拷谋锟斤拷锟斤拷锟斤拷锟斤拷id锟斤拷锟斤拷为锟斤拷锟斤拷
	 * 
	 * @param object
	 *            form锟斤拷锟斤拷
	 * @return
	 */
	public int addObject(Object form) {
		return operateObject("add", form);
	}

	/**
	 * 锟斤拷锟铰憋拷锟斤拷锟斤拷,锟斤拷锟斤拷锟斤拷锟斤拷系锟酵碉拷锟斤拷锟斤拷锟角匡拷锟揭拷锟斤拷锟斤拷前锟斤拷锟揭猻et锟斤拷NameValue写锟斤拷where前锟芥，锟斤拷锟斤拷锟斤拷锟斤拷
	 * 
	 * @param tableName
	 *            锟斤拷锟斤拷
	 * @param nameValues
	 *            锟街讹拷锟斤拷锟皆硷拷值锟侥硷拷锟斤拷
	 * @return 影锟斤拷锟斤拷锟斤拷锟�
	 */
	public int update(String tableName, NameValue... nameValues) {

		StringBuffer sql = new StringBuffer("update " + tableName + " set ");
		Object[] args = new Object[nameValues.length];

		getUpdateSqlAndArgs(sql, args, nameValues);

		return template.update(sql.toString(), args);

	}

	/**
	 * 锟斤拷锟铰讹拷锟斤拷 锟斤拷1锟斤拷锟斤拷锟斤拷指锟斤拷Id锟斤拷锟斤拷锟斤拷锟揭诧拷知锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟截凤拷
	 * 锟斤拷2锟斤拷锟斤拷一锟姐不锟矫ｏ拷锟斤拷锟斤拷锟斤拷锟斤拷侄伪锟斤拷锟揭拷锟斤拷锟斤拷锟饺凤拷锟斤拷锟斤拷锟斤拷貌锟斤拷芗锟皆︼拷锟斤拷锟斤拷锟酵拷锟絬pdate锟斤拷锟斤拷锟斤拷
	 * 
	 * @param object
	 *            form锟斤拷锟斤拷
	 * @return
	 */
	public int updateObject(Object form) {
		return operateObject("update", form);
	}

	@SuppressWarnings("unchecked")
	private int operateObject(String operateType, Object form) {

		Class clazz = form.getClass();

		String tableName = clazz.getSimpleName();// 锟矫碉拷from锟斤拷锟斤拷锟斤拷

		Field[] fields = form.getClass().getDeclaredFields();// 锟矫碉拷form锟斤拷锟斤拷锟斤拷锟叫碉拷私锟斤拷锟斤拷锟斤拷

		List<NameValue> nameValueList = new ArrayList<NameValue>();

		for (int i = 0; i < fields.length; i++) {

			try {

				String name = fields[i].getName();

				String getMethodName = "get"
						+ name.substring(0, 1).toUpperCase()
						+ name.substring(1);

				Method method = clazz.getMethod(getMethodName, null);

				Object value = method.invoke(form, null);

				if (value != null) {

					if ("add".equals(operateType)) {
						if (!"id".equals(name)) {
							nameValueList.add(new NameValue(name, value));
						}
					}

					if ("update".equals(operateType)) {

						if ("id".equals(name)) {// id锟街讹拷锟斤拷where锟接撅拷锟叫ｏ拷锟斤拷锟斤拷锟斤拷锟絪et锟接撅拷锟斤拷
							nameValueList.add(new NameValue(name, value));
						} else {
							nameValueList.add(new NameValue(name, value,
									NameValue.TYPE_SET));
						}

					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		/*
		 * 锟斤拷锟斤拷一锟斤拷没锟叫办法锟侥办法锟斤拷锟揭碉拷update锟斤拷锟斤拷锟斤拷锟斤拷要锟斤拷set锟斤拷锟斤拷锟斤拷要锟斤拷前锟芥，锟斤拷锟斤拷锟斤拷ID锟斤拷where锟接撅拷锟斤拷锟芥，锟斤拷锟斤拷锟揭碉拷转锟斤拷List锟斤拷锟斤拷id弄锟斤拷锟剿猴拷锟斤拷
		 */
		Collections.reverse(nameValueList);

		NameValue[] nameValues = new NameValue[nameValueList.size()];

		nameValueList.toArray(nameValues);// 锟斤拷List转为锟斤拷锟斤拷

		if ("add".equals(operateType)) {
			return insert(tableName, nameValues);
		}

		if ("update".equals(operateType)) {
			return update(tableName, nameValues);
		}

		return 0;
	}

	/**
	 * 删锟斤拷锟斤拷锟斤拷锟�锟斤拷锟缴撅拷锟侥憋拷锟斤拷锟斤拷锟斤拷锟侥�锟斤拷删锟斤拷锟斤拷锟斤拷锟斤拷锟矫硷拷锟斤拷删锟斤拷锟�
	 * 
	 * @param tableName
	 *            锟斤拷锟斤拷
	 * @param nameValues
	 *            锟街讹拷锟斤拷锟皆硷拷值锟侥硷拷锟斤拷
	 * @return 影锟斤拷锟斤拷锟斤拷锟�
	 */
	public int delete(String tableName, NameValue... nameValues) {

		StringBuffer sql = new StringBuffer("delete from " + tableName
				+ " where ");
		Object[] args = new Object[nameValues.length];

		getSqlAndArgs(sql, args, nameValues);

		return template.update(sql.toString(), args);

	}

	public JdbcTemplate getTemplate() {
		return template;
	}


	public void setTemplate(JdbcTemplate template) {
		System.out.println(" setTemp");
		this.template = template;
	}
	 public void setDataSource(DataSource ds) {  
		 System.out.println(" setSource");
	        this.template = new JdbcTemplate(ds);  
	    }
	// 锟斤拷锟斤拷insert锟斤拷锟斤拷锟斤拷sql锟斤拷锟酵诧拷锟斤拷
	private void getInsertSqlAndArgs(StringBuffer sql, Object[] args,
			NameValue... nameValues) {

		for (int i = 0; i < nameValues.length; i++) {
			sql.append(nameValues[i].getName() + ",");
			args[i] = nameValues[i].getValue();
		}
		sql.delete(sql.length() - ",".length(), sql.length());// 锟斤拷末尾锟斤拷 , 锟斤拷锟�

		sql.append(") values (");

		for (int i = 0; i < nameValues.length; i++) {
			sql.append("?,");
		}
		sql.delete(sql.length() - ",".length(), sql.length());// 锟斤拷末尾锟斤拷 , 锟斤拷锟�

		sql.append(")");

		//System.out.println(sql);
	}

	// 锟斤拷锟斤拷update锟斤拷锟斤拷锟斤拷sql锟斤拷锟酵诧拷锟斤拷
	private void getUpdateSqlAndArgs(StringBuffer sql, Object[] args,
			NameValue[] nameValues) {

		for (int i = 0; i < nameValues.length; i++) {

			if (nameValues[i].getType().equals(NameValue.TYPE_SET)) {// 锟斤拷锟斤拷锟街讹拷锟斤拷锟斤拷要锟睫改碉拷
				sql.append(nameValues[i].getName() + "=?,");
				if (i + 1 == nameValues.length
						|| !nameValues[i + 1].getType().equals(
								NameValue.TYPE_SET)) {// 锟斤拷锟斤拷锟揭伙拷锟斤拷侄尾锟斤拷锟揭拷薷牡模锟斤拷锟斤拷锟矫伙拷锟斤拷锟揭伙拷锟斤拷侄锟斤拷恕锟斤拷锟斤拷锟斤拷锟�
					sql.delete(sql.length() - ",".length(), sql.length());// 锟斤拷末尾锟侥ｏ拷
					// 锟斤拷锟�
					if (i + 1 != nameValues.length) {// 锟斤拷锟斤拷锟絯here锟接撅拷
						sql.append(" where ");
					}
				}
			} else {
				sql.append(nameValues[i].getName() + "=? and ");
				if (i + 1 == nameValues.length) {
					sql.delete(sql.length() - " and ".length(), sql.length());// 锟斤拷末尾锟斤拷and锟斤拷锟�
				}
			}

			args[i] = nameValues[i].getValue();
		}

		//System.out.println(sql);
	}

	// 锟斤拷锟斤拷锟窖拷锟斤拷锟斤拷锟絪ql锟斤拷锟酵诧拷锟斤拷
	private void getSqlAndArgs(StringBuffer sql, Object[] args,
			NameValue... nameValues) {

		boolean hasOrflag = false;// 锟角凤拷锟斤拷or锟接撅拷

		for (int i = 0; i < nameValues.length; i++) {
			if (NameValue.TYPE_LIKE.equals(nameValues[i].getType())) {// like锟接撅拷
				sql.append(nameValues[i].getName() + " like ? and ");
			}
			if (NameValue.TYPE_WHERE.equals(nameValues[i].getType())) {// where锟接撅拷
				sql.append(nameValues[i].getName() + "=? and ");
			}

			if (hasOrflag == false
					&& i + 1 < nameValues.length
					&& NameValue.TYPE_WHERE_OR.equals(nameValues[i + 1]
							.getType())) {//锟斤拷or锟斤拷时锟斤拷锟斤拷要锟窖猴拷锟斤拷募锟斤拷锟給r锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
				sql.append("(");
				hasOrflag = true;

			}
			if (NameValue.TYPE_WHERE_OR.equals(nameValues[i].getType())) {// or锟接撅拷
				sql.append(nameValues[i].getName() + "=? or ");
			}
			if (hasOrflag == true && i + 1 == nameValues.length) {//锟斤拷or锟接撅拷锟绞憋拷锟角得帮拷锟斤拷锟脚硷拷锟斤拷				
				sql.delete(sql.length() - " or ".length(), sql.length());// 锟斤拷末尾锟斤拷 or 锟斤拷锟�
				sql.append(") and ");
				
			}

			args[i] = nameValues[i].getValue();
		}

		sql.delete(sql.length() - " and ".length(), sql.length());// 锟斤拷末尾锟斤拷 and 锟斤拷锟�

		//System.out.println(sql);
	}

}
