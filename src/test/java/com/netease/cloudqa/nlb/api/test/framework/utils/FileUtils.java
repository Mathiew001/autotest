/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * 
 * @author hzzhangyan
 * @version $Id: FileUtils.java, v 0.1 2017-5-23 下午7:43:45 hzzhangyan Exp $
 */
public class FileUtils {

    /**
     * 指定文件路径读取文件内容，通过String返回，兼容换行符"/"
     * 
     * @param filePath
     * @return
     */
    public String readFile(String filePath) {
        BufferedReader bfr = null;
        StringBuffer sb = new StringBuffer();
        try {
            bfr = new BufferedReader(new FileReader(filePath));
            String line = null;
            while ((line = bfr.readLine()) != null) {
                sb.append(line);
                sb.append("\n");//换行符
            }
            return sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bfr != null) {
                try {
                    bfr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 指定文件路径下寻找匹配正则表达式文件
     * 
     * @param
     * @return
     */
    public static void findFileRecursive(final String findDir, final String fileNameRegex,
                                         List<File> fileList) {
        if (null == fileList) {
            return;
        }
        File file = new File(findDir);
        if (file.isFile()) {
            if (null == fileNameRegex || file.getName().matches(fileNameRegex)) {
                fileList.add(file);
            }
        } else if (file.isDirectory()) {
            File[] dirFiles = file.listFiles();
            for (File dirFile : dirFiles) {
                findFileRecursive(dirFile.getAbsolutePath(), fileNameRegex, fileList);
            }
        }
    }

    /**
     * 组装文件路径:
     * strs = {a1,a2,a3,a4} , 返回 a1/a2/a3/a4/
     * 
     * @param strs
     * @return
     */
    public static String CreateFilePath(String... strs) {
        if (null == strs) {
            return null;
        }
        StringBuffer strBuf = new StringBuffer("");
        for (String str : strs) {
            strBuf.append(str + "/");
        }
        return strBuf.toString();
    }

    /**
     * 
     * 
     * @param path
     * @param content
     * @param encoding(utf-8、gbk)
     * @throws IOException
     */
    public static void write(String path, String content, String encoding) throws IOException {
        File file = new File(path);
        file.delete();
        file.createNewFile();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream(file), encoding));
        writer.write(content);
        writer.close();
    }

    /**
     * 
     * 
     * @param path
     * @param encoding(utf-8、gbk)
     * @return
     * @throws IOException
     */
    public static String read(String path, String encoding) throws IOException {
        String content = "";
        File file = new File(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),
            encoding));
        String line = null;
        while ((line = reader.readLine()) != null) {
            content += line + "\n";
        }
        reader.close();
        return content;
    }

//    public static String read(String path, String encoding, String caseLabel) throws IOException {
//        String content = "";
//        String tmp = "";
//        File file = new File(path);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),
//                encoding));
//        String line = null;
//        Boolean start = false;
//        Boolean end = false;
//        while (true) {
//            while ((line = reader.readLine()) != null) {
//                if (line.endsWith("DataHolderImpl"))
//                    start = true;
//                if (line.startsWith("  etcdPrepareData:")) {
//                    start = false;
//                    end = true;
//                }
//                if (start || end)
//                    tmp += line + "\n";
//                if (end) {
//                    start = false;
//                    end = false;
//                    break;
//                }
//            }
//            if (line == null)
//                break;
//            if (tmp.contains(caseLabel)) {
//                content += tmp + "\n";
//                tmp = "";
//            }
//        }
//        reader.close();
//        return content;
//    }
}
