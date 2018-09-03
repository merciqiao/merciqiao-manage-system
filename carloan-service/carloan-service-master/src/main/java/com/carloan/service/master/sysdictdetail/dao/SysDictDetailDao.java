package com.carloan.service.master.sysdictdetail.dao;

import com.carloan.service.master.sysdictdetail.dto.SysDictDetailDTO;

import java.util.List;
import java.util.Map;
/*
                          _ooOoo_
                         o8888888o
                         88" . "88
                         (| -_- |)
                         O\  =  /O
                      ____/`---'\____
                    .'  \\|     |//  `.
                   /  \\|||  :  |||//  \
                  /  _||||| -:- |||||-  \
                  |   | \\\  -  /// |   |
                  | \_|  ''\---/''  |   |
                  \  .-\__  `-`  ___/-. /
                ___`. .'  /--.--\  `. . __
             ."" '<  `.___\_<|>_/___.'  >'"".
            | | :  `- \`.;`\ _ /`;.`/ - ` : | |
            \  \ `-.   \_ __\ /__ _/   .-` /  /
       ======`-.____`-.___\_____/___.-`____.-'======
                          `=---='
       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                佛祖保佑       永无BUG
*/
public interface SysDictDetailDao {
    public List<SysDictDetailDTO> searchSysDictDetailByPaging(Map<String, Object> searchParams) ;
    
    public List<SysDictDetailDTO> searchSysDictDetail(Map<String, Object> searchParams);

    public SysDictDetailDTO findSysDictDetailByPrimaryKey(String id);
    
    public int insertSysDictDetail(Map<String, Object> paramMap);
    
    public void updateSysDictDetail(Map<String, Object> paramMap);

    public SysDictDetailDTO queryLikeSysDictDetail(Map<String, Object> paramMap);

    public List<SysDictDetailDTO> searchCodeSysDictDetail(String code);


}
