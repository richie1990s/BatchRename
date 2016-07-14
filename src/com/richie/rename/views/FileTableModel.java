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

import com.sun.istack.internal.NotNull;

import javax.swing.table.AbstractTableModel;

/**
 * @author richie (richie1990@163.com)
 */
class FileTableModel extends AbstractTableModel {
    private String[] columnNames;
    private int rowCount;

    FileTableModel(@NotNull int rowCount, @NotNull String[] columnNames) {
        this.columnNames = columnNames;
        this.rowCount = rowCount;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return rowCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }
}
