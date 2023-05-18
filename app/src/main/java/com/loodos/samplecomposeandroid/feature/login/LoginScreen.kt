package com.loodos.samplecomposeandroid.feature.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
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
import com.loodos.samplecomposeandroid.R
import com.loodos.samplecomposeandroid.ui.components.CustomTextField
import com.loodos.samplecomposeandroid.ui.components.MainAppScaffold
import com.loodos.samplecomposeandroid.ui.theme.SampleComposeAndroidTheme
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
        action =   navigateToHome
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
        modifier = modifier.fillMaxSize()
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
    var isPasswordVisible by remember { mutableStateOf(false) }
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier.size(120.dp),
            painter = painterResource(id = R.drawable.icon_compose),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.height(70.dp))
        CustomTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            value = loginUIState.userName,
            label = { Text(text = stringResource(id = R.string.username_hint)) },
            onValueChange = onUserNameValueChange,
            isError = loginUIState.usernameErrorMessage != null,
            trailingIcon = {
                AnimatedVisibility(visible = loginUIState.userName.isNotEmpty()) {
                    Image(
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                                onUserNameValueChange("")
                            },
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_cancel),
                        contentDescription = ""
                    )
                }

            },
            supportingText = {
                AnimatedVisibility(visible = loginUIState.usernameErrorMessage != null) {
                    val errorMessage = loginUIState.usernameErrorMessage?.let {
                        stringResource(id = it)
                    } ?: ""

                    Text(text = errorMessage)
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            placeholder = { Text(text = stringResource(id = R.string.username_hint)) })

        Spacer(modifier = Modifier.height(16.dp))

        CustomTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            value = loginUIState.password,
            label = { Text(text = stringResource(id = R.string.password_hint)) },
            onValueChange = onPasswordValueChange,
            isError = loginUIState.passwordErrorMessage != null,
            trailingIcon = {
                AnimatedVisibility(visible = loginUIState.password.isNotEmpty()) {
                    Image(
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                                isPasswordVisible = !isPasswordVisible
                            },
                        imageVector = ImageVector.vectorResource(
                            id =
                            if (isPasswordVisible) R.drawable.ic_visibility_on
                            else R.drawable.ic_visibility_off_24
                        ),
                        contentDescription = ""
                    )
                }

            },
            supportingText = {
                AnimatedVisibility(visible = loginUIState.passwordErrorMessage != null) {
                    val errorMessage = loginUIState.passwordErrorMessage?.let {
                        stringResource(id = it)
                    } ?: ""

                    Text(text = errorMessage)
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            placeholder = { Text(text = stringResource(id = R.string.password_hint)) })

        Button(
            onClick = onLoginClicked,
            shape = MaterialTheme.shapes.extraLarge,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff295EA7)
            ),
            enabled = loginUIState.userName.isNotEmpty() && loginUIState.password.isNotEmpty(),
            modifier = Modifier
                .width(180.dp)
                .padding(top = 20.dp)
        ) {
            Text(text = stringResource(id = R.string.login))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    SampleComposeAndroidTheme() {
        Content(
            LoginViewState(),
            onUserNameValueChange = {},
            onLoginClicked = {},
            onPasswordValueChange = {})
    }
}
