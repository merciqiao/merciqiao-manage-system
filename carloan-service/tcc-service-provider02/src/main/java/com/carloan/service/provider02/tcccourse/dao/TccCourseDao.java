package com.carloan.service.provider02.tcccourse.dao;

import java.util.List;
import java.util.Map;

import com.carloan.service.provider02.tcccourse.dto.TccCourseDTO;
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
public interface TccCourseDao {
    public List<TccCourseDTO> searchTccCourseByPaging(Map<String, Object> searchParams) ;
    
    public List<TccCourseDTO> searchTccCourse(Map<String, Object> searchParams);

    public TccCourseDTO findTccCourseByPrimaryKey(String id);
    
    public int insertTccCourse(Map<String, Object> paramMap);
    
    public void updateTccCourse(Map<String, Object> paramMap);

    public TccCourseDTO queryLikeTccCourse(Map<String, Object> paramMap);

    
}
