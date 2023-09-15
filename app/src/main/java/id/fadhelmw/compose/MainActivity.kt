// nama package yang digunakan
package id.fadhelmw.compose
//import package
import androidx.compose.foundation.border
import androidx.compose.material.MaterialTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import id.fadhelmw.compose.ui.theme.ComposeTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.painterResource



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MessageCard(Message("Android", "Jetpack Compose"))
                }
            }
        }
    }
}
//mendeklarasikan class Message
data class Message(val author : String, val body: String)
// fungsi composable memanggil 2 elemen text dengan menambahkan fungsi column
// sehingga text tidak tertumpuk
@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                // Set gambar > 40 dp
                .size(40.dp)
                // Memotong gambar menjadi bundar
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )

        // menambahkan jarak antara gambar dan kolom
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = msg.author,
                color = MaterialTheme.colors.secondaryVariant
            )
            // menambahkan jara antara author dan text
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = msg.body)
        }
    }
}
    // fungsi composable untuk menampilkan nama yang telah ditentukan.
    @Preview(showBackground = true)
    @Composable
    fun PreviewMessageCard() {
        ComposeTutorialTheme {
            Surface {
                MessageCard(
                    msg = Message("Colleague", "Take a look at Jetpack Compose, it's great!")
                )
            }
        }
    }
