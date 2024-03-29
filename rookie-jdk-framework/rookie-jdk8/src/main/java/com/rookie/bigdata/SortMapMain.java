package com.rookie.bigdata;

import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Classname SortMapMain
 * @Description https://www.zhangbj.com/p/143.html
 * @Author rookie
 * @Date 2023/1/30 18:04
 * @Version 1.0
 */
public class SortMapMain {

    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<>();
        map.put("xxx", "你好");
        map.put("aaa", "hell world");
        String str = map.entrySet().stream().map(entry -> entry.getKey() + "=" + entry.getValue()).collect(Collectors.joining("&"));
        System.out.println(str);

        String s = formatUrlMap(map, false, false);
        System.out.println(s);
    }


    public static String formatUrlMap(Map<String, String> paraMap, boolean urlEncode, boolean keyToLower) {
        String buff;
        try {
            List<Map.Entry<String, String>> infoIds = new ArrayList<>(paraMap.entrySet());
            // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
            Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>() {

                @Override
                public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                    return (o1.getKey()).compareTo(o2.getKey());
                }
            });

            // 构造URL 键值对的格式
            StringBuilder buf = new StringBuilder();
            for (Map.Entry<String, String> item : infoIds) {
                if (!"".equals(item.getKey())) {
                    String key = item.getKey();
                    String val = item.getValue();
                    if (urlEncode) {
                        val = URLEncoder.encode(val, "utf-8");
                    }
                    if (keyToLower) {
                        buf.append(key.toLowerCase()).append("=").append(val);
                    } else {
                        buf.append(key).append("=").append(val);
                    }
                    buf.append("&");
                }
            }
            if (buf.length() > 0) {
                buf.deleteCharAt(buf.length() - 1);
            }

            buff = buf.toString();
//         if (!buff.isEmpty()) {
//            buff = buff.substring(0, buff.length() - 1);
//        }
        } catch (Exception e) {
            return null;
        }
        return buff;
    }

}
