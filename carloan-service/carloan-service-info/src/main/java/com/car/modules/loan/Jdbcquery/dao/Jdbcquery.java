package com.car.modules.loan.Jdbcquery.dao;

import java.util.Map;

public interface Jdbcquery {
	public Map<String,String> getQueryMap(Map<String, Object> searchParams);
	public Long getsysOrgID(String Orgname);
	public int getCountQuery(Map<String, Object> paramMap);


}
