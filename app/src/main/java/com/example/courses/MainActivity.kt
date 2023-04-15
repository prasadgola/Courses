package com.example.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CourseApp()
        }
        }
    }
}


@Composable
fun CourseApp() {
    CoursesTheme() {
    }
}




@Composable
fun TopicCard(topicGrid: Topic, modifier: Modifier = Modifier) {
    Card(modifier = modifier.padding(8.dp), elevation = 4.dp) {
        Column() {
            Image(
                painter = painterResource(topicGrid.stringResourceId),
                contentDescription = stringResource(topicGrid.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = stringResource(topicGrid.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.h6
            )

        }
    }
}



@Composable
private fun TopicList(topicList: List<Topic>, modifier: Modifier = Modifier) {
    LazyColumn {
        items(DataSource.topics){ topic ->
            TopicCard(topic)
        }
    }
}


@Preview
@Composable
private fun TopicCardPreview() {
    TopicCard(Topic(R.string.architecture, R.drawable.architecture, R.drawable.architecture))
}

