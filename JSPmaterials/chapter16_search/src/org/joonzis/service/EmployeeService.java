package org.joonzis.service;

import java.util.List;
import java.util.Map;

import org.joonzis.vo.EmployeeVO;

public interface EmployeeService {
	public List<EmployeeVO> getAll();
	public List<EmployeeVO> getDeptList(EmployeeVO vo);
	public List<EmployeeVO> getDynamicList(Map<String, String> map);
}
