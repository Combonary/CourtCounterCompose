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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.courtcountercompose.ui.theme.CourtCounterComposeTheme

@Composable
fun CourtCounterScreen(
    onBackClicked: () -> Unit,
    viewModel: CourtCounterViewModel = viewModel()
) {
    val scoreA by viewModel.scoreA.collectAsStateWithLifecycle()
    val scoreB by viewModel.scoreB.collectAsStateWithLifecycle()

    CourtCounterScreenContent(
        onBackClicked = onBackClicked,
        scoreA = scoreA,
        scoreB = scoreB,
        onTeamAFreeThrowClicked = { viewModel.countAFreeThrowShot() },
        onTeamBFreeThrowClicked = { viewModel.countBFreeThrowShot() },
        onTeamAShotClicked = { viewModel.countAShot() },
        onTeamBShotClicked = { viewModel.countBShot() },
        onTeamAThreeClicked = { viewModel.countAThreePointShot() },
        onTeamBThreeClicked = { viewModel.countBThreePointShot() },
        onResetClicked = { viewModel.resetGame() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourtCounterScreenContent(
    onBackClicked: () -> Unit,
    scoreA: Int,
    scoreB: Int,
    onTeamAFreeThrowClicked: () -> Unit,
    onTeamBFreeThrowClicked: () -> Unit,
    onTeamAShotClicked: () -> Unit,
    onTeamBShotClicked: () -> Unit,
    onTeamAThreeClicked: () -> Unit,
    onTeamBThreeClicked: () -> Unit,
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
                            Icon(Icons.Outlined.ArrowBack, null)
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
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState()),
                color = MaterialTheme.colorScheme.background
            ) {
                Column (
                    modifier = Modifier.wrapContentHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
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
                                onClick = { onTeamAShotClicked() }
                            ) {
                                Text(text = "2 Points")
                            }
                        }

                        Column {
                            Button(
                                modifier = Modifier.width(120.dp),
                                onClick = { onTeamBShotClicked() }
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
                                onClick = { onTeamAThreeClicked() }
                            ) {
                                Text(text = "3 Points")
                            }
                        }

                        Column {
                            Button(
                                modifier = Modifier.width(120.dp),
                                onClick = { onTeamBThreeClicked() }
                            ) {
                                Text(text = "3 Points")
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
                                onClick = { onTeamAFreeThrowClicked() }
                            ) {
                                Text(text = "Free Throw")
                            }
                        }

                        Column {
                            Button(
                                modifier = Modifier.width(120.dp),
                                onClick = { onTeamBFreeThrowClicked() }
                            ) {
                                Text(text = "Free Throw")
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