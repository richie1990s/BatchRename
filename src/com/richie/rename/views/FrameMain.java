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


import com.richie.rename.views.PanelEast.EastCallback;
import com.richie.rename.views.PanelNorth.NorthCallback;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.*;

/**
 * APP主窗体
 *
 * @author richie (richie1990@163.com)
 */
public class FrameMain extends JFrame implements AppConfigs, NorthCallback, EastCallback {
    private PanelCenter pcenter;

    public FrameMain() {
        setSize(APP_WIDTH, APP_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("批量命名工具");
        setResizable(false);
        Image icon = new ImageIcon(this.getClass().getResource("/res/logo.png")).getImage();
        setIconImage(icon);

        addPanel();
    }

    private void addPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.black);
        panel.setLayout(null);
        getContentPane().add(panel);
        setContent(panel);
    }

    private void setContent(JPanel parent) {
        PanelNorth pnorth = new PanelNorth(this);
//        pnorth.setBackground(new Color(0x00FF00));
        pnorth.setBounds(0, 0, NORTH_WIDTH, NORTH_HEIGHT);
        parent.add(pnorth);

        PanelEast peast = new PanelEast(this);
        peast.setBounds(0, NORTH_HEIGHT, EAST_WIDTH, EAST_HEIGHT);
        parent.add(peast);

        pcenter = new PanelCenter();
        pcenter.setBounds(EAST_WIDTH, NORTH_HEIGHT, CENTER_WIDTH, CENTER_HEIGHT);
        pcenter.setBackground(new Color(0xCCCCCC));
        parent.add(pcenter);
    }

    @Override
    public void setDirPath(String text) {
        pcenter.setDirPath(text);
    }

    @Override
    public void setNameRule(String rules) {
        pcenter.setNameRule(rules);
    }
}
