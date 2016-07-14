/*
 * Copyright (C) 2016-2030  richie (richie1990@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.richie.rename.views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;

/**
 * 中间的文件名列表控件
 *
 * @author richie (richie1990@163.com)
 */
class PanelCenter extends JPanel implements AppConfigs{
    private String rules;
    private File[] files;
    private JTable table;

    PanelCenter() {
        setLayout(new FlowLayout());
        setBackground(new Color(0xCCCCCC));
        String[] columnNames = {"原文件名", "新文件名"};
        FileTableModel tableModel = new FileTableModel(13, columnNames);
        table = new JTable(tableModel);
        table.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        table.setRowHeight(30);
        table.setBounds(0, 0, CENTER_WIDTH, CENTER_HEIGHT);
        add(new JScrollPane(table));
    }

    void setDirPath(String text) {
        File dir = new File(text);
        if (dir.exists() && dir.isDirectory()) {
            files = dir.listFiles();
        }
        initTable();
    }

    void setNameRule(String rules) {
        this.rules = rules;
        initTable();
    }

    private void initTable() {
        if (files == null || files.length < 1) {
            return;
        }

        int rows = files.length;

//        String[][] items = new String[rows][columns];
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < columns; j++) {
//                if (j == 0) {
//                    items[i][j] = files[i].getName();
//                } else {
//                    if (rules == null || rules.isEmpty()) {
//                        items[i][j] = "";
//                    } else {
//                        items[i][j] = rules + "_" + i;
//                    }
//                }
//            }
//            table.addColumn(new TableColumn());
//        }
    }
}
