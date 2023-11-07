package ke.ac.emerg.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ke.ac.emerg.domain.model.remote.Consultation


@Preview
@Composable
fun Prev4() {

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConsultationView(consultation: Consultation) {

    Scaffold {
        Column(modifier = Modifier.padding(it)) {

        }
    }
}