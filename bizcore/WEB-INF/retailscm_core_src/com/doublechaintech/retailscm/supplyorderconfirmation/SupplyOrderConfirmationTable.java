
package com.doublechaintech.retailscm.supplyorderconfirmation;
import com.doublechaintech.retailscm.AccessKey;


public class SupplyOrderConfirmationTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="supply_order_confirmation_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_WHO = "who";
	static final String COLUMN_CONFIRM_TIME = "confirm_time";
	static final String COLUMN_VERSION = "version";
 
<<<<<<< HEAD
	public static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_WHO, COLUMN_CONFIRM_TIME, 
		COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {
		COLUMN_WHO, COLUMN_CONFIRM_TIME
		};
=======
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_WHO,COLUMN_CONFIRM_TIME,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_WHO,COLUMN_CONFIRM_TIME};
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
	
	
}


