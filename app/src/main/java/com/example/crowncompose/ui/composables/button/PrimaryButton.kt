package com.example.crowncompose.ui.composables.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.crowncompose.ui.theme.CrownComposeTheme

@Preview
@Composable
fun PreviewOneDefaultButton() {
    CrownComposeTheme(darkTheme = true) {
        Surface {
            PrimaryButton(
                text = "Header",
                onClick = {})
        }
    }
}

@Preview
@Composable
fun PreviewOTwoDefaultButton() {
    CrownComposeTheme(darkTheme = true) {
        Surface {
            PrimaryButton(
                text = "Header for the two \nlines case",
                onClick = {})
        }
    }
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PrimaryButton(text: String, onClick: () -> Unit) {
    Button(onClick = { onClick },
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.tertiary)
            .fillMaxWidth(1f)
            .semantics {
                testTagsAsResourceId = true
            }
            .testTag("PrimaryButton"),
        contentPadding = PaddingValues(all = 8.dp),
        shape = RoundedCornerShape(4.dp)) {
        Text(text = text.uppercase(),
            textAlign = TextAlign.Center)
    }
}