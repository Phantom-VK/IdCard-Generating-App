package com.app.idCard.kotlin

import android.os.Bundle
import android.view.View
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.app.idCard.R
import com.app.idCard.ui.theme.IdCardAppTheme


class ProfileFragment :Fragment(R.layout.user_profile){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<ComposeView>(R.id.compose_view).setContent {
            IdCardAppTheme {
                UserProfile()
            }

        }
    }


}

@Composable
fun UserProfile(){
    var name by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var mobilenumber by remember { mutableStateOf("") }
    var wpnumber by remember { mutableStateOf("") }
    var profilePictureUrl by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 25.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /*TODO*/}) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Go Back",
                    tint = MaterialTheme.colorScheme.secondary
                )
            }
            Text(
                text = "Profile",
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.padding(start = 15.dp)
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(
                start = 10.dp,
                end = 10.dp
            )
        ) {
            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = name,
                fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                color = MaterialTheme.colorScheme.background
            )

            UnderlineTextField(
                value = name,
                onValueChange = { name = it },
                hint = "Name",
                keyboardType = KeyboardType.Text,
                imageVector = Icons.Filled.AccountCircle
            )

            UnderlineTextField(
                value = address,
                onValueChange = { address = it },
                hint = "Address",
                keyboardType = KeyboardType.Text,
                imageVector = Icons.Filled.LocationOn
            )

            UnderlineTextField(
                value = email,
                onValueChange = { email = it },
                hint = "Email",
                keyboardType = KeyboardType.Email,
                imageVector = Icons.Outlined.Email
            )

            UnderlineTextField(
                value = mobilenumber,
                onValueChange = { mobilenumber = it },
                hint = "Mobile Number",
                keyboardType = KeyboardType.Number,
                imageVector = Icons.Filled.Call
            )

            UnderlineTextField(
                value = wpnumber,
                onValueChange = { wpnumber = it },
                hint = "WhatsApp Number",
                keyboardType = KeyboardType.Number,
                imageVector = Icons.Filled.Call
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { /* TODO: Implement change password functionality */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.background)
            ) {
                Text(text = "Change Password", color = MaterialTheme.colorScheme.secondary)
            }

            Button(
                onClick = {

                    //TODO
                },
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onPrimary),
                modifier = Modifier.padding(top = 10.dp)
            ) {
                Text(text = "Save", color = MaterialTheme.colorScheme.secondary)
            }
        }
    }


}

@Composable
fun UnderlineTextField(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    imageVector: ImageVector,
    keyboardType: KeyboardType
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = hint) },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        leadingIcon = {
            Icon(
                imageVector = imageVector,
                contentDescription = hint,
                tint = MaterialTheme.colorScheme.secondary
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Filled.Edit,
                contentDescription = "Edit",
                tint = MaterialTheme.colorScheme.secondary
            )
        },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.primary,
            unfocusedContainerColor = MaterialTheme.colorScheme.primary,
            focusedTextColor = MaterialTheme.colorScheme.secondary,
            unfocusedTextColor = MaterialTheme.colorScheme.background,
            focusedIndicatorColor = MaterialTheme.colorScheme.secondary,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.background,
            focusedLeadingIconColor = MaterialTheme.colorScheme.primary,
            focusedTrailingIconColor = MaterialTheme.colorScheme.primary,
            focusedLabelColor = MaterialTheme.colorScheme.secondary,
            cursorColor = MaterialTheme.colorScheme.secondary
        )
    )
}

