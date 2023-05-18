@file:OptIn(ExperimentalMaterial3Api::class)

package com.loodos.samplecomposeandroid.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.loodos.samplecomposeandroid.R

/**
 * Created by mertcantoptas on 10.05.2023
 */

@Composable
fun CustomTextField(
    value: String,
    label: @Composable (() -> Unit),
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(),
    enabled: Boolean = true,
    trailingIcon: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        label = label,
        onValueChange = onValueChange,
        enabled = enabled,
        colors = colors,
        trailingIcon = trailingIcon,
        visualTransformation = visualTransformation,
        singleLine = true,
        placeholder = placeholder,
        supportingText = supportingText,
        isError = isError,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
    )
}

@Composable
@Preview(showBackground = true)
private fun CustomTextFieldPreview() {
    CustomTextField(
        value = "",
        onValueChange = {},
        label = { Text(text = "Label") },
        placeholder = { Text(text = "Placeholder") },
        trailingIcon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
    )
}

@Composable
@Preview(showBackground = true)
private fun CustomTextFieldFillTextPreview() {
    CustomTextField(
        value = "Loodos Compose",
        onValueChange = {},
        label = { Text(text = "Label") },
        placeholder = { Text(text = "Placeholder") },
        isError = true,
        trailingIcon = {
            Image(
                modifier = Modifier.size(24.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_cancel),
                contentDescription = "",
            )
        },
        supportingText = { Text(text = "Supporting Text") },
    )
}
