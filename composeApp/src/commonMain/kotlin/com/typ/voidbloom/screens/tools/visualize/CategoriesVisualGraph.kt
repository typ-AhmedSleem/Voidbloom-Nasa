package com.typ.voidbloom.screens.tools.visualize

import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.aay.compose.donutChart.PieChart
import com.aay.compose.donutChart.model.PieChartData

@Composable
fun CategoriesVisualGraph(
    categoriesMap: Map<String, List<Pair<String, Int>>>,
    modifier: Modifier = Modifier,
) {
    val totalPubs = remember(categoriesMap) {
        categoriesMap.values.sumOf { it.size }
    }

    val categoriesColors = listOf(
        Color(0xFFF24C3D),
        Color(204, 88, 3),
        Color(40, 75, 99),
        Color(76, 201, 240),
        Color(169, 132, 103),
        Color(255, 107, 53),
        Color(11, 231, 84),
        Color(92, 164, 169)
    )

    println("Total pubs: $totalPubs")
    println("Total categories: ${categoriesMap.size}")

    val chartData: List<PieChartData> = remember(categoriesMap) {
        categoriesMap
            .entries
            .mapIndexed { idx, (category, pubs) ->
                PieChartData(
                    data = pubs.size.toDouble(),
                    color = categoriesColors[idx % categoriesColors.size],
                    partName = category,
                )
            }
    }
    PieChart(
        modifier = modifier,
        pieChartData = chartData,
        animation = tween(1000),
        /*ratioLineColor = VbColors.secondaryContainer,
        textRatioStyle = VbTypography.titleMedium.copy(
            fontWeight = FontWeight.Medium,
            color = VbColors.onBackground,
        ),*/
    )

}