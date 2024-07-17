package com.app.idCard.kotlin.fragments

import android.os.Bundle
import android.view.View
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.app.idCard.R
import com.app.idCard.ui.theme.IdCardAppTheme

class IDCardFragment : Fragment(R.layout.fragment_id_card) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<ComposeView>(R.id.idcard_compose_view).setContent {
            IdCardAppTheme {
                IDCard()
            }
        }
    }
}


@Composable
fun IDCard() {

    var name by remember {
        mutableStateOf("")
    }
    var regNumber by remember {
        mutableStateOf("")
    }
    var branch by remember {
        mutableStateOf("")
    }
    var dob by remember {
        mutableStateOf("")
    }
    var mobilenumber by remember {
        mutableStateOf("")
    }
    var pdfName by rememberSaveable {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(1.dp, Color.Gray)
            .background(Color.White)
            .padding(16.dp)
    ) {
        // Header
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "SHRI GURU GOBIND SINGHJI",
                style = MaterialTheme.typography.titleLarge,
                color = Color.Blue,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "INSTITUTE OF ENGINEERING & TECHNOLOGY",
                style = MaterialTheme.typography.titleLarge,
                color = Color.Red,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Vishnupuri, Nanded - 431606 (MS)",
                style = MaterialTheme.typography.titleSmall,
                color = Color.Black
            )
            Text(
                text = "Government Aided Autonomous Institute",
                style = MaterialTheme.typography.titleSmall,
                color = Color.Black
            )
        }

        // Photo and Details
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Photo
            Image(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(100.dp)
                    .border(1.dp, Color.Gray)
            )

            // Details
            Column(
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Red,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Reg. No. : $regNumber",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black
                )
                Text(
                    text = "Branch :  $branch",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black
                )
                Text(
                    text = "DOB :  $dob",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black
                )
                Text(
                    text = "Mob. No. :  $mobilenumber",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black
                )
            }
        }

        // Signatures
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Student Sign.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(4.dp))
                // Placeholder for signature
                Box(
                    modifier = Modifier
                        .width(80.dp)
                        .height(24.dp)
                        .border(1.dp, Color.Gray)
                )
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Director Sign.",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(4.dp))
                // Placeholder for signature
                Box(
                    modifier = Modifier
                        .width(80.dp)
                        .height(24.dp)
                        .border(1.dp, Color.Gray)
                )
            }
        }
    }
}


