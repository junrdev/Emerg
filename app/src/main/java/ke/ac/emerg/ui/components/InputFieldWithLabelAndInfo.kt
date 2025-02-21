package ke.ac.emerg.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import ke.ac.emerg.ui.theme.EmergTheme

@Composable
fun InputFieldWithLabelAndInfo(
    modifier: Modifier = Modifier,
    enabled : Boolean = true,
    value: String = "",
    onValueChange: (String) -> Unit = {},
    onInfoExpand: () -> Unit = {},
    label: String = LoremIpsum(2).values.joinToString(),
    placeHolder: String = LoremIpsum(2).values.joinToString(),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {

    Box(modifier = modifier) {
        InputFieldWithLabel(
            modifier = Modifier,
            value = value,
            onValueChange = onValueChange,
            label = label,
            placeHolder = placeHolder,
            keyboardActions = keyboardActions,
            keyboardOptions = keyboardOptions
        )

        IconButton(onClick = onInfoExpand, modifier = Modifier.align(Alignment.TopEnd)) {
            Icon(
                imageVector = Icons.Rounded.Info,
                contentDescription = label
            )
        }

    }


}

@Preview
@Composable
private fun InputFieldWithLabelAndInfoPrev() {
    EmergTheme {
        InputFieldWithLabelAndInfo()
    }
}