package com.example.wbjuniorandroid.ui.general.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import com.example.wbjuniorandroid.R
import com.example.wbjuniorandroid.ui.utils.Mock

@Composable
fun OverlappingRow(
    modifier: Modifier = Modifier,
    overlappingPercentage: Float = 0.33f,
    content: @Composable () -> Unit,
) {

    val factor = (1 - overlappingPercentage)

    Layout(
        modifier = modifier,
        content = content,
        measurePolicy = { measurables, constraints ->
            val placeables = measurables.map { it.measure(constraints) }.take(5)
            val widthsExceptFirst = placeables.subList(1, placeables.size).sumOf { it.width }
            val firstWidth = placeables.getOrNull(0)?.width ?: 0
            val width = (widthsExceptFirst * factor + firstWidth).toInt()
            val height = placeables.maxOf { it.height }
            layout(width, height) {
                var x = (widthsExceptFirst * factor).toInt()
                for (placeable in placeables) {
                    placeable.placeRelative(x, 0, 0f)
                    x -= (placeable.width * factor).toInt()
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun OverlappingImagesPreview(imagesURL: List<String> = MutableList(10) { Mock.borderImageURL }) {
    OverlappingRow {
        imagesURL.forEach {
            BorderImage(imageURL = it)
        }
    }
}