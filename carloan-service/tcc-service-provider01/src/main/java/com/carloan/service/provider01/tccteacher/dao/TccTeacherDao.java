package com.carloan.service.provider01.tccteacher.dao;

import java.util.List;
import java.util.Map;

import com.carloan.service.provider01.tccteacher.dto.TccTeacherDTO;
import org.springframework.stereotype.Repository;

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
@Repository
public interface TccTeacherDao {
    public List<TccTeacherDTO> searchTccTeacherByPaging(Map<String, Object> searchParams) ;
    
    public List<TccTeacherDTO> searchTccTeacher(Map<String, Object> searchParams);

    public TccTeacherDTO findTccTeacherByPrimaryKey(String id);
    
    public int insertTccTeacher(Map<String, Object> paramMap);
    
    public void updateTccTeacher(Map<String, Object> paramMap);

    public TccTeacherDTO queryLikeTccTeacher(Map<String, Object> paramMap);

    
}
