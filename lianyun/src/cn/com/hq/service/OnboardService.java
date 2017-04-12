package cn.com.hq.service;

import java.util.List;

import cn.com.hq.entity.Account;
import cn.com.hq.entity.OnboardInfo;
import cn.com.hq.vo.OnboardInfoVO;

public interface OnboardService {

	public void addOnboardInfo(OnboardInfo b);

	public List<OnboardInfoVO> queryAllOnboardInfo();

	public void modifyOnboardInfo(OnboardInfo b);

}
