package com.learn.jetpack.mycomposelayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learn.jetpack.mycomposelayout.ui.theme.MyComposeLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeLayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ContactCard()
                }
            }
        }
    }
}

@Composable
fun ContactCard() {
    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.avatar1),
                contentDescription = "Avatar",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = "Online Status",
                tint = Color.Green,
                modifier = Modifier.align(Alignment.BottomEnd)
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = "Dico Wisesa", fontWeight = FontWeight.Bold)
            Text(text = "Online")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyComposeLayoutTheme {
        ContactCard()
    }
}

@Composable
fun ButtonA() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.purple_200)),
        modifier = Modifier.size(100.dp)
    ) {
        Text(text = "A")
    }
}

@Composable
fun ButtonB() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.purple_500)),
        modifier = Modifier.size(80.dp)
    ) {
        Text(text = "B")
    }
}

@Composable
fun ButtonC(text: String = "C") {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.purple_700)),
        modifier = Modifier.size(60.dp)
    ) {
        Text(text)
    }
}

@Composable
fun RowButton() {
    Row(modifier = Modifier.padding(16.dp)) {
        ButtonC("")
        Spacing()
        ButtonC("")
        Spacing()
        ButtonC("")
    }
}

@Composable
fun ColumnButton() {
    Column(modifier = Modifier.padding(16.dp)) {
        ButtonC("")
        Spacing()
        ButtonC("")
        Spacing()
        ButtonC("")
    }
}

@Composable
fun BoxButton() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(16.dp)) {
        ButtonA()
        ButtonB()
        ButtonC("")
    }
}

@Composable
fun BasicLayout() {
    Row(modifier = Modifier.padding(16.dp)) {
        RowButton()
        ColumnButton()
        BoxButton()
    }
}

@Preview(showBackground = true, device = "spec:parent=pixel_4,orientation=landscape")
@Composable
fun BasicLayoutPreview() {
    BasicLayout()
}

@Composable
fun Spacing() {
    Spacer(modifier = Modifier.padding(8.dp))
}

@Composable
fun ColumnAlignment() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(horizontalAlignment = Alignment.Start) {
            Text(text = "Start")
            Spacing()
            ButtonA()
            Spacing()
            ButtonB()
            Spacing()
            ButtonC()
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "CenterHorizontally")
            Spacing()
            ButtonA()
            Spacing()
            ButtonB()
            Spacing()
            ButtonC()
        }
        Column(horizontalAlignment = Alignment.End) {
            Text(text = "End")
            Spacing()
            ButtonA()
            Spacing()
            ButtonB()
            Spacing()
            ButtonC()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ColumnAlignmentPreview() {
    ColumnAlignment()
}

@Composable
fun RowAlignment() {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Top                      ")
            ButtonA()
            ButtonB()
            ButtonC()
        }
        Spacing()
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "CenterVertically")
            ButtonA()
            ButtonB()
            ButtonC()
        }
        Spacing()
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Bottom                ")
            ButtonA()
            ButtonB()
            ButtonC()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RowAlignmentPreview() {
    RowAlignment()
}

@Composable
fun BoxAlignment() {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        ButtonWithText(text = "Top Start", modifier = Modifier.align(Alignment.TopStart))
        ButtonWithText(text = "Top Center", modifier = Modifier.align(Alignment.TopCenter))
        ButtonWithText(text = "Top End", modifier = Modifier.align(Alignment.TopEnd))
        ButtonWithText(text = "Center Start", modifier = Modifier.align(Alignment.CenterStart))
        ButtonWithText(text = "Center", modifier = Modifier.align(Alignment.Center))
        ButtonWithText(text = "Center End", modifier = Modifier.align(Alignment.CenterEnd))
        ButtonWithText(text = "Bottom Start", modifier = Modifier.align(Alignment.BottomStart))
        ButtonWithText(text = "Bottom Center", modifier = Modifier.align(Alignment.BottomCenter))
        ButtonWithText(text = "Bottom End", modifier = Modifier.align(Alignment.BottomEnd))
    }
}

@Preview(showBackground = true, widthDp = 500, heightDp = 200)
@Composable
fun BoxAlignmentPreview() {
    BoxAlignment()
}

@Composable
fun ButtonWithText(text: String, modifier: Modifier) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.purple_500)),
        modifier = modifier.padding(4.dp)
    ) {
        Text(text = text, textAlign = TextAlign.Center)
    }
}

@Composable
fun Arrangement() {
    Column(modifier = Modifier.fillMaxWidth()) {
        RowButtonMaxWidth(Arrangement.Start)
        RowButtonMaxWidth(Arrangement.End)
        RowButtonMaxWidth(Arrangement.Center)
        RowButtonMaxWidth(Arrangement.SpaceBetween)
        RowButtonMaxWidth(Arrangement.SpaceEvenly)
    }
}

@Preview(showBackground = true)
@Composable
fun ArrangementPreview() {
    Arrangement()
}

@Composable
fun RowButtonMaxWidth(arrangement: Arrangement.Horizontal = Arrangement.Start) {
    Row(
        horizontalArrangement = arrangement, modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        ButtonC("")
        Spacing()
        ButtonC("")
        Spacing()
        ButtonC("")
    }
}

@Composable
fun Weight() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {

    }
}

@Preview(showBackground = true)
@Composable
fun WeightPreview() {
    Weight()
}