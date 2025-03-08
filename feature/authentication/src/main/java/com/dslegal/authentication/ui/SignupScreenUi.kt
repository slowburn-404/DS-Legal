package com.dslegal.authentication.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dslegal.authentication.R
import com.dslegal.authentication.RegisterUiEvent
import com.dslegal.authentication.RegisterUiState
import com.dslegal.authentication.di.authenticationModule
import com.dslegal.authentication.navigation.AuthenticationScreen


@Composable
fun SignupScreen(
    modifier: Modifier = Modifier,
    state: RegisterUiState,
    onNavigate: (AuthenticationScreen) -> Unit,
    onEvent: (RegisterUiEvent) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(8.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start
    ) {
        // TOP SECTION
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Image(
                painter = painterResource(id = R.drawable.ds_legal_logo),
                contentDescription = "Description of my image",
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp),
                contentScale = ContentScale.Crop // Adjust how the image is scaled inside its bounds
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Create Your DS Legal Account",
                style = TextStyle(
                    fontSize = 24.sp,
                    color = Color.Black,         // Set the text color to black
                    fontWeight = FontWeight.Bold // Make the text bold
                )
            )

            Spacer(modifier = Modifier.height(30.dp))
            Text(
                "Enter your email address",
                style = TextStyle(
                    color = Color.Black,         // Set the text color to black
                )
            )
            Spacer(modifier = Modifier.height(10.dp))

            var email by remember { mutableStateOf("") }

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = { Text("youremail@dslegal.com") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            // "Continue with Email" button
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1A73E8) // Example blue color
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Continue with Email",
                    color = Color.White
                )
            }

            // "or" text in the middle
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "or",
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))

            // "Sign up with Google" button
            OutlinedButton(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(8.dp)
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.google_ic),
                    contentDescription = "Google icon",
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.width(8.dp))

                Text(text = "Sign up with Google", color = Color.Black)
            }
        }

        // BOTTOM SECTION
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            // "or" text in the middle
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Already have an account?",
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedButton(
                onClick = { /* TODO */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, Color(0xFF1A73E8)),  // Outline color + thickness
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color(0xFF1A73E8)
                )
            ) {
                Text("Log In")
            }

            Spacer(modifier = Modifier.height(8.dp))

            TermsAndPrivacyText(
                onTermsClick = { /* Open Terms URL */ },
                onPrivacyClick = { /* Open Privacy URL */ },
                onUsageClick = {/* Open Usage URL */ }
            )

            Spacer(modifier = Modifier.height(8.dp))

        }
    }
}


@Composable
fun TermsAndPrivacyText(
    onTermsClick: () -> Unit,
    onPrivacyClick: () -> Unit,
    onUsageClick: () -> Unit
) {
    // Build an annotated string for clickable parts
    val annotatedString = buildAnnotatedString {
        append("By continuing in, you agree to DS Legal's ")

        pushStringAnnotation(tag = "TERMS", annotation = "terms_of_use")
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
            append("Consumer Terms")
        }
        pop()

        append(" and ")

        pushStringAnnotation(tag = "USAGE", annotation = "usage_policy")
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
            append("Usage Policy")
        }

        append(" and acknowledge their ")

        pushStringAnnotation(tag = "PRIVACY", annotation = "privacy_policy")
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
            append("Privacy Policy")
        }
        pop()
    }

    // Store the layout result so we can map tap offsets to text positions.
    var textLayoutResult by remember { mutableStateOf<TextLayoutResult?>(null) }

    // Use Text with pointerInput to handle tap gestures.
    Text(
        text = annotatedString,
        style = MaterialTheme.typography.bodySmall.copy(textAlign = TextAlign.Center),
        modifier = Modifier
            .padding(top = 8.dp)
            .pointerInput(Unit) {
                detectTapGestures { tapOffset: Offset ->
                    textLayoutResult?.let { layoutResult ->
                        val position = layoutResult.getOffsetForPosition(tapOffset)
                        annotatedString
                            .getStringAnnotations(start = position, end = position)
                            .firstOrNull()
                            ?.let { annotation ->
                                when (annotation.tag) {
                                    "TERMS" -> onTermsClick()
                                    "PRIVACY" -> onPrivacyClick()
                                    "USAGE" -> onUsageClick()
                                }
                            }
                    }
                }
            },
        onTextLayout = { layoutResult ->
            textLayoutResult = layoutResult
        }
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewSignupScreen() {
    //SignupScreen()
}