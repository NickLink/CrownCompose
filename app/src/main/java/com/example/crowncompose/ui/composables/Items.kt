package com.example.crowncompose.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.crowncompose.ui.theme.MyCrownTheme
import com.example.crowncompose.ui.theme.Typography
import com.example.crowncompose.ui.theme.crownColors

@Preview
@Composable
fun PreviewTextBlock() {
    MyCrownTheme(darkTheme = true) {
        Surface {
            TextBlock(
                header = "Header",
                text = "Some long text several times repeated Some long text several times repeated Some long text several times repeated Some long text several times repeated Some long text several times repeated"
            )
        }
    }
}

@Composable
fun TextBlock(
    header: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier
        .background(color = MaterialTheme.crownColors.highBackground)
        .fillMaxWidth(1f)
        .padding(top = 24.dp, bottom = 24.dp, start = 16.dp, end = 16.dp)) {
        Text(
            text = header,
            style = Typography.titleMedium,
            color = MaterialTheme.crownColors.highText)
        Text(
            modifier = modifier.padding(top = 16.dp),
            text = text,
            style = Typography.bodySmall,
            color = MaterialTheme.crownColors.highText)
    }
}