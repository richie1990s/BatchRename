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

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 中间的文件名列表控件
 *
 * @author richie (richie1990@163.com)
 */
class PanelCenter extends JPanel {
    private JLabel label;

    PanelCenter() {
        label = new JLabel();

        add(label);


    }

    public void setText(String text){
        label.setText("选择文件夹: " + text);
    }
}