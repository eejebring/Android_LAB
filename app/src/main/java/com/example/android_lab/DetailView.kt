import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import com.example.android_lab.Note
import com.example.android_lab.ui.theme.LargeFontSize


@Composable
fun DetailView(note: Note, navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(Dp(5F))
    ) {
        Icon(
            Icons.AutoMirrored.Filled.KeyboardArrowLeft,
            contentDescription = "Back button",
            modifier = Modifier
                .align(Alignment.Start)
                .size(Dp(50F))
                .clickable(onClick = { navController.popBackStack() })
        )
        Text(note.title, fontSize = LargeFontSize, fontWeight = FontWeight.Bold)
        Text(note.description)
    }
}