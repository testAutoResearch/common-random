package com.apifan.common.random.source;

import com.apifan.common.random.util.ResourceUtils;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 教育信息数据源
 *
 * @author yin
 */
public class EducationSource {
    private static final Logger logger = LoggerFactory.getLogger(EducationSource.class);

    /**
     * 教育程度
     */
    private static final List<String> degreeList = Lists.newArrayList("小学", "初中", "中专/职业高中", "高中", "大学专科", "大学本科", "硕士", "博士");
    private static final EducationSource instance = new EducationSource();
    private List<String> collegeList;

    private EducationSource() {
        collegeList = ResourceUtils.readLines("college.txt");
    }

    /**
     * 获取唯一实例
     *
     * @return 实例
     */
    public static EducationSource getInstance() {
        return instance;
    }

    /**
     * 获取下一条随机高校名称
     *
     * @return 下一条随机高校名称
     */
    public String randomCollege() {
        return ResourceUtils.getRandomElement(collegeList);
    }

    /**
     * 获取随机学历
     *
     * @return 随机学历
     */
    public String randomDegree() {
        return ResourceUtils.getRandomElement(degreeList);
    }
}
