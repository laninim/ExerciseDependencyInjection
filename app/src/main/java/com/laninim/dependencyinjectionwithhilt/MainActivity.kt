package com.laninim.dependencyinjectionwithhilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.laninim.dependencyinjectionwithhilt.ui.theme.DependencyInjectionWithHiltTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DependencyInjectionWithHiltTheme {
                // A surface container using the 'background' color from the theme

                SimpleUI()
            }
        }
    }
}


@Composable
fun SimpleUI(
    modifier: Modifier = Modifier
) {
    val viewModel = hiltViewModel<MyViewModel>()

    val state = viewModel.urlImage.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        AsyncImage(
            model = state.value  ,
            contentDescription = null,
            modifier = Modifier
                .size(200.dp , 200.dp)
                .border(1.dp , Color.Blue),
            contentScale = ContentScale.Fit
        )
        Button(onClick = {
             viewModel.getRandomDog()
        },

            ) {
             Text(text = "Generate Random dog")
        }
    }
}

@Composable
@Preview
fun SimpleUIPreview(){
    SimpleUI()
}
