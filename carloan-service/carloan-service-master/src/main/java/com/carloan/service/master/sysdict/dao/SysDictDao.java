package com.carloan.service.master.sysdict.dao;

import com.carloan.service.master.sysdict.dto.SysDictDTO;

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
public interface SysDictDao {
    public List<SysDictDTO> searchSysDictByPaging(Map<String, Object> searchParams) ;
    
    public List<SysDictDTO> searchSysDict(Map<String,Object> searchParams);

    public SysDictDTO findSysDictByPrimaryKey(String id);
    
    public int insertSysDict(Map<String, Object> paramMap);
    
    public void updateSysDict(Map<String, Object> paramMap);

    public SysDictDTO queryLikeSysDict(Map<String, Object> paramMap);

    public int getCount(String dictCode);
}
