package com.social.chenl.util;

import com.social.chenl.constant.Constant;

import java.util.List;
import java.util.Map;

public class PageUtil {

    /**
     * 分割分页法（数据量较大时慎用）
     *
     * @param list
     * @param pageNum
     * @return
     */
    public static List<Map> pageService(List<Map> list, Integer pageNum) {

        int count = 0;
        if (list != null && list.size() > 0) {
            count = list.size();
            int fromIndex = (pageNum - 1) * Constant.PAGESIZE;
            if (fromIndex > count) {
                return null;
            }
            int toIndex = pageNum * Constant.PAGESIZE;
            if (toIndex > count) {
                toIndex = count;
            }
            List<Map> pageList = list.subList(fromIndex, toIndex);

            return pageList;
        }
        return null;
    }

}
