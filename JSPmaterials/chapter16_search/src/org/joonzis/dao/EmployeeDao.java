package org.joonzis.dao;

import java.util.List;
import java.util.Map;

import org.joonzis.vo.EmployeeVO;

public interface EmployeeDao {
	public List<EmployeeVO> getAll();
	public List<EmployeeVO> getDeptList(EmployeeVO vo);
	public List<EmployeeVO> getDynamicList(Map<String, String> map);
}
