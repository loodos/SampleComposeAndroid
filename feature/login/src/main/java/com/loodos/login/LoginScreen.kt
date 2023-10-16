package com.loodos.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.loodos.designsystems.component.CustomTextField
import com.loodos.designsystems.component.MainAppScaffold
import com.loodos.samplecomposeandroid.feature.login.R
import de.palm.composestateevents.EventEffect

/**
 * Created by mertcantoptas on 10.05.2023
 */

@Composable
internal fun LoginScreenRoute(
    navigateToHome: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel(),
) {
    val loginUIState by viewModel.uiState.collectAsStateWithLifecycle()

    EventEffect(
        event = loginUIState.navigateToHome,
        onConsumed = viewModel::onConsumeSingleEvent,
        action = navigateToHome,
    )

    LoginScreen(
        loginUIState,
        modifier = modifier,
        onUserNameValueChange = viewModel::onUserNameChange,
        onPasswordValueChange = viewModel::onPasswordChange,
        onLoginClicked = viewModel::onLoginClick,
    )
}

@Composable
fun LoginScreen(
    loginUIState: LoginViewState,
    onUserNameValueChange: (String) -> Unit,
    onPasswordValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    onLoginClicked: () -> Unit,
) {
    MainAppScaffold(
        modifier = modifier.fillMaxSize(),
    ) {
        Content(
            loginUIState,
            modifier = Modifier,
            onUserNameValueChange = onUserNameValueChange,
            onPasswordValueChange = onPasswordValueChange,
            onLoginClicked = onLoginClicked,
        )
    }
}

@Composable
private fun Content(
    loginUIState: LoginViewState,
    onUserNameValueChange: (String) -> Unit,
    onPasswordValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    onLoginClicked: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            modifier = Modifier.size(120.dp),
            painter = painterResource(id = R.drawable.icon_compose),
            contentDescription = "",
        )
        Spacer(modifier = Modifier.height(70.dp))
        UserNameTextField(
            value = loginUIState.userName,
            errorMessageRes = loginUIState.usernameErrorMessage,
            onValueChange = onUserNameValueChange,
        )
        Spacer(modifier = Modifier.height(16.dp))

        PasswordTextField(
            value = loginUIState.password,
            errorMessageRes = loginUIState.passwordErrorMessage,
            onValueChange = onPasswordValueChange,
        )

        Button(
            onClick = onLoginClicked,
            shape = MaterialTheme.shapes.extraLarge,
            enabled = loginUIState.userName.isNotEmpty() && loginUIState.password.isNotEmpty(),
            modifier = Modifier
                .width(180.dp)
                .padding(top = 20.dp),
        ) {
            Text(text = stringResource(id = R.string.login))
        }
    }
}

@Composable
private fun UserNameTextField(
    value: String,
    errorMessageRes: Int?,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    com.loodos.designsystems.component.CustomTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        value = value,
        label = { Text(text = stringResource(id = R.string.username_hint)) },
        onValueChange = onValueChange,
        isError = errorMessageRes != null,
        trailingIcon = {
            AnimatedVisibility(visible = value.isNotEmpty()) {
                Image(
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            onValueChange("")
                        },
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_cancel),
                    contentDescription = "",
                )
            }
        },
        supportingText = {
            AnimatedVisibility(visible = errorMessageRes != null) {
                val errorMessage = errorMessageRes?.let {
                    stringResource(id = it)
                } ?: ""

                Text(text = errorMessage)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        placeholder = { Text(text = stringResource(id = R.string.username_hint)) },
    )
}

@Composable
private fun PasswordTextField(
    value: String,
    errorMessageRes: Int?,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    var isPasswordVisible by remember { mutableStateOf(false) }
    CustomTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        value = value,
        label = { Text(text = stringResource(id = R.string.password_hint)) },
        onValueChange = onValueChange,
        isError = errorMessageRes != null,
        trailingIcon = {
            AnimatedVisibility(visible = value.isNotEmpty()) {
                Image(
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            isPasswordVisible = !isPasswordVisible
                        },
                    imageVector = ImageVector.vectorResource(
                        id =
                        if (isPasswordVisible) {
                            R.drawable.ic_visibility_on
                        } else {
                            R.drawable.ic_visibility_off_24
                        },
                    ),
                    contentDescription = "",
                )
            }
        },
        supportingText = {
            AnimatedVisibility(visible = errorMessageRes != null) {
                val errorMessage = errorMessageRes?.let {
                    stringResource(id = it)
                } ?: ""

                Text(text = errorMessage)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        placeholder = { Text(text = stringResource(id = R.string.password_hint)) },
    )
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    com.loodos.designsystems.theme.SampleComposeAndroidTheme() {
        Content(
            LoginViewState(),
            onUserNameValueChange = {},
            onLoginClicked = {},
            onPasswordValueChange = {},
        )
    }
}
