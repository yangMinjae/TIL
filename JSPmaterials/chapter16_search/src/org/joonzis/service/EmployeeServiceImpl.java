package org.joonzis.service;

import java.util.List;
import java.util.Map;

import org.joonzis.dao.EmployeeDao;
import org.joonzis.dao.EmployeeDaoImpl;
import org.joonzis.vo.EmployeeVO;

public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDao dao = EmployeeDaoImpl.getInstance();
	@Override
	public List<EmployeeVO> getAll() {
		return dao.getAll();
	}
	public List<EmployeeVO> getDeptList(EmployeeVO vo){
		return dao.getDeptList(vo);
	}
	
	@Override
	public List<EmployeeVO> getDynamicList(Map<String, String> map) {
	
		return dao.getDynamicList(map);
	}
}
