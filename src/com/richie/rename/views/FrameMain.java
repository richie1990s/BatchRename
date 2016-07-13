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
public class FrameMain extends JFrame implements AppConfigs, NorthCallback {
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
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        getContentPane().add(panel);
        setContent(panel, layout);
    }

    private void setContent(JPanel parent, GridBagLayout layout) {
        Insets insets = new Insets(0, 0, 0, 0);
        PanelNorth pnorth = new PanelNorth(this);
        pnorth.setBackground(new Color(APP_BG));
        parent.add(pnorth);
        GridBagConstraints snorth = new GridBagConstraints(0, 0, 2, 1,
                0, 0, GridBagConstraints.NORTH, GridBagConstraints.NONE,
                insets, NORTH_WIDTH, NORTH_HEIGHT);
        layout.setConstraints(pnorth, snorth);

        PanelEast peast = new PanelEast();
        peast.setBackground(new Color(APP_BG));
        parent.add(peast);
        GridBagConstraints seast = new GridBagConstraints(0, 1, 1, 1,
                0, 0.3, GridBagConstraints.EAST, GridBagConstraints.NONE,
                insets, EAST_WIDTH, EAST_HEIGHT);
        layout.setConstraints(peast, seast);

        pcenter = new PanelCenter();
        pcenter.setBackground(new Color(APP_BG));
        parent.add(pcenter);
        GridBagConstraints s3 = new GridBagConstraints(1, 1, 1, 1,
                0, 0.7, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                insets, CENTER_WIDTH, CENTER_HEIGHT);
        layout.setConstraints(pcenter, s3);

    }

    @Override
    public void setDirPath(String text) {
        pcenter.setText(text);
    }


}
