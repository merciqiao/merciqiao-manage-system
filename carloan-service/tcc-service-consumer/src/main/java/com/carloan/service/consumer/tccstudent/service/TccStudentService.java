
package com.carloan.service.consumer.tccstudent.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.tcc.TccCourse;
import com.carloan.apimodel.tcc.TccTeacher;
import com.carloan.feign.tcc.TccCourseServicefeign;
import com.carloan.feign.tcc.TccTeacherServicefeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.carloan.service.consumer.tccstudent.dto.TccStudentDTO;
import com.carloan.service.consumer.tccstudent.dao.TccStudentDao;
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

/**
 * @classname: TccStudentService
 * @description: 定义  tcc_student 实现类
 * @author: root
 */
@Service
public class TccStudentService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private TccStudentDao dao;
    @Autowired
    TccTeacherServicefeign tccTeacherServicefeign;
    @Autowired
    TccCourseServicefeign tccCourseServicefeign;

    public List<TccStudentDTO> searchTccStudentByPaging(Map<String, Object> searchParams) throws Exception {
        List<TccStudentDTO> dataList = dao.searchTccStudentByPaging(searchParams);
        return dataList;
    }

    public List<TccStudentDTO> searchTccStudent(TccStudentDTO dto) throws Exception {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("dto", dto);
        List<TccStudentDTO> dataList = dao.searchTccStudent(paramMap);
        return dataList;
    }

    public TccStudentDTO queryTccStudentByPrimaryKey(String id) throws Exception {
        TccStudentDTO dto = dao.findTccStudentByPrimaryKey(id);
        if (dto == null) dto = new TccStudentDTO();
        return dto;

    }

    @SuppressWarnings("all")
    @Transactional(rollbackFor = {Exception.class})
    public int insertTccStudent(TccStudentDTO dto) throws Exception {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("dto", dto);
        int count = dao.insertTccStudent(paramMap);
        TccStudentDTO resultDto = (TccStudentDTO) paramMap.get("dto");
        int keyId = resultDto.getId();
        return keyId;
    }
    @Transactional(rollbackFor = {Exception.class})
    public void updateTccStudent(TccStudentDTO dto) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("dto", dto);
        dao.updateTccStudent(paramMap);
    }

    public TccStudentDTO queryLikeTccStudent(TccStudentDTO dto) throws Exception {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("dto", dto);
        return dao.queryLikeTccStudent(paramMap);
    }

    @Transactional(rollbackFor = {Exception.class})
    public boolean update(TccStudentDTO obj) throws Exception {
        ResponseResult result = new ResponseResult();
        obj=new TccStudentDTO();
        obj.setId(1);
        obj.setCreatetime(new Date());
        this.updateTccStudent(obj);

        TccTeacher tccTeacher=new TccTeacher();
        tccTeacher.setId(1);
        tccTeacher.setCreatetime(new Date());
        ResponseResult result1= tccTeacherServicefeign.updateTccTeacher(tccTeacher);

        TccCourse tccCourse=new TccCourse();
        tccCourse.setId(1);
        tccCourse.setCreatetime(new Date());
        ResponseResult result2=tccCourseServicefeign.updateTccCourse(tccCourse);
        if(!ResponseResult.isSucess(result2)){
            throw new Exception("接口2异常");
        }
        result.setStatus(Status.SUCCESS);
        result.setMessage("修改成功");
        throw new Exception("rest调用回滚异常");
        //return result;
    }

}

