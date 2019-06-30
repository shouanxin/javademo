/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/5/4 13:21.
 */

package Utils;

import bean.PostCommentRequest;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.poi.ss.formula.functions.BaseNumberUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

/**
 * 〈〉.
 *
 * @author: shouanxin
 * @date: 2019/5/4
 */
public class ExcelUtils {

    /**
     * 功能描述:
     * 〈将excel转换成user对象〉
     * PostCommentRequest postCommentRequest = new PostCommentRequest();
     *             postCommentRequest.setItemScore(StringUtil.objectToInt(mark, 0));
     *             postCommentRequest.setLogisticsScore(StringUtil.objectToInt(mark_speed, 0));
     *             postCommentRequest.setOrderNo(orderNo);
     *             postCommentRequest.setItemList(Lists.newArrayList());
     *             // 处理订单标签
     *             Map<String, Integer> map = JSONObject.parseObject(product_eval, Map.class);
     *             for (String sku : map.keySet()) {
     *             	String name = goodsNameMap.get(sku);
     *                 int skuScore = map.get(sku);
     *                 PostCommentItemRequest itemRequest = new PostCommentItemRequest();
     *                 itemRequest.setContent(comment);
     *                 itemRequest.setSku(sku);
     *                 itemRequest.setGoodsName(name);
     *                 itemRequest.setType(skuScore);
     *                 itemRequest.setTagList(tagList);
     *                 postCommentRequest.getItemList().add(itemRequest);
     *             }
     * @param datas
     * @return: java.util.List<com.missfresh.mis.admin.domain.param.MisAdminUserParam>
     * @author: shouanxin
     * @date : 2018/8/14 14:11
     */
    public static List<PostCommentRequest> excelToBean(byte[] datas) {
        InputStream inputStream = null;
        Workbook workbook = null;
        List<PostCommentRequest> postCommentRequestArrayList = Lists.newArrayList();
        try {
            inputStream = new ByteArrayInputStream(datas);
            workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = sheet.rowIterator();
            if (iterator.hasNext()) {
                iterator.next();
            }

            while (iterator.hasNext()) {
                PostCommentRequest param = new PostCommentRequest();
                Row row = iterator.next();

                param.setOrderNo(cellToString(row.getCell(4)));
                String comment = cellToString(row.getCell(5));
                String tags = cellToString(row.getCell(9));
                param.setItemScore(ObjectUtil.objectToInt(cellToString(row.getCell(6)),0));
                param.setLogisticsScore(ObjectUtil.objectToInt(cellToString(row.getCell(7)),0));

                postCommentRequestArrayList.add(param);
            }
        } catch (IOException e) {
        } finally {
            try {
                if (null != inputStream) {
                    inputStream.close();
                }
                if (null != workbook) {
                    workbook.close();
                }
            } catch (IOException e) {
            }

        }
        return postCommentRequestArrayList;
    }

    /**
     * 功能描述:
     * 〈excel列的值转成string〉
     *
     * @param cell
     * @return: java.lang.String
     * @author: shouanxin
     * @date : 2018/8/14 11:14
     */
    public static String cellToString(Cell cell) {
        if (null == cell) {
            return null;
        }
        String result;
        //数字格式化，取整数部分
        DecimalFormat df = new DecimalFormat("#");

        switch (cell.getCellTypeEnum()) {
            case STRING:
                //String
                result = cell.getRichStringCellValue().getString().trim();
                break;
            case NUMERIC:
                //数字类型，double
                result = df.format(cell.getNumericCellValue());
                break;
            case BOOLEAN:
                //布尔类型
                result = String.valueOf(cell.getBooleanCellValue()).trim();
                break;
            case FORMULA:
                //公式
                result = cell.getCellFormula();
                break;
            default:
                result = "";
        }
        return result;
    }

    public static String cellValue(Cell cell) {
        if (null == cell) {
            return null;
        }
        String result;
        //数字格式化，取整数部分
        DecimalFormat df = new DecimalFormat("#");

        switch (cell.getCellTypeEnum()) {
            case STRING:
                //String
                result = cell.getRichStringCellValue().getString().trim();
                break;
            case NUMERIC:
                //数字类型，double
                result = df.format(cell.getNumericCellValue());
                break;
            case BOOLEAN:
                //布尔类型
                result = String.valueOf(cell.getBooleanCellValue()).trim();
                break;
            case FORMULA:
                //公式
                result = cell.getCellFormula();
                break;
            default:
                result = "";
        }
        return result;
    }

    /**
     * 功能描述: 〈file to byte〉.
     *
     * @param filePath
     * @return  byte[]
     * @author shouanxin
     * @date  2019/5/4 13:27
     */
    public static byte[] File2byte(String filePath) {
        byte[] buffer = null;
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }
}
