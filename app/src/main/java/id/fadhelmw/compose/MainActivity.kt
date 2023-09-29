package id.fadhelmw.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import id.fadhelmw.compose.ui.theme.ComposeTheme
import androidx.compose.ui.tooling.preview.Preview

data class ContactInfo(
    val name: String,
    val title: String,
    val email: String,
    val imageResource: Int // Gunakan resource gambar lokal
)

// Main
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                // Define your contact list here
                val contactList = listOf(
                    ContactInfo("Fadhel Muhammad W", "Full Stack Engineering", "mw.fadhel@google.com", R.drawable._75874270_513287),
                    // Add more contacts as needed
                )

                ContactList(contactList = contactList)
            }
        }
    }
}

// Untuk edit tampilan
@Composable
fun ContactCard(contactInfo: ContactInfo) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp)
    ) {
        // Foto (dalam bentuk bulat dan berada di tengah)
        Box(
            modifier = Modifier
                .size(96.dp)
                .background(Color.Gray, shape = CircleShape)
                .align(Alignment.CenterHorizontally)
        ) {
            Image(
                painter = painterResource(id = contactInfo.imageResource),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp) // Ubah ukuran foto sesuai kebutuhan
                    .clip(CircleShape)
            )
        }

        // Nama dan Jabatan untuk mengubah tampilan
        Column(
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = contactInfo.name,
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = contactInfo.title,
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                color = Color.Gray
            )
        }

        // Email
        Text(
            text = contactInfo.email,
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(top = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun ContactList(contactList: List<ContactInfo>) {
    LazyColumn {
        items(contactList) { contactInfo ->
            ContactCard(contactInfo = contactInfo)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
@Preview
@Composable
fun Profile() {
    val contactInfo = ContactInfo("Fadhel Muhammad W", "Full Stack Engineering", "mw.fadhel@google.com", R.drawable._75874270_513287)
    ContactCard(contactInfo = contactInfo)
}