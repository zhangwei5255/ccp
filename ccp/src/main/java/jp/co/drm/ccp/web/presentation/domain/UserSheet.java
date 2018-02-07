package jp.co.drm.ccp.web.presentation.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.gh.mygreen.xlsmapper.annotation.LabelledCellType;
import com.gh.mygreen.xlsmapper.annotation.OverRecordOperate;
import com.gh.mygreen.xlsmapper.annotation.XlsDateConverter;
import com.gh.mygreen.xlsmapper.annotation.XlsHorizontalRecords;
import com.gh.mygreen.xlsmapper.annotation.XlsLabelledCell;
import com.gh.mygreen.xlsmapper.annotation.XlsSheet;

//POJO for mapping sheet.
@XlsSheet(name="List")
public class UserSheet implements Serializable{

 @XlsLabelledCell(label="Date", type=LabelledCellType.Right)
 @XlsDateConverter(excelPattern="yyyy/m/d")
 private Date createDate;

 @XlsHorizontalRecords(tableLabel="User List", overRecord=OverRecordOperate.Insert)
 private List<UserRecord> users;

public Date getCreateDate() {
	return createDate;
}

public void setCreateDate(Date createDate) {
	this.createDate = createDate;
}

public List<UserRecord> getUsers() {
	return users;
}

public void setUsers(List<UserRecord> users) {
	this.users = users;
}



}
