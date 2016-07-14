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

import javax.swing.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.List;

/**
 * 顶部的选择文件夹控件
 *
 * @author richie (richie1990@163.com)
 */
class PanelNorth extends JPanel implements AppConfigs, MouseListener{
    private JLabel label;
    private NorthCallback callback;

    PanelNorth(NorthCallback callback) {
        super();
        this.callback = callback;
        setLayout(null);
        label = new JLabel("选择或拖拽文件夹", JLabel.CENTER);
        label.setBackground(new Color(TRANSPARENT_BG, true));
        label.setSize(NORTH_WIDTH - 14, NORTH_HEIGHT - 10);
        label.setBorder(BorderFactory.createLineBorder(new Color(0x80000000, true), 2));
        label.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        label.setLocation(4, 4);
        label.setOpaque(true);
        add(label);
        drag(label);
        label.addMouseListener(this);
    }

    @SuppressWarnings("unchecked")
    private void drag(Component component) {
        new DropTarget(component, DnDConstants.ACTION_COPY_OR_MOVE, new DropTargetAdapter() {
            @Override
            public void drop(DropTargetDropEvent dtde) {
                try {
                    if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
                        dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);//接收拖拽来的数据
                        List<File> list = (List<File>) (dtde.getTransferable().getTransferData(DataFlavor.javaFileListFlavor));
                        callback.setDirPath(list.get(0).getAbsolutePath());
                        dtde.dropComplete(true);//指示拖拽操作已完成
                    } else {
                        dtde.rejectDrop();//否则拒绝拖拽来的数据
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JFileChooser jfc = new JFileChooser();
        jfc.setDialogTitle("请选择文件夹");
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = jfc.showOpenDialog(this);
        if(JFileChooser.APPROVE_OPTION == result) {
            File file = jfc.getSelectedFile();
            if(!file.isDirectory()) {
                JOptionPane.showMessageDialog(null, "选择的目录不存在");
            }else {
                callback.setDirPath(file.getAbsolutePath());
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    interface NorthCallback{
        void setDirPath(String text);
    }
}
