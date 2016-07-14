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

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Color;
import java.awt.Font;

/**
 * 左侧的命名规则控件
 *
 * @author richie (richie1990@163.com)
 */
class PanelEast extends JPanel implements AppConfigs, DocumentListener {
    private JTextArea ta;
    private EastCallback callback;

    PanelEast(EastCallback callback) {
        super();
        this.callback = callback;
        setLayout(null);
        setSize(EAST_WIDTH, EAST_HEIGHT);
        String space = "&nbsp;&nbsp;";
        JLabel label = new JLabel("<html>" + space + "<b>命名规则: </b><br/>" + space + space +
                "请输入新文件名规则: <br/>" + space + space + "<b>*</b>" + space + "代表序号1，2" +
                "<br/>" + space + space + "<b>**</b>" + space + "代表序号01，02" +
                "<br/>" + space + space + "<b>***</b>" + space + "代表序号001，002" +
                "</html>");
        label.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
//        label.setOpaque(true);
        label.setBounds(0, 0, EAST_WIDTH, 140);
        add(label);

        ta = new JTextArea(4, 4);
        ta.setLineWrap(true);// 激活自动换行功能
        ta.setWrapStyleWord(true);
        ta.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        ta.setBackground(new Color(0x00000000, true));
        ta.setBorder(BorderFactory.createLineBorder(new Color(0x80000000, true), 2));
        ta.setBounds(4, 140, EAST_WIDTH - 8, EAST_HEIGHT - 180);
        ta.getDocument().addDocumentListener(this);
        ta.setBackground (new Color(TRANSPARENT_BG, true));//文本区背景
        ta.setForeground (Color.BLACK);//字体颜色
        ta.setColumns (0);
        ta.setRows (0);
        add(ta);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        callback.setNameRule(ta.getText());
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        callback.setNameRule(ta.getText());
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        System.out.println(ta.getText());
    }

    interface EastCallback {
        /**
         * 设置命名规则
         *
         * @param rules 命名规则
         */
        void setNameRule(String rules);
    }
}
