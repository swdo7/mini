package global.sesoc.web6.dao;

import global.sesoc.web6.vo.CustomerVO;

public interface CustomerMapper {

	public int insertCustomer(CustomerVO vo);

	public CustomerVO searchCustomer(String searchId);

	public int updateCustomer(CustomerVO vo);

}
