package com.learn.jetpack.jetcoffee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learn.jetpack.jetcoffee.model.Menu
import com.learn.jetpack.jetcoffee.model.dummyBestSellerMenu
import com.learn.jetpack.jetcoffee.model.dummyCategory
import com.learn.jetpack.jetcoffee.model.dummyMenu
import com.learn.jetpack.jetcoffee.ui.components.CategoryItem
import com.learn.jetpack.jetcoffee.ui.components.MenuItem
import com.learn.jetpack.jetcoffee.ui.components.Search
import com.learn.jetpack.jetcoffee.ui.components.SectionText
import com.learn.jetpack.jetcoffee.ui.theme.JetCoffeeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetCoffeeTheme {
                JetCoffeeApp()
            }
        }
    }
}

@Composable
fun Banner(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Banner Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(160.dp)
        )
        Search()
    }
}

@Composable
fun JetCoffeeApp() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Banner()
        SectionText(title = stringResource(R.string.section_category))
        CategoryRow()
        SectionText(title = stringResource(R.string.section_favorite_menu))
        MenuRow(listMenu = dummyMenu)
        SectionText(title = stringResource(R.string.section_best_seller_menu))
        MenuRow(listMenu = dummyBestSellerMenu)
    }
}

@Composable
fun CategoryRow(modifier: Modifier = Modifier) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(dummyCategory, key = { it.textCategory }) { category ->
            CategoryItem(category)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryRowPreview() {
    JetCoffeeTheme {
        CategoryRow()
    }
}

@Composable
fun MenuRow(
    listMenu: List<Menu>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(listMenu, key = { it.title }) { menu ->
            MenuItem(menu)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuRowPreview() {
    JetCoffeeTheme {
        MenuRow(listMenu = dummyMenu)
    }
}

@Preview(showBackground = true)
@Composable
fun JetCoffeeAppPreview() {
    JetCoffeeTheme {
        JetCoffeeApp()
    }
}
