package com.andrew.marvin.DataVisualization;

import lombok.Data;

import java.util.ArrayList;

@Data
public class LineChartData {
    private int chartHeight;
    private ArrayList<LineChartNode> nodes = new ArrayList<>();
    private ArrayList<LineChartLink> links = new ArrayList<>();
}
