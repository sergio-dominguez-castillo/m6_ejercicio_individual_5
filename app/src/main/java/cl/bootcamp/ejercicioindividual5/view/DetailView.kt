package cl.bootcamp.ejercicioindividual5.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.bootcamp.ejercicioindividual5.components.MainImage
import cl.bootcamp.ejercicioindividual5.components.MainTopBar
import cl.bootcamp.ejercicioindividual5.viewModel.ArticlesViewModel

@Composable
fun DetailView(
    viewModel: ArticlesViewModel,
    navController: NavController,
    name: String?,
    author: String?,
    title: String?,
    description: String?,
    url: String?,
    urlToImage: String?

) {

    Scaffold(
        topBar = {
            MainTopBar(title = "API Article Detail", onClickBackButton = {})
        }
    ) {
        ContentDetailView(it, viewModel, navController,
            name, author, title, description, url, urlToImage )
    }
}

@Composable
fun ContentDetailView(
    paddingValues: PaddingValues,
    viewModel: ArticlesViewModel,
    navController: NavController,
    name: String?,
    author: String?,
    title: String?,
    description: String?,
    url: String?,
    urlToImage: String?
) {

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .verticalScroll(rememberScrollState(0))
    ) {

                if (description != null) {
                    Text(text = description)
                }
                Spacer(modifier = Modifier.height(30.dp))

    }
}