package jp.co.drm.ccp.web.presentation.domain;

import java.io.Serializable;

import com.gh.mygreen.xlsmapper.annotation.XlsColumn;



//Record class
public class UserRecord implements Serializable{

 @XlsColumn(columnName="ID")
 private int no;

 @XlsColumn(columnName="Class", merged=true)
 private String className;

 @XlsColumn(columnName="Name")
 private String name;

 @XlsColumn(columnName="Gender")
 private Gender gender;

public int getNo() {
	return no;
}

public void setNo(int no) {
	this.no = no;
}

public String getClassName() {
	return className;
}

public void setClassName(String className) {
	this.className = className;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Gender getGender() {
	return gender;
}

public void setGender(Gender gender) {
	this.gender = gender;
}



}
