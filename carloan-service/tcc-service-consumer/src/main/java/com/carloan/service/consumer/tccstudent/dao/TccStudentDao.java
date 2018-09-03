package com.carloan.service.consumer.tccstudent.dao;

import java.util.List;
import java.util.Map;

import com.carloan.service.consumer.tccstudent.dto.TccStudentDTO;
import org.springframework.stereotype.Component;
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
public interface TccStudentDao {
    public List<TccStudentDTO> searchTccStudentByPaging(Map<String, Object> searchParams) ;
    
    public List<TccStudentDTO> searchTccStudent(Map<String, Object> searchParams);

    public TccStudentDTO findTccStudentByPrimaryKey(String id);
    
    public int insertTccStudent(Map<String, Object> paramMap);
    
    public void updateTccStudent(Map<String, Object> paramMap);

    public TccStudentDTO queryLikeTccStudent(Map<String, Object> paramMap);

    
}
