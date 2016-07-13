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

/**
 * APP的参数
 *
 * @author richie (richie1990@163.com)
 */
public interface AppConfigs {
    // APP宽和高
    int APP_WIDTH = 650, APP_HEIGHT = 450;
    int APP_BG = 0xF0F0F0;
    int TRANSPARENT_BG = 0x00000000;

    // 上方Panel大小
    int NORTH_WIDTH = APP_WIDTH, NORTH_HEIGHT = 50;
    // 左侧Panel大小
    int EAST_WIDTH = 150, EAST_HEIGHT = APP_HEIGHT - NORTH_HEIGHT;
    // 中间Panel大小
    int CENTER_WIDTH = APP_WIDTH - EAST_WIDTH, CENTER_HEIGHT = EAST_HEIGHT;

}
