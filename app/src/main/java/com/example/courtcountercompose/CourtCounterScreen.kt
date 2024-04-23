package com.example.courtcountercompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.courtcountercompose.ui.theme.CourtCounterComposeTheme

@Composable
fun CourtCounterScreen(
    onBackClicked: () -> Unit,
    viewModel: CourtCounterViewModel = CourtCounterViewModel()
) {
    val scoreA by viewModel.scoreA.collectAsState()

    val scoreB by viewModel.scoreB.collectAsState()

    CourtCounterScreenContent(
        onBackClicked = onBackClicked,
        scoreA = scoreA,
        scoreB = scoreB,
        onTeamAShotClicked = { viewModel.countShot(it) },
        onTeamBShotClicked = { viewModel.countShot(it) },
        onTeamAThreeClicked = { viewModel.countThreePointShot(it) },
        onTeamBThreeClicked = { viewModel.countThreePointShot(it) },
        onResetClicked = { viewModel.resetGame() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourtCounterScreenContent(
    onBackClicked: () -> Unit,
    scoreA: Int,
    scoreB: Int,
    onTeamAShotClicked: (Char) -> Unit,
    onTeamBShotClicked: (Char) -> Unit,
    onTeamAThreeClicked: (Char) -> Unit,
    onTeamBThreeClicked: (Char) -> Unit,
    onResetClicked: () -> Unit
) {
    CourtCounterComposeTheme {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = "Court Counter"
                        )
                            },
                    navigationIcon = {
                        IconButton(
                            onClick = onBackClicked
                        ) {
                            Icon(Icons.AutoMirrored.Outlined.ArrowBack, null)
                        }
                    }
                )
            },
            bottomBar = {
                BottomAppBar {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = onResetClicked
                    ) {
                        Text(text = "Reset")
                    }
                }
            }
        ) { paddingValues ->

            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                color = MaterialTheme.colorScheme.background
            ) {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Column {
                            Text(text = "Team A")
                            Text(
                                modifier = Modifier.align(Alignment.CenterHorizontally),
                                text = scoreA.toString(),
                                fontSize = 36.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Column {
                            Text(text = "Team B")
                            Text(
                                modifier = Modifier.align(Alignment.CenterHorizontally),
                                text = scoreB.toString(),
                                fontSize = 36.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Column {
                            Button(
                                modifier = Modifier.width(120.dp),
                                onClick = { onTeamAShotClicked('A') }
                            ) {
                                Text(text = "2 Points")
                            }
                        }

                        Column {
                            Button(
                                modifier = Modifier.width(120.dp),
                                onClick = { onTeamBShotClicked('B') }
                            ) {
                                Text(text = "2 Points")
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Column {
                            Button(
                                modifier = Modifier.width(120.dp),
                                onClick = { onTeamAThreeClicked('A') }
                            ) {
                                Text(text = "3 Points")
                            }
                        }

                        Column {
                            Button(
                                modifier = Modifier.width(120.dp),
                                onClick = { onTeamBThreeClicked('B') }
                            ) {
                                Text(text = "3 Points")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun CourtCounterScreenPreview() {
    CourtCounterScreen(
        onBackClicked = {  },
        viewModel = CourtCounterViewModel()
    )
}